package defaultmethods;

/**
 * Created by steve on 12/7/15.
 */
public class Implementor implements Defaultable, AnotherDefaultable {

    // Must override, otherwise compile error.

    public String print() { return "override"; }
}
