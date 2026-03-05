package org.example.designpattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Singleton: ensures a single shared instance with controlled access.
 * Use when one global point of coordination (config, cache, factory) is needed.
 * Prefer immutable state and lazy initialization for expensive resources.
 * For thread-safety prefer enum-singleton (best) or the initialization-on-demand holder idiom.
 * Double-checked locking (as implemented) works in Java 5+ only when 'instance' is declared volatile.
 * Beware serialization, reflection and cloning; protect with readResolve or other safeguards.
 */
public class Singleton {



    /**
     * private static variable reference
     * private constructor
     * public static get method
     */

    private static Singleton instance;
    private String data;

    private Singleton() {}

    public static Singleton getInstance(){
        if (instance == null){
           synchronized (Singleton.class){
               if (instance == null)
                   instance = new Singleton();
           }
        }
        return instance;
    }

}
