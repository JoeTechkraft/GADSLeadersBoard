package com.jonathan.gadsleadersboard.models;

public class SubmissionRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String url;

    public SubmissionRequest(String firstName, String lastName, String email, String url) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.url = url;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }
}
