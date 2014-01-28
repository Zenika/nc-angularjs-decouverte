package com.zenika.nc.angular.mybottles.domain;

public class Bottle {
    private int id;
    private String name;
    private String description;
    private int rate;
    private String picture;

    public Bottle() {}

    public Bottle(String name, String description, int rate) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.picture = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                ", picture='" + picture + '\'' +
                '}';
    }
}
