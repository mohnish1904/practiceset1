package org.example.designpattern.structural.observer;

public class Observer {

    public static void main(String[] args) {
        Fan kuro = new Fan("kuro");
        Fan muzy = new Fan("Muzy");

        YoutubeChannel channel1 = new YoutubeChannel();
        channel1.subscribe(kuro);
        channel1.subscribe(muzy);

        channel1.upload("10 Amazing facts");
    }
}
