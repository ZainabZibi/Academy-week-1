
package com.bptn.course.FootballAcademy;
import java.util.*;

class Participant {
    private String fullName;
    private String email;
    private String username;
    private int age;
    private String team;
    private String matchViewingService;

    public Participant(String fullName, String email, String username, int age) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.age = age;
        this.team = assignTeam(age);
    }

    private String assignTeam(int age) {
        if (age >= 9 && age <= 11) return "U13";
        else if (age >= 12 && age <= 14) return "U15";
        else if (age >= 15 && age <= 17) return "U18";
        return "Not eligible";
    }

    public String getUsername() {
        return username;
    }

    public String getTeam() {
        return team;
    }

    public void setMatchViewingService(String service) {
        this.matchViewingService = service;
    }

    @Override
    public String toString() {
        return "Username: " + username + " | Name: " + fullName + " | Age: " + age + " | Team: " + team +
                " | Match Viewing: " + (matchViewingService != null ? matchViewingService : "Not Selected");
    }
}


