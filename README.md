# StudentSystem
This repositorie is a personal project made in Java 17 using Eclipse.
It was created with the idea of helping me practice the things I have been learning about Java.
The project idea was made by ChatGPT, which suggested me to make a student registration system using POO.

## Student Registration System 
Description: Develop a Java program that allows the user to perform the following operations:
1. Student Registration: Allow the user to register new students with information such as name, age, registration number, and other relevant details.
2. Student Inquiry: Allow the user to search and display information about a specific student based on their registration number.
3. List of Students: Display the complete list of all registered students.
4. Data Update: Allow the user to update the information of a student (e.g., update age, phone number, etc.).
5. Student Deletion: Allow the user to remove a student from the list of registrations.
6. Import CSV data: Allow the user to import data from a csv file.
7. Export CSV data: Allow the user to export data from a csv file.
8. Exit the program.

## Features

The projects aims to give the user access of many features by a menu:

![menu](https://raw.githubusercontent.com/AlysonCantalice/StudentSystem-JAVA/main/images/demo1.png)

# Register new Students

![registration](https://raw.githubusercontent.com/AlysonCantalice/StudentSystem-JAVA/main/images/demo4.png)

New students can be added as needed; all fields ensure type-safety, and duplicate registration numbers are not allowed, creating a way to identify different students even if they have the same name.

# Update students

![update](https://raw.githubusercontent.com/AlysonCantalice/StudentSystem-JAVA/main/images/demo3.png)

By using the unique registration number of each student, you can choose which one to update and then choose the field to update.

# Show all students

![showAll](https://raw.githubusercontent.com/AlysonCantalice/StudentSystem-JAVA/main/images/demo2.png)

This shows a list of all the students registered in the system, sorted by registration number.

# Other features

There are additional features like finding a specific student by giving their registration number, showing a version of the "Show all" function with only the chosen student, a way to remove a specific student from the system by giving their registration number, and importing/exporting the saved data to a CSV file, which can be given a custom path.

# Requirements

To run this project, it's necessary to have Java 17 (LTS) installed on your machine. The Java version I used was Java Azul Zulu 17.0.7 (LTS) ([link](https://www.azul.com/downloads/?version=java-17-lts&package=jdk#zulu)), but it should not be necessary to have this exact version for the project to work.

Furthermore, as these are source files (*src*), you also need an IDE capable of interpreting the code, with **ECLIPSE IDE** ([link](https://www.eclipse.org/downloads/)) being my choice.

For the best experience, you should run it in Git Bash by using *Git Bash here* in the `\bin\` directory and running the `Java application/Program` in its console. 

However, you can also run it in the Eclipse Console, keep in mind that it won't flush, which means there will be many "copies" of the menu on the console.

##

Created by @AlysonCantalice.
