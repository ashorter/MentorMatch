package com.example.ashley.mentormatch;

/**
 * Created by Ashley on 5/14/2017.
 */

public class UserInformation {
    private String name;
    private String university;
    private String location;

    public UserInformation() {
      /*Blank default constructor essential for Firebase*/
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
