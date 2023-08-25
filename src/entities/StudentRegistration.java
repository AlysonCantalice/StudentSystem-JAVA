package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentRegistration {

	Student students = new Student();

	// Check whether a registration is already being used by another student
	public boolean checkRegistration(int registrationNumber) {
		boolean exists = false;
		for (Student student : students.getStudents()) {
			if (student.getRegistration() == registrationNumber) {
				exists = true;
			}
		}
		return exists;
	}

	public void addStudent(String name, int age, int registrationNumber, int phoneNumber) {
		students.getStudents().add(new Student(name, age, registrationNumber, phoneNumber));
	}

	public void showStudents() {
		int i = 1;
		for (Student student : students.getStudents()) {
			System.out.println("Student " + i);
			System.out.println(student);
			i++;
		}
	}

	public Student findStudent(int registrationNumber) {
		for (Student student : students.getStudents()) {
			if (student.getRegistration() == registrationNumber) {
				return student;
			}
		}
		return null;
	}

	public void removeStudent(int registrationNumber) {
		if (findStudent(registrationNumber) == null) {
			System.out.println("Student not found.");
		} else {
			students.getStudents().remove(findStudent(registrationNumber));
			System.out.println("Student removed.");
		}
	}

	public boolean isThereStudents() {
		if (students.getStudents().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void importCSV(String strPath) {
		File file = new File(strPath + "\\StudentData.csv");
		if (!file.exists()) {
			System.out.println("There is no file to import.");
		} else {
			clearStudents();
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line = br.readLine();
				while (line != null) {
					String[] tmp = line.split(",");
					addStudent(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
					line = br.readLine();
				}
				System.out.println("Data import successfully!");
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public void exportCSV(String strPath) {
		File file = new File(strPath);
		if (!file.exists()) { // Check whether the directory exists, if not create it
			file.mkdir();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath + "\\StudentData.csv"))) {
			for (Student student : students.getStudents()) {
				bw.write(student.toCSV());
				bw.newLine();
			}
			System.out.println("Data exported successfully!");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void clearStudents() {
		students.getStudents().clear();
	}
}
