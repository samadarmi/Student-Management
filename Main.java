import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    service.addStudent();
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    service.updateStudent();
                    break;

                case 4:
                    service.deleteStudent();
                    break;

                case 5:
                    System.out.println("👋 Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}
