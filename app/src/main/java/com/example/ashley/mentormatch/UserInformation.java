package com.example.ashley.mentormatch;

/**
 * Created by Ashley on 5/14/2017.
 */

public class UserInformation {

    public String name;
    public String interest;
    public String number;

    public UserInformation(){

    }

    public UserInformation(String name, String number, String interest) {
        this.name = name;
        this.number = number;
        this.interest = interest;
    }
}
