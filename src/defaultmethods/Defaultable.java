package defaultmethods;

/**
 * Created by steve on 12/7/15.
 */
public interface Defaultable {

    default String print() { return "default"; }
}
