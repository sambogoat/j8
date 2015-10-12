package domain;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by steve on 5/10/15.
 */
public interface MarketDependencyService {

    // Blocking
    List<String> calculateDependencies(String tradeId);

}
