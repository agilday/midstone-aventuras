package com.nashss.se.musicplaylistservice.activity.requests;

import java.time.ZonedDateTime;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.nashss.se.musicplaylistservice.dynamodb.models.Event;

@JsonDeserialize(builder = CreateProfileRequest.Builder.class)
public class CreateProfileRequest {
    private final boolean isNew;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String location;
    private final String gender;
    private final String dateOfBirth;
//    private final Set<String> eventList;
//    private final Set<String> followerList;

    public boolean isNew() {
        return isNew;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

//    public Set<String> getEventList() {
//        return eventList;
//    }
//
//    public Set<String> getFollowerList() {
//        return followerList;
//    }



    @Override
    public String toString() {
        return "CreateProfileRequest{" +
                "isNew=" + isNew +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", location='" + location + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
//                ", eventList=" + eventList +
//                ", followerList=" + followerList +
                '}';
    }

//    private CreateProfileRequest(boolean isNew, String firstName, String lastName, String emailAddress, String location,
//                                 String gender, String dateOfBirth, Set<String> eventList, Set<String> followerList){
//        this.isNew = isNew;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.emailAddress = emailAddress;
//        this.location = location;
//        this.gender = gender;
//        this.dateOfBirth = dateOfBirth;
//        this.eventList = eventList;
//        this.followerList = followerList;
//    }
    private CreateProfileRequest(boolean isNew, String firstName, String lastName, String emailAddress, String location,
                                 String gender, String dateOfBirth){
        this.isNew = isNew;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.location = location;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    public static Builder builder() {
        return new Builder();
    }
@JsonPOJOBuilder
    public static class Builder{
    private  boolean isNew;
    private  String firstName;
    private  String lastName;
    private  String emailAddress;
    private  String location;
    private  String gender;
    private  String dateOfBirth;
    private  Set<String> eventList;
    private Set<String> followerList;

    public Builder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }
    public Builder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public Builder withEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
        return this;
    }
    public Builder withLocation(String location){
        this.location = location;
        return this;
    }
    public Builder withGender(String gender){
        this.gender = gender;
        return this;
    }
    public Builder withDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    //?? Not needed
//    public Builder withFollowing(Set<String> followerList){
//        this.followerList = followerList;
//        return this;
//    }
//    public Builder withEvents(Set<String> eventList){
//        this.eventList = eventList;
//        return this;
//    }
    public CreateProfileRequest build(){
//        return new CreateProfileRequest(isNew,firstName,lastName,emailAddress,location,gender,dateOfBirth,eventList,followerList);
        return new CreateProfileRequest(isNew,firstName,lastName,emailAddress,location,gender,dateOfBirth);
    }


}

    
}