package org.example.designpattern.creational.singleton;

public class SingletonTest {


    /**
     * Singleton class has the following properties
     * 1. private static variable : teh object should belong to the class, and initialized during class loading, volatile helps with visibility across the threads
     * 2. private constructor : so that no one can create any other instance
     * 3. public getInstance Method : since constructor is blocked
     */


    private static volatile SingletonTest instance;

    private SingletonTest(){};

    public SingletonTest getInstance(){
        if (instance == null){
            synchronized (SingletonTest.class){
                if (instance==null){
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }


}
