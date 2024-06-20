import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //1. read fr console
        // on the first 3 lines what we bought for the puppy
                  double foodInKg = Double.parseDouble(scan.nextLine());
                  double hayInKg = Double.parseDouble(scan.nextLine());
                  double coverInKg = Double.parseDouble(scan.nextLine());
                  double pigWeightInKg = Double.parseDouble(scan.nextLine());

        //2. convert all to gramms (some are gramms some kilograms)
                 double foodInGrams = foodInKg*1000; //food 4 1month
                 double hayInGrams = hayInKg*1000;
                 double coverInGrams = coverInKg*1000;
                 double pigWeightIngrams = pigWeightInKg*1000;

         //3. damage for a month - by days
        for(int day=1;day<=30 ;day++){

            //each day eats 300 gr
            foodInGrams -=300;
            //each 2nd day  > change the grass
            if(day%2==0){
                //hay is =5% from the qty of foof
                double needHay = 0.05*foodInGrams;
                hayInGrams  -=needHay  ;
            }

            //each 3rd day > change  cover
            if (day%3== 0){
                //1/3 from the pig weight

                double needCover =pigWeightIngrams/3; //needed cover when changing
                coverInGrams -= needCover;

            }
            //each day we have to check if all premises are sufficient
            if(foodInGrams<=0 || hayInGrams <=0 || coverInGrams<=0){
                System.out.println("Merry must go to the pet store!");
                return; //прекратява цялата програма

            }
        }
        //after we did all 30 days
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",foodInGrams/1000,hayInGrams/1000,coverInGrams/1000);

    }
}
