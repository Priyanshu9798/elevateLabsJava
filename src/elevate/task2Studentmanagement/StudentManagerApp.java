package elevate.task2Studentmanagement;

import java.util.Scanner;

public class StudentManagerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        final String FILE = "students.txt";

        System.out.println("🔐 Welcome! Please log in.");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!(user.equals("admin") && pass.equals("admin123"))) {
            System.out.println("❌ Incorrect login. Exiting...");
            return;
        }

        manager.loadFromFile(FILE);
        boolean running = true;

        while (running) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 ➜ Add Student");
            System.out.println("2 ➜ View All Students");
            System.out.println("3 ➜ Update Student");
            System.out.println("4 ➜ Delete Student");
            System.out.println("5 ➜ Search Student");
            System.out.println("6 ➜ Show Topper");
            System.out.println("7 ➜ Show Average Marks");
            System.out.println("8 ➜ Save to File");
            System.out.println("9 ➜ Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Marks: ");
                    double newMarks = sc.nextDouble();
                    manager.updateStudent(uid, newName, newMarks);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    manager.deleteStudent(did);
                    break;
                case 5:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    manager.searchStudent(sid);
                    break;
                case 6:
                    manager.showTopper();
                    break;
                case 7:
                    manager.showAverageMarks();
                    break;
                case 8:
                    manager.saveToFile(FILE);
                    break;
                case 9:
                    manager.saveToFile(FILE);
                    System.out.println(" Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("❗ Invalid choice.");
            }
        }

        sc.close();
    }
}
