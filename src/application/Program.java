package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Student;
import entities.StudentRegistration;

public class Program {

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		boolean exit = false;
		StudentRegistration studentRegistration = new StudentRegistration();

		while (true) {
			System.out.println("Welcome to the Student Registration System!");
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

			try {
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
						int registrationNumber = sc.nextInt();
						while (studentRegistration.checkRegistration(registrationNumber) == true) {
							System.out.print("Registration number already taken. Please choose another: ");
							registrationNumber = sc.nextInt();
						}
						System.out.print("Phone Number: ");
						int phoneNumber = sc.nextInt();

						studentRegistration.addStudent(name, age, registrationNumber, phoneNumber);

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
					break;
				}
				// Find student
				case 2: {
					System.out.println();
					if (!studentRegistration.isThereStudents()) {
						System.out.println("There are no students to find.");
						pressEnter();
					} else {
						System.out.print("Enter the registration number of the student: ");
						int registrationNumber = sc.nextInt();
						Student foundStudent = studentRegistration.findStudent(registrationNumber);
						if (foundStudent != null) {
							System.out.println(foundStudent);
							pressEnter();
						} else {
							System.out.println("Student not found.");
							pressEnter();
						}
					}
					break;
				}
				// Show all students
				case 3: {
					System.out.println();
					if (!studentRegistration.isThereStudents()) {
						System.out.println("There are no students to show.");
						pressEnter();
					} else {
						studentRegistration.showStudents();
						pressEnter();
					}
					break;
				}
				// update student
				case 4: {
					System.out.println();
					if (!studentRegistration.isThereStudents()) {
						System.out.println("There are no students to update.");
						pressEnter();
					} else {
						System.out.print("Enter the registration number of the student: ");
						int registrationNumber = sc.nextInt();
						Student foundStudent = studentRegistration.findStudent(registrationNumber);
						if (foundStudent == null) {
							System.out.println("Student not found.");
							pressEnter();
						} else {
							System.out.println("(1) Name: " + foundStudent.getName());
							System.out.println("(2) Age: " + foundStudent.getAge());
							System.out.println("(3) Registration N.: " + foundStudent.getRegistration());
							System.out.println("(4) Phone Number: " + foundStudent.getPhoneNumber());
							System.out.println();
							System.out.println("Which field will be updated? ");
							int field = sc.nextInt();
							studentRegistration.updateStudent(foundStudent, field, sc);
						}
					}
					pressEnter();
					System.out.println();
					break;
				}
				// Remove student
				case 5: {
					System.out.println();
					if (!studentRegistration.isThereStudents()) {
						System.out.println("There are no students to remove.");
						pressEnter();
					} else {
						System.out.print("Enter the registration number of the student: ");
						int registrationNumber = sc.nextInt();
						studentRegistration.removeStudent(registrationNumber);
						pressEnter();
					}
					break;
				}
				// Import CSV
				case 6: {
					System.out.println("Import from CSV");
					System.out.print("Directory path where the CSV is. ex(c:\\temp\\StudentData): ");
					sc.nextLine();
					String strPath = sc.nextLine();

					studentRegistration.importCSV(strPath);
					pressEnter();
					break;
				}
				// Export CSV
				case 7: {
					System.out.println("Export to CSV");
					System.out.print("Directory path ex(c:\\temp\\StudentData): ");
					sc.nextLine();
					String strPath = sc.nextLine();

					studentRegistration.exportCSV(strPath);
					pressEnter();
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
					pressEnter();
					break;
				}
				}

				if (exit == true) {
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please enter integer numbers.");
				pressEnter();
				System.out.println();
			} catch (RuntimeException e) {
				System.out.println("Unexpected error.");
				pressEnter();
				System.out.println();
			}
			clearScreen();
		}

		sc.close();

	}

	// input 'Press Enter to continue function' to user
	public static void pressEnter() {
		System.out.print("Press Enter key to continue... ");
		sc.nextLine(); // 'Eats' the line that comes
		System.out.println(sc.nextLine());
	}

	// Clears the console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
