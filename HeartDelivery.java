import java.util.Scanner;
 import java.util.Arrays;
import java.util.stream.IntStream;
public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
   /*You will receive a string with even integers, separated by a "@" - this is our neighborhood. After that, a series of Jump commands will follow until you receive "Love!". Every house in the neighborhood needs a certain number of hearts delivered by Cupid so it can celebrate Valentine's day. The integers in the neighborhood indicate those needed hearts.
Cupid starts at the position of the first house (index 0) and must jump by a given length. The jump commands will be in this format: "Jump {length}".
Every time he jumps from one house to another, the needed hearts for the visited house are decreased by 2:
    • If the needed hearts for a certain house become equal to 0, print on the console "Place {house_index} has Valentine's day."
    • If Cupid jumps to a house where the needed hearts are already 0, print on the console "Place {house_index} already had Valentine's day."
    • Keep in mind that Cupid can have a larger jump length than the size of the neighborhood, and if he does jump outside of it, he should start from the first house again (index 0).
For example, we are given this neighborhood: 6@6@6. Cupid is at the start and jumps with a length of 2. He will end up at index 2 and decrease the needed hearts by 2: [6, 6, 4]. Next, he jumps again with a length of 2 and goes outside the neighborhood, so he goes back to the first house (index 0) and again decreases the needed hearts there: [4, 6, 4].
Input
    • On the first line, you will receive a string with even integers separated by "@" – the neighborhood and the number of hearts for each house.
    • On the next lines, until "Love!" is received, you will be getting jump commands in this format: "Jump {length}".
Output
In the end, print Cupid's last position and whether his mission was successful or not:
    • "Cupid's last position was {last_position_index}."
    • If each house has had Valentine's day, print:
        ◦ "Mission was successful."
    • If not, print the count of all houses that didn't celebrate Valentine's Day:
        ◦ "Cupid has failed {houseCount} places." */

                int[] places = Arrays.stream(scan.nextLine().split("@+")).mapToInt(Integer::parseInt).toArray();
                String input;
                int index = 0;

                while (!"Love!".equals(input = scan.nextLine())) {
                    String[] jump = input.split("\\s+");
                    index += Integer.parseInt(jump[1]);
                    if (index > places.length - 1) {
                        index = 0;
                    }
                    if (places[index] == 0) {
                        System.out.printf("Place %d already had Valentine's day.%n", index);
                    } else if (places[index] - 2 <= 0) {
                        places[index] = 0;
                        System.out.printf("Place %d has Valentine's day.%n", index);
                    } else {
                        places[index] -= 2;
                    }
                }
                System.out.printf("Cupid's last position was %d.%n", index);
                int successful = (int) IntStream.range(0, places.length).filter(i -> places[i] != 0).count();
                if (successful == 0) {
                    System.out.println("Mission was successful.");
                } else {
                    System.out.printf("Cupid has failed %d places.", successful);
                }
            }
        }
