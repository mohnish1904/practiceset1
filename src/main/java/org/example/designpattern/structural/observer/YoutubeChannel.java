package org.example.designpattern.structural.observer;

import java.util.ArrayList;

public class YoutubeChannel {

    private ArrayList<Subscriber> fans = new ArrayList<>();

    public void subscribe(Subscriber fan){
        fans.add(fan);
    }

    public void upload(String title){
        // For each fan send the video tile
        for (Subscriber fan : fans){
            fan.update(title);
        }
    }
}
