package j8;

public class DefaultMethods {

    interface D1 {
        default String m() { return "D1"; }
    }

    interface D2 {
        default String m() { return "D2"; }
    }

    interface D3 extends D1, D2 {
        // Must re-declare
        String m();
        //default String m() { return "D3"; };
    }

    class C1 implements D1 {
        @Override public String toString() { return m(); }
    }

    class C2 implements D1, D2 {
        // Must override
        public String m() { return "C1"; }
    }
}
