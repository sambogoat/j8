package streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.stream.Stream;

import domain.MarketDependencyService;

/**
 * Created by steve on 5/10/15.
 *
 * TODO
 *  MarketService: Market getMarket(List<String> deps)
 */
public class DependencyStreams {

    static MarketDependencyService service = new MarketDependencyService() {
        public List<String> calculateDependencies(String tradeId) {
            return Arrays.asList(
                    "d1-" + tradeId,
                    "d2-" + tradeId,
                    "d3-" + tradeId);
        }
    };

    static ExecutorService executor = Executors.newFixedThreadPool(10);

    // ExecutorService - blocking

    public static List<String> getDependencies(List<String> tradeIds) throws Exception {

        Callable<List<String>> task = () -> tradeIds.stream()
                .map(service::calculateDependencies)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Future<List<String>> fdeps = executor.submit(task);

        return fdeps.get();
    }

    // CompletionService
    // The platform implementation of this interface, ExecutorCompletionService, achieves this by wrapping each task in a FutureTask,
    // a Future implementation that additionally allows a completion callback to be supplied.
    // The callback action specified to the Futures created in ExecutorCompletionService encapsulate the addition of
    // the completed task to a queue, ready for a client to interrogate.
    public static List<String> getDependenciesCS(List<String> tradeIds) throws Exception {

        CompletionService<List<String>> cs = new ExecutorCompletionService<>(executor);

        tradeIds.forEach(tid ->
                cs.submit(() -> service.calculateDependencies(tid)));


    }

    public static void main(String[] args) throws Exception {

        List<String> tradeIds = Arrays.asList("t1", "t2", "t3");
        System.out.println(getDependencies(tradeIds));
    }
}
