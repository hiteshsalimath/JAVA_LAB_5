import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TransitTask implements Runnable {
    private String taskName;

    public TransitTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing transit task: " + taskName);
        try {
            Thread.sleep(2000); // Simulate task execution time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Transit task completed: " + taskName + "\n");
    }
}

public class TransitManager {
    private static List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();2

            switch (choice) {
                case 1:
                    System.out.print("Enter transit task description: ");
                    String taskDescription = scanner.next();
                    tasks.add(taskDescription);
                    new Thread(new TransitTask(taskDescription)).start();
                    break;
                case 2:
                    listTransitTasks();
                    break;
                case 3:
                    System.out.println("Exiting the transit management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Display the menu again after task execution
            if (choice != 3) {
                scanner.nextLine(); // Consume the newline character
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for Enter key press
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nTransit Management Menu:");
        System.out.println("1. Add Transit Task");
        System.out.println("2. List Transit Tasks");
        System.out.println("3. Exit\n");
    }

    private static void listTransitTasks() {
        System.out.println("Executing transit tasks...\n");

        for (String task : tasks) {
            System.out.println("Transit Task: " + task);
        }

        System.out.println("\nAll transit tasks executed.\n");
    }
}