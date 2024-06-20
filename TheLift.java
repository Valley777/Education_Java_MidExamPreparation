import java.util.*;
import java.util.stream.IntStream;
public class TheLift {


        public static void main(String[] args) {
/*
Write a program that finds a place for the tourist on a lift.
Every wagon should have a maximum of 4 people on it. If a wagon is full, you should direct the people to the next one with space available.
Input
    • On the first line, you will receive how many people are waiting to get on the lift
    • On the second line, you will receive the current state of the lift separated by a single space: " ".
 */
            Scanner scan = new Scanner(System.in);
            int people = Integer.parseInt(scan.nextLine());
            int[] lift = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < lift.length; i++) {
                if ((lift[i] < 4)) {
                    if (people >= 4 - lift[i]) {
                        people -= 4 - lift[i];
                        lift[i] = 4;
                    } else {
                        lift[i] += people;
                        people = 0;
                    }
                }
            }
            boolean full = IntStream.range(0, lift.length).noneMatch(i -> lift[i] != 4);
            if (people == 0 && !full) {
                System.out.println("The lift has empty spots!");
            } else if (people > 0 && full) {
                System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            }
            System.out.print(Arrays.toString(lift).replaceAll("[\\[\\]]", "").replaceAll(", ", " "));
        }
    }
