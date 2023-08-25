package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Student> students = new ArrayList<>();
		boolean exit = false;
		System.out.println("Welcome to the Student Registration System!");

		while (true) {
			System.out.println();
			System.out.println("(1) Register a new student");
			System.out.println("(2) Find a student");
			System.out.println("(3) Show all students");
			System.out.println("(4) Update a student");
			System.out.println("(5) Remove a student");
			System.out.println("(6) Import CSV");
			System.out.println("(7) Export CSV");
			System.out.println("(8) Exit the program");
			System.out.println();
			System.out.print("Please choose your desired option: ");

			int choice = sc.nextInt();
			switch (choice) {
			// Add new student
			case 1: {
				while (true) {
					System.out.println();
					System.out.println("Registering a new Student");
					sc.nextLine();
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.print("Age: ");
					int age = sc.nextInt();
					System.out.print("Registration number: ");
					int registration = sc.nextInt();
					System.out.print("Phone Number: ");
					int phoneNumber = sc.nextInt();

					students.add(new Student(name, age, registration, phoneNumber));

					System.out.println("Student registered successfully!");
					System.out.print("Do you wish to register another student? (Y/N): ");
					sc.nextLine();
					char answer = sc.next().toUpperCase().charAt(0);
					while (answer != 'Y' && answer != 'N') {
						System.out.print("Invalid! Choose a valid answer (Y/N): ");
						answer = sc.next().toUpperCase().charAt(0);
					}
					if (answer == 'N') {
						break;
					}
				}
			}
			// Find student
			case 2: {
				// 
				break;
			}
			// Show all students
			case 3: {
				System.out.println();
				int i = 1;
				for (Student student : students) {
					System.out.println("Student " + i);
					System.out.println(student);
					i++;
				}
				pressEnter();
				break;
			}
			// update student
			case 4: {
				break;
			}
			// Remove student
			case 5: {
				break;
			}
			// Import CSV
			case 6: {
				break;
			}
			// Export CSV
			case 7: {
				break;
			}

			// Exit
			case 8: {
				System.out.println();
				System.out.println("Have a nice day!");
				exit = true;
				break;
			}
			// Invalid option
			default: {
				System.out.println("Invalid option! Please, choose a valid option.");
				break;
			}
			}

			if (exit == true) {
				break;
			}
		}

		sc.close();

	}

	public static void pressEnter() { // Press Enter to continue function
		System.out.print("Press Enter key to continue... ");
		@SuppressWarnings("resource") // Remove warning about not closing the scanner
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		// Won't close the scanner otherwise we will have problems in the main program
	}
}
