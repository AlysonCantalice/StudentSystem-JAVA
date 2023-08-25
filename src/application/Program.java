package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
					while (checkRegistration(students, registrationNumber) == true) {
						System.out.print("Registration number already taken. Please choose another: ");
						registrationNumber = sc.nextInt();
					}
					System.out.print("Phone Number: ");
					int phoneNumber = sc.nextInt();

					students.add(new Student(name, age, registrationNumber, phoneNumber));

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
				if (students.size() == 0) {
					System.out.println("There are no students to find.");
					pressEnter();
				} else {
					System.out.print("Enter the registration number of the student: ");
					int registrationNumber = sc.nextInt();
					boolean found = false;
					for (Student student : students) {
						if (student.getRegistration() == registrationNumber) {
							System.out.println(student);
							found = true;
							pressEnter();
							break;
						}
					}
					if (found == false) {
						System.out.println("Student not found.");
						pressEnter();
					}
				}
				break;
			}
			// Show all students
			case 3: {
				System.out.println();
				if (students.size() == 0) {
					System.out.println("There are no students to show.");
					pressEnter();
				} else {
					int i = 1;
					for (Student student : students) {
						System.out.println("Student " + i);
						System.out.println(student);
						i++;
					}
					pressEnter();
				}
				break;
			}
			// update student
			case 4: {
				System.out.println();
				if (students.size() == 0) {
					System.out.println("There are no students to update.");
					pressEnter();
				} else {
					System.out.print("Enter the registration number of the student: ");
					int registrationNumber = sc.nextInt();
					Student foundStudent = null;
					for (Student student : students) {
						if (student.getRegistration() == registrationNumber) {
							foundStudent = student;
							break;
						}
					}
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
						int answer = sc.nextInt();

						switch (answer) {
						case 1: {
							System.out.print("New name: ");
							sc.nextLine();
							String name = sc.nextLine();
							foundStudent.setName(name);
							System.out.println("Name updated.");
							pressEnter();
							break;
						}
						case 2: {
							System.out.print("New age: ");
							sc.nextLine();
							int age = sc.nextInt();
							foundStudent.setAge(age);
							System.out.println("Age updated.");
							pressEnter();
							break;
						}
						case 3: {
							System.out.print("New registration number: ");
							sc.nextLine();
							registrationNumber = sc.nextInt();
							while (checkRegistration(students, registrationNumber) == true) {
								System.out.print("Registration number already taken. Please choose another: ");
								registrationNumber = sc.nextInt();
							}
							foundStudent.setRegistration(registrationNumber);
							System.out.println("Registration number updated.");
							pressEnter();
							break;
						}
						case 4: {
							System.out.print("New phone number: ");
							sc.nextLine();
							int phoneNumber = sc.nextInt();
							foundStudent.setPhoneNumber(phoneNumber);
							System.out.println("Phone Number updated.");
							pressEnter();
							break;
						}
						}
					}
				}
				break;
			}
			// Remove student
			case 5: {
				System.out.println();
				if (students.size() == 0) {
					System.out.println("There are no students to remove.");
					pressEnter();
				} else {
					System.out.print("Enter the registration number of the student: ");
					int registrationNumber = sc.nextInt();
					boolean found = false;
					for (Student student : students) {
						if (student.getRegistration() == registrationNumber) {
							students.remove(student);
							found = true;
							System.out.println("Student removed.");
							pressEnter();
							break;
						}
					}
					if (found == false) {
						System.out.println("Student not found.");
						pressEnter();
					}
				}
				break;
			}
			// Import CSV
			case 6: {
				System.out.println("Import from CSV");
				System.out.print("Directory path where the CSV is. ex(c:\\\\temp\\\\StudentData): ");
				sc.nextLine();
				String strPath = sc.nextLine();

				File file = new File(strPath + "\\StudentData.csv");
				if (!file.exists()) {
					System.out.println("There is no file to import.");
					pressEnter();
				} else {
					try (BufferedReader br = new BufferedReader(new FileReader(file))) {
						String line = br.readLine();
						while (line != null) {
							String[] tmp = line.split(",");
							students.add(new Student(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]),
									Integer.parseInt(tmp[3])));
							line = br.readLine();
						}
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
						pressEnter();
					} finally {
						System.out.println("Data import successfully!");
						pressEnter();
					}
				}
				break;
			}
			// Export CSV
			case 7: {
				System.out.println("Export to CSV");
				System.out.print("Directory path ex(c:\\\\temp\\\\StudentData): ");
				sc.nextLine();
				String strPath = sc.nextLine();

				File file = new File(strPath);
				if (!file.exists()) { // Check whether the directory exists, if not create it
					file.mkdir();
				}

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath + "\\StudentData.csv"))) {
					for (Student student : students) {
						bw.write(student.toCSV());
						bw.newLine();
					}
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
					pressEnter();
				}
				finally {
					System.out.println("Data exported successfully!");
					pressEnter();
				}
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

			if (exit == true)

			{
				break;
			}

			clearScreen();

		}

		sc.close();

	}

	// input 'Press Enter to continue function' to user
	public static void pressEnter() {
		System.out.print("Press Enter key to continue... ");
		@SuppressWarnings("resource") // Remove warning about not closing the scanner
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		// Won't close the scanner otherwise we will have problems in the main program
	}
	
	// Clears the console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	// Check whether a registration is already being used by another student
	public static boolean checkRegistration(List<Student> students, int registrationNumber) { 
		boolean exists = false;
		for (Student student : students) {
			if (student.getRegistration() == registrationNumber) {
				exists = true;
			}
		}
		return exists;
	}
}
