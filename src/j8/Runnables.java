package j8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runnables {

    static ExecutorService service = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {


        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        });


        // No args and no results - purely side-effecting.
        Runnable r = () -> System.out.println("running...");

        // A lambda expression can be used to implement a functional interface.
        // Target typing - what type do i need and does what i have been given match...
        service.execute(r);

        service.execute(() -> System.out.println("running"));
    }


}
