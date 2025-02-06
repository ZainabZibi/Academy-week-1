/**
 * 
 */
package com.bptn.course.FootballAcademy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FootballAcademy {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Participant> participants = new ArrayList<>();
    private static final Set<String> usernames = new HashSet<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nFootball Academy Registration System");
            System.out.println("1. Sign Up");
            System.out.println("2. Choose Match Viewing Service");
            System.out.println("3. View Registered Participants");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> signUp();
                case 2 -> selectMatchViewing();
                case 3 -> displayParticipants();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void signUp() {
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        String username;
        while (true) {
            System.out.print("Choose a unique username: ");
            username = scanner.nextLine();
            if (usernames.contains(username)) {
                System.out.println("Username already taken. Try another.");
            } else {
                usernames.add(username);
                break;
            }
        }
        
        int age;
        while (true) {
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            if (age < 9 || age > 17) {
                System.out.println("Sorry, only ages 9-17 are eligible.");
                return;
            }
            break;
        }
        
        Participant participant = new Participant(fullName, email, username, age);
        participants.add(participant);
        System.out.println("Registration successful! Assigned to: " + participant.getTeam());
    }

    private static void selectMatchViewing() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        Participant participant = findParticipant(username);
        
        if (participant == null) {
            System.out.println("User not found. Please sign up first.");
            return;
        }

        System.out.println("Choose a match viewing service:");
        System.out.println("1. Monarch Stadium");
        System.out.println("2. Lamport Stadium");
        System.out.println("3. Varsity Stadium");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        String service = switch (choice) {
            case 1 -> "Monarch Stadium";
            case 2 -> "Lamport Stadium";
            case 3 -> "Varsity Stadium";
            default -> {
                System.out.println("Invalid choice. Try again.");
                yield null;
            }
        };
        
        if (service != null) {
            participant.setMatchViewingService(service);
            System.out.println("Match viewing service set to " + service);
        }
    }

    private static void displayParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants registered yet.");
            return;
        }
        for (Participant p : participants) {
            System.out.println(p);
        }
    }

    private static Participant findParticipant(String username) {
        for (Participant p : participants) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }
}
