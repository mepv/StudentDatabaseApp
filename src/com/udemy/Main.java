package com.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		List<Student> students = new ArrayList<>();

	    while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("For Add a new Student press A.\nFor Quit press Q.");

	    	if (!scanner.nextLine().equals("Q")) {
	    		Student student = new Student();
				students.add(student);
				student.enroll();
				student.payTuition();
	    	} else {
	    		break;
			}
		}
	    for (Student student: students) {
			student.showInfo();
			System.out.println("==============================");
		}

    }
}
