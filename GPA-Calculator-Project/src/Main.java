import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        GPACalculator gpaCalculator = new GPACalculator();

        gpaCalculator.printMainMenu();

        int choice = gpaCalculator.getUserInput(1, 5);


        while (choice!=5) {
            switch (choice) {
                case 1:


                case 2:
                    gpaCalculator.addResults();

                case 3:


                case 4:
            }

            gpaCalculator.printMainMenu();
            choice = gpaCalculator.getUserInput(1, 5);
        }


        gpaCalculator.scan.close();

    }
}