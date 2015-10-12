package methodrefs;

import java.util.function.Supplier;

public class MethodReferences {

    interface FI {
        void apply(MethodReferences mr);
    }

    static MethodReferences create(Supplier<MethodReferences> supplier) {
        return supplier.get();
    }

    static void staticMethod(MethodReferences mr) {
        System.out.println("static " + mr);
    }

    void instanceMethod(MethodReferences mr) {
        System.out.println("instance " + mr);
    }

    public static void main(String[] args) {
        FI f = MethodReferences::staticMethod;
        System.out.println(f.getClass().getInterfaces());
        Class[] classes = f.getClass().getInterfaces();
        for (Class c: classes) {
            System.out.printf(c.getName());
        }

        MethodReferences.create(MethodReferences::new);
    }
}
