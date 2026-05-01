package org.example.designpattern.structural.observer;

public class Fan implements Subscriber{

    private final String name;

    public Fan(String name){
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Hi " + name + " !!!, New Video has been uploaded : "+ videoTitle);
    }
}
