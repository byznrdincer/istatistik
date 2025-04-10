import java.util.*;

import java.util.*;

public class FrekansSerisi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veri kümesini girin (boşlukla ayırarak girin): ");
        String input = scanner.nextLine();

        String[] veriler = input.split(" ");

        // Frekansları saymak için TreeMap kullandık, otomatik olarak sıralar
        Map<String, Integer> frekansMap = new TreeMap<>();

        for (String veri : veriler) {
            frekansMap.put(veri, frekansMap.getOrDefault(veri, 0) + 1);
        }

        // Frekans serisini ekrana yazdıralım
        System.out.println("\nFrekans Serisi:");
        System.out.println("Değer   | Frekans");
        for (Map.Entry<String, Integer> entry : frekansMap.entrySet()) {
            System.out.println(entry.getKey() + "       | " + entry.getValue());
        }

        scanner.close();
    }
}
