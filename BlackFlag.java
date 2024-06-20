import java.util.Scanner;

    public class BlackFlag {
        public static void main(String[] args) {
            Scanner scan= new Scanner(System.in);
            int days = Integer.parseInt(scan.nextLine()); //общ брой дни за крадене
            int plundersPerDay = Integer.parseInt(scan.nextLine()); //кражби за ден
            double targetCountPlunders = Double.parseDouble(scan.nextLine()); //брой целеви кражби

            //1.   брой направени кражби
            double totalPlunders = 0;//общ брой кражби

            for (int day = 1; day <= days; day++) {
                //повтаряме: извършваме кражби = plundersPerDay
                totalPlunders += plundersPerDay;

                if (day % 3 == 0) {
                    //правим допълнителни кражби
                    double extraPlunders = 0.5 * plundersPerDay;
                    totalPlunders += extraPlunders;
                }

                if (day % 5 == 0) {
                    //губим 30% от общия брой кражби
                    totalPlunders = totalPlunders - totalPlunders * 0.3;
                    //totalPlunders = totalPlunders * 0.7;
                    //totalPlunders *= 0.7;
                }

            }
            //обходили всички дни -> колко са общо направените кражби -> totalPlunders
            //2. проверка дали сме постигнали целта
            if (totalPlunders >= targetCountPlunders) {
                //постигнали целта си
                System.out.printf("Ahoy! %.2f plunder gained.", totalPlunders);
            } else {
                //totalPlunders < targetCountPlunders
                //не сме успяли да постигнем целта си
                double percent = (totalPlunders / targetCountPlunders) * 100;
                System.out.printf("Collected only %.2f%% of the plunder.", percent);
            }
        }
    }
 
