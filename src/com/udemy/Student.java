package com.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private List<Student> students = new ArrayList<>();

// make Scanner a static field to avoid code duplication


    public Student() {
    }

    public Student(String firstName, String lastName) {
//        System.out.println("Enter student first name: ");
        this.firstName = firstName;
//        System.out.println("Enter student last name: ");
        this.lastName = lastName;
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

    public int getGradeYear() {
        return gradeYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    private void setStudentID() {
        // grade level + id
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void addStudent(String firstName, String lastName) {
        students.add(new Student(firstName, lastName));
    }

    // students.add(new Student()); should be used to add a new student, but I need to find
    // a way to make a loop and any amount of student it requires. Remember on the constructor is this.students = new ArrayList<>();

    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance += COST_OF_COURSE;
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
                break;
            } else {
                System.out.println("Invalid value, please try again");
            }
            scanner.nextLine();
        }
        //-----------> created a method that prevent the exception, a method that can be called every time a prompt is requested
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }


    public void showInfo() {
        for (Student student: students) {
            System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName() +
                    "\nYear: " + student.getGradeYear() +
                    "\nStudent ID: " + student.getStudentID() +
                    "\nCourses Enrolled: " + courses +
                    "\nBalance: $" + tuitionBalance);
        }
    }
}
