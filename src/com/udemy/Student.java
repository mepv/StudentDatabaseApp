package com.udemy;

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

    public Student() {
        System.out.println("Enter student first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter student last name: ");
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

//    public void addStudent(String firstName, String lastName) {  //     addStudent(Student student) { students.add(student }
//        students.add(new Student(firstName, lastName));
//    }

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
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid value, please try again");
            }
        }
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }


    public void showInfo() {
            System.out.println("Student added: " + firstName + " " + lastName +
                    "\nYear: " + gradeYear +
                    "\nStudent ID: " + studentID +
                    "\nCourses Enrolled: " + courses +
                    "\nBalance: $" + tuitionBalance);
    }
}
