package com.udemy;

import java.util.*;

public class Student {
    private static Scanner scanner = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static final int COST_OF_COURSE = 600;
    private static int id = 1000;

    public Student() {
        System.out.print("Enter student first name: ");
        this.firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        while (true) {
            if (scanner.hasNextInt()) {
                this.gradeYear = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid value, please try again");
                scanner.nextLine();
            }
        }
        setStudentID();
    }

    private void setStudentID() {
        // grade level + id
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        System.out.println("A student can be enrolled in the following courses:\n" +
                "\tHistory 101\n" +
                "\tMathematics 101\n" +
                "\tEnglish 101\n" +
                "\tChemistry 101\n" +
                "\tComputer Science 101\n");

        Set<String> subjects = new HashSet<>();
        subjects.add("History 101");
        subjects.add("Mathematics 101");
        subjects.add("English 101");
        subjects.add("Chemistry 101");
        subjects.add("Computer Science 101");

        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                String courseChecked = "";
                for (String value: subjects) {
                    if (course.equals(value)) {
                        courseChecked = value;
                        break;
                    }
                }
                if (courseChecked.equals(course)) {
                    courses = courses + "\n" + course;
                    tuitionBalance += COST_OF_COURSE;
                } else {
                    System.out.println("Course not valid, please try again.");
                }
            } else {
                break;
            }
        } while (true);
    }

    public void viewBalance() {
        System.out.println("Your balance is : $" + tuitionBalance);
    }

    public void payTuition() {
        int payment;
        while (true) {
            System.out.print("Enter your payment: $");
            if (scanner.hasNextInt()) {
                payment = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid value, please try again");
            }
        }
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
        System.out.println();
    }


    public void showInfo() {
            System.out.println("Student added: " + firstName + " " + lastName +
                    "\nYear: " + gradeYear +
                    "\nStudent ID: " + studentID +
                    "\nCourses Enrolled: " + courses +
                    "\nBalance: $" + tuitionBalance);
    }
}
