package elevate.task2Studentmanagement;

import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(int id, String name, double marks) {
        if (getStudentById(id) != null) {
            System.out.println("⚠️ Student with ID " + id + " already exists.");
            return;
        }
        studentList.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    public void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("📭 No student records found.");
            return;
        }
        System.out.println("\n📋 Student List:");
        for (Student s : studentList) {
            s.display();
        }
    }

    public void updateStudent(int id, String newName, double newMarks) {
        Student s = getStudentById(id);
        if (s != null) {
            s.setName(newName);
            s.setMarks(newMarks);
            System.out.println("✅ Student updated.");
        } else {
            System.out.println("❌ Student ID not found.");
        }
    }

    public void deleteStudent(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            studentList.remove(s);
            System.out.println("🗑️ Student deleted.");
        } else {
            System.out.println("❌ Student ID not found.");
        }
    }

    public void searchStudent(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            System.out.println("🔍 Student Found:");
            s.display();
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    public void showTopper() {
        if (studentList.isEmpty()) {
            System.out.println("📭 No student records available.");
            return;
        }
        Student topper = Collections.max(studentList, Comparator.comparingDouble(Student::getMarks));
        System.out.println("🏆 Topper:");
        topper.display();
    }

    public void showAverageMarks() {
        if (studentList.isEmpty()) {
            System.out.println("📭 No student records to calculate average.");
            return;
        }
        double total = 0;
        for (Student s : studentList) total += s.getMarks();
        System.out.printf("📊 Average Marks: %.2f\n", total / studentList.size());
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Student s : studentList) {
                writer.println(s.getId() + "," + s.getName() + "," + s.getMarks());
            }
            System.out.println("💾 Data saved to file.");
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            studentList.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double marks = Double.parseDouble(parts[2]);
                    studentList.add(new Student(id, name, marks));
                }
            }
            System.out.println("📂 Data loaded from file.");
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    private Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
