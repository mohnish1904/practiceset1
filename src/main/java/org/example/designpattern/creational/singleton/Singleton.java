package org.example.designpattern.creational.singleton;

/*
 * Singleton: ensures a single shared instance with controlled access.
 * Use when one global point of coordination (config, cache, factory) is needed.
 * Prefer immutable state and lazy initialization for expensive resources.
 * For thread-safety prefer enum-singleton (best) or the initialization-on-demand holder idiom.
 * Double-checked locking (as implemented) works in Java 5+ only when 'instance' is declared volatile.
 * Beware serialization, reflection and cloning; protect with readResolve or other safeguards.
 *
 * Think of a Singleton class like the Pilot of an airplane. There can be hundreds of passengers (objects), but there
 * should only ever be one person in charge of the controls at any given time. If you had two pilots trying to fly the
 * same plane independently, you'd have a disaster.
 *
 * In programming, a Singleton ensures that a class has only one instance and provides a global point of access to it.
 * This is useful for things like database connections, loggers, or configuration settings where having multiple copies
 * would waste memory or cause data conflicts.
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
