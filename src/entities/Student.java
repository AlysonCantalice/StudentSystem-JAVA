package entities;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
	private String name;
	private Integer age;
	private Integer registration;
	private Integer phoneNumber;

	List<Student> students = new ArrayList<>();

	public Student() {
	}

	public Student(String name, Integer age, Integer registration, Integer phoneNumber) {
		this.name = name;
		this.age = age;
		this.registration = registration;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String toCSV() {
		return name + "," + age + "," + registration + "," + phoneNumber;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + "\n");
		sb.append("Age: " + age + "\n");
		sb.append("Registration N.: " + registration + "\n");
		sb.append("Phone Number: " + phoneNumber + "\n");
		return sb.toString();
	}

	@Override
	public int compareTo(Student o) {
		if (registration < o.getRegistration()) {
			return -1;
		}
		else if (registration > o.getRegistration()) {
			return 1;
		}
		return 0;
	}
}
