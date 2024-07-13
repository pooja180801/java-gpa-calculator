import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GPACalculator {

    Scanner scan = new Scanner(System.in);

    User user = new User(1, "John", 4);

    public void printMainMenu() {
        System.out.println("----Main Menu----\n");

        System.out.println("1. View results\n2. Add results\n3. Export data\n4. Clear all data\n5. Exit");

    }

    public int getUserInput(int start, int end) { //1 - 5

        System.out.print("\nEnter your choice (" + start + " - " + end + ") : ");
        int choice = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                choice = scan.nextInt();
                if (choice<start || choice>end) {
                    throw new Exception();
                }
                isValid = true;
            }
            catch (InputMismatchException e) {
                System.out.print("Enter an integer: ");
            } catch (Exception e) {
                System.out.print("Enter your choice between " + start + " - " + end + " : "); //hello
            }
            finally {
                scan.nextLine(); //enter
            }
        }

        return choice;
    }


    public boolean confirm() {
        System.out.print("\nConfirm (y/n) : ");
        String input = scan.next();

        while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            System.out.print("Enter a valid choice: ");
            input = scan.next();
        }
        return input.equalsIgnoreCase("y");
    }


    public void addResults() throws SQLException {

        System.out.println("\n----Add results----\n");
        System.out.print("Year(1, 2, 3, 4): ");
        int year = getUserInput(1, 4);

        System.out.print("Course code: ");
        String course = scan.next();

        List<String> grades = Arrays.asList("A+", "A-", "A", "B+", "B-", "B", "C+", "C-", "C", "D+", "D", "E");
        System.out.print("Grade: ");
        String grade = scan.next(); //5
        while (!grades.contains(grade)) {
            System.out.print("Please enter a valid grade: ");
            grade = scan.next();
        }

        System.out.print("Credits: ");
        int credits = scan.nextInt();

        if (confirm()) {
            Connection conn = DbConnection.getConnection();
            Statement statement = conn.createStatement();
            String query = "insert into results (user_id, course_code, grade, credits, year) values (" + user.getUserid()
                    + ", '" + course + "', '" + grade + "', "  +  credits + ", " + year +  ")";
            int rows = statement.executeUpdate(query);

            statement.close();

            System.out.println("\nRecord was added!\n");
        }

    }

}
