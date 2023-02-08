package dev.jlkesh.library.library.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncSupplier {
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public static void run(Runnable runnable) {
        EXECUTOR_SERVICE.execute(runnable);
    }

}
