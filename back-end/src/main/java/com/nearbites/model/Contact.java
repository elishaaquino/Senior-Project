package com.nearbites.model;

import java.net.URL;

public class Contact {

    private String phoneNumber;
    private String email;
    private String instagramHandle;
    private URL facebookUrl;

    public Contact() {

    }

    public Contact(String phoneNumber, String email, String instagramHandle, URL facebookUrl) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.instagramHandle = instagramHandle;
        this.facebookUrl = facebookUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    public URL getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(URL facebookUrl) {
        this.facebookUrl = facebookUrl;
    }
}
