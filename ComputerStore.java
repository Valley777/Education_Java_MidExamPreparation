import java.util.Scanner;
public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Write a program that prints a receipt for your new PC. You will receive the part`s prices(without tax)
        //until you receive what type  of customer this is  - special or regular
        //taxes are 20% of each price
        //special customer - has additional 10% from total
        //if the input is negative - print "Invalid price!"
        //if the price is equal to zero - print "Invalid order!"

        String command = scan.nextLine();
        double taxes = 0;
        double priceWithoutTaxes = 0;

        while(!command.equals("special")&& !command.equals("regular")){
//превръщаме прочетеният стринг в double - >това ще е цената за един компонент

            double currentPrice = Double.parseDouble(command);
           if(currentPrice<0){  //case invalid price
               System.out.println("Invalid price!");
               command = scan.nextLine();
               continue;
            }
           //добавяме текущата цена към общата сума без такси
            priceWithoutTaxes +=currentPrice;
            taxes += currentPrice*0.20;

            command = scan.nextLine();
          }
        //пресметнем колко е общата сума за вс компоненти +такси
        double totalSum = priceWithoutTaxes +taxes;
        if(command.equals("special")){
            totalSum =totalSum*0.9;
        }
        //проверка дали общата сума е < 0 > "Invalid order"
        if(totalSum <= 0){
            System.out.println("Invalid order!");
        }else{
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalSum);
        }
       // System.out.println(command);


    }
}
