package j8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutures {

    public static void main(String[] args) {

        // Completed with a value
        CompletableFuture<String> f1 = new CompletableFuture<>();
        f1.complete("foo");

        // Created with a Runnable or Supplier
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "foo");
        CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> System.out.println("foo"));

        // Transform (ie map)s
        f2.thenApply(String::toUpperCase);

        // Used to run code on completion
        f2.thenAccept(System.out::println);
    }
}
