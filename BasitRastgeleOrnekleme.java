import java.util.*;

public class BasitRastgeleOrnekleme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the max number:");
        int max = input.nextInt();

        System.out.println("Please enter the min number:");
        int min = input.nextInt();

        System.out.println("How many random numbers do you want?");
        int count = input.nextInt();

        int totalNumbers = max - min + 1;

        if (count > totalNumbers) {
            System.out.println("You cannot request more unique numbers than the total range allows.");
            return;
        }

        // Tüm olası sayıları listeye ekle
        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        // Listeyi karıştır
        Collections.shuffle(numbers);

        // İstenen kadar sayıyı yazdır
        System.out.println("random numbers:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". random number: " + numbers.get(i));
        }
    }
}
