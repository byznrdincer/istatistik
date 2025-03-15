import java.util.Scanner;
import java.util.Arrays;

public class frekansTablosuOlusturmak {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan veri setinin boyutunu alalım
        System.out.print("Veri kümesinin boyutunu girin: ");
        int n = scanner.nextInt();

        // Kullanıcıdan veri setini alalım
        int[] data = new int[n];
        System.out.println("Veri kümesini girin: ");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        // Veriyi sıralayalım
        Arrays.sort(data);

        // En küçük ve en büyük değeri bulalım
        int S = data[0];  // En küçük değer
        int L = data[n - 1];  // En büyük değer

        // Sınıf sayısını hesapla (√n)
        int k = (int) Math.ceil(Math.sqrt(n));
        System.out.println("Sınıf Sayısı (k): " + k);

        // Sınıf genişliğini hesapla
        int R = L - S;
        int h = (int) Math.ceil((double) R / k);
        System.out.println("Sınıf Genişliği (h): " + h);

        // Sınıf limitlerini ve sınıf sınırlarını belirleyelim
        int lowerLimit = S;
        int upperLimit = lowerLimit + h - 1;

        // Frekansları tutmak için bir dizi
        int[] frequency = new int[k];
        int totalFrequency = 0;

        // Sınıf frekanslarını hesapla
        for (int i = 0; i < k; i++) {
            int count = 0;
            for (int value : data) {
                if (value >= lowerLimit && value <= upperLimit) {
                    count++;
                }
            }
            frequency[i] = count;
            totalFrequency += count;
            lowerLimit = upperLimit + 1;
            upperLimit = lowerLimit + h - 1;
        }

        // Sınıf limitleri ve sınıf sınırları
        lowerLimit = S;
        upperLimit = lowerLimit + h - 1;

        System.out.println("\nFrekans Tablosu:");
        System.out.println("Sınıf No | Sınıf Limitleri | Sınıf Sınırları | Frekans | Eklenik Frekans | Oransal Frekans | Oransal Eklenik Frekans");

        double cumulativeFrequency = 0;
        double cumulativeRelativeFrequency = 0;
        for (int i = 0; i < k; i++) {
            double classBoundaryLower = lowerLimit - 0.5;
            double classBoundaryUpper = upperLimit + 0.5;
            double classMidPoint = (lowerLimit + upperLimit) / 2.0;

            cumulativeFrequency += frequency[i];
            double relativeFrequency = (double) frequency[i] / n;
            cumulativeRelativeFrequency += relativeFrequency;

            System.out.printf("%-9d | [%3d - %3d]        | [%.1f - %.1f]       | %-7d | %-14.0f | %-15.4f | %-19.4f\n",
                    i + 1, lowerLimit, upperLimit, classBoundaryLower, classBoundaryUpper, frequency[i],
                    cumulativeFrequency, relativeFrequency, cumulativeRelativeFrequency);

            lowerLimit = upperLimit + 1;
            upperLimit = lowerLimit + h - 1;
        }

        scanner.close();
    }
}

