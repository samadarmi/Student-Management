import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // CONSTRUCTOR – load data when program starts
    public StudentService() {
        loadFromFile();
    }

    // ADD STUDENT
    public void addStudent() {

        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();

        // Duplicate roll number check
        if (isRollNoExists(rollNo)) {
            System.out.println("❌ Roll number already exists! Try again.");
            return;
        }

        scanner.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        Student student = new Student(rollNo, name, dept, year);
        students.add(student);

        saveToFile();
        System.out.println("✅ Student added successfully!");
    }

    // VIEW STUDENTS
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("⚠ No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // UPDATE STUDENT
    public void updateStudent() {

        System.out.print("Enter Roll Number to Update: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {

                System.out.print("Enter New Name: ");
                s.setName(scanner.nextLine());

                System.out.print("Enter New Department: ");
                s.setDept(scanner.nextLine());

                System.out.print("Enter New Year: ");
                s.setYear(scanner.nextInt());

                saveToFile();
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }

        System.out.println("❌ Student not found.");
    }

    // DELETE STUDENT
    public void deleteStudent() {

        System.out.print("Enter Roll Number to Delete: ");
        int rollNo = scanner.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == rollNo) {
                students.remove(i);
                saveToFile();
                System.out.println("✅ Student deleted successfully!");
                return;
            }
        }

        System.out.println("❌ Student with Roll Number " + rollNo + " not found.");
    }

    // CHECK DUPLICATE ROLL NUMBER
    private boolean isRollNoExists(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return true;
            }
        }
        return false;
    }

    // SAVE DATA TO FILE
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {

            for (Student s : students) {
                writer.write(
                        s.getRollNo() + "," +
                        s.getName() + "," +
                        s.getDept() + "," +
                        s.getYear()
                );
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("❌ Error saving data to file.");
        }
    }

    // LOAD DATA FROM FILE
    private void loadFromFile() {
        File file = new File("students.txt");
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int rollNo = Integer.parseInt(data[0]);
                String name = data[1];
                String dept = data[2];
                int year = Integer.parseInt(data[3]);

                students.add(new Student(rollNo, name, dept, year));
            }

        } catch (IOException e) {
            System.out.println("❌ Error loading data from file.");
        }
    }
}
