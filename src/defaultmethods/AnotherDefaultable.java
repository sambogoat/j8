package defaultmethods;

/**
 * Created by steve on 12/7/15.
 */
public interface AnotherDefaultable {

    // Cannot leave abstract here AND in Implementor.

    //String print();

    default String print() { return "another default"; }
}
