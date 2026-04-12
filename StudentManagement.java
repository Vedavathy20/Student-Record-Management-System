import java.util.ArrayList;
import java.util.Scanner;
class Student {

    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setters (for update)
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagement {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Add
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // View
                    if (students.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Update
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();

                    boolean foundUpdate = false;

                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new marks: ");
                            double newMarks = sc.nextDouble();

                            s.setName(newName);
                            s.setMarks(newMarks);

                            System.out.println("Student updated!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Delete
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean foundDelete = false;

                    for (Student s : students) {
                        if (s.getId() == deleteId) {
                            students.remove(s);
                            System.out.println("Student deleted!");
                            foundDelete = true;
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}