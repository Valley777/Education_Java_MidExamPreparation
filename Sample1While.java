import java.util.Scanner;
public class Sample1While {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String command = scan.nextLine();
        while(!command.equals("special")&& !command.equals("regular")){
            double currentPrice = Double.parseDouble(command); //преобразуваме входящите данни в double - ако се четат цифри и текст

            command = scan.nextLine();
        }

        System.out.println(command);
    }
}
