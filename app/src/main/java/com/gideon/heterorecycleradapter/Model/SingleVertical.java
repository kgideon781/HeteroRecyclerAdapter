package com.gideon.heterorecycleradapter.Model;



public class SingleVertical {

    private String place, location;
    private String image;

    public SingleVertical( ) {

    }

    public SingleVertical(String place, String location, String image) {
        this.place = place;
        this.location = location;
        this.image = image;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
