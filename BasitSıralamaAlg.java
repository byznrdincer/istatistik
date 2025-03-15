import java.util.Scanner;

import java.util.Scanner;

public class BasitSıralamaAlg {
    public static void main(String[] args) {
        // Scanner nesnesi ile kullanıcıdan veri alıyoruz
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan dizinin uzunluğunu alıyoruz
        System.out.print("Dizinin boyutunu girin: ");
        int n = scanner.nextInt();

        // Diziyi oluşturuyoruz
        int[] dizi = new int[n];

        // Kullanıcıdan dizinin elemanlarını alıyoruz
        System.out.println("Dizinin elemanlarını girin:");
        for (int i = 0; i < n; i++) {
            System.out.print("Eleman " + (i + 1) + ": ");
            dizi[i] = scanner.nextInt();
        }

        // Diziyi küçükten büyüğe sıralıyoruz (Bubble Sort kullanarak)
        bubbleSort(dizi);

        // Sıralanmış diziyi yazdırıyoruz
        System.out.println("Sıralanmış dizi:");
        for (int i = 0; i < n; i++) {
            System.out.print(dizi[i] + " ");
        }
    }

    // Bubble Sort algoritması
    public static void bubbleSort(int[] dizi) {
        int n = dizi.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    // Yer değiştirme işlemi
                    int temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
    }
}
