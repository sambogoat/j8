package j8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callables {

    static ExecutorService service = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {


        Future<String> fut1 = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "foo";
            }
        });


        Callable<String> c = () -> "foo";

        Future<String> fut2 = service.submit(c);

        service.submit(() -> "foo");

    }


}
