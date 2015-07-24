package com.example.marknguyen.bulletyntesting;

/**
 * Created by Binh on 7/14/2015.
 */

public class Event {
    // Define attributes of an event
    public String category;
    public String email;
    public String hashtag;
    public String img;
    public String info;
    public String location;
    public String name;
    public String phone;
    public String title;

    // Create a constructor
    public Event(String eventCategory, String eventEmail,
                 String eventHashtag, String eventImg,
                 String eventInfo, String eventLocation,
                 String eventName, String eventPhone,
                 String eventTitle) {
        this.category = eventCategory;
        this.email = eventEmail;
        this.hashtag = eventHashtag;
        this.img = eventImg;
        this.info = eventInfo;
        this.location = eventLocation;
        this.name = eventName;
        this.phone = eventPhone;
        this.title = eventTitle;
    }
}
