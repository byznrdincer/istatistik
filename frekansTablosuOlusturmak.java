import java.util.Scanner;
import java.util.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class frekansTablosuOlusturmak {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kaç adet değer gireceksiniz: ");
        int n = scanner.nextInt();

        double[] veri = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". değeri giriniz: ");
            veri[i] = scanner.nextDouble();
        }

        Arrays.sort(veri); // Verileri küçükten büyüğe sırala

        int k = (int) Math.ceil(Math.sqrt(n)); // Sınıf sayısı
        double r = veri[n - 1] - veri[0];      // Ranj
        double snc = Math.ceil(r / k);         // Sınıf genişliği

        double[][] sinifLimitleri = new double[k][2];
        double[][] sinifSinirlari = new double[k][2];
        double[] frekanslar = new double[k];
        double[] eklenikFrekanslar = new double[k];
        double[] ortaNoktalar = new double[k];

        // Sınıf limitleri
        System.out.println("Sınıf Limitleri:");
        for (int i = 0; i < k; i++) {
            sinifLimitleri[i][0] = veri[0] + snc * i;
            sinifLimitleri[i][1] = veri[0] + snc * (i + 1);
            System.out.printf("%.2f\t%.2f\n", sinifLimitleri[i][0], sinifLimitleri[i][1]);
        }

        // Sınıf sınırları
        System.out.println("\nSınıf Sınırları:");
        for (int i = 0; i < k; i++) {
            sinifSinirlari[i][0] = sinifLimitleri[i][0] - 0.5;
            sinifSinirlari[i][1] = sinifLimitleri[i][1] + 0.5;
            System.out.printf("%.2f\t%.2f\n", sinifSinirlari[i][0], sinifSinirlari[i][1]);
        }

        // Frekanslar
        System.out.println("\nSınıf Frekansları:");
        for (int i = 0; i < k; i++) {
            double alt = sinifSinirlari[i][0];
            double ust = sinifSinirlari[i][1];
            for (double v : veri) {
                if (v >= alt && v < ust) {
                    frekanslar[i]++;
                }
            }
            System.out.printf("%.0f\n", frekanslar[i]);
        }

        // Eklenik frekans
        System.out.println("\nEklenik Frekans:");
        double toplam = 0;
        for (int i = 0; i < k; i++) {
            toplam += frekanslar[i];
            eklenikFrekanslar[i] = toplam;
            System.out.printf("%.0f\n", eklenikFrekanslar[i]);
        }

        // Oransal frekans
        System.out.println("\nOransal Frekans:");
        for (int i = 0; i < k; i++) {
            System.out.printf("%.2f\n", frekanslar[i] / n);
        }

        // Oransal eklenik frekans
        System.out.println("\nOransal Eklenik Frekans:");
        for (int i = 0; i < k; i++) {
            System.out.printf("%.2f\n", eklenikFrekanslar[i] / n);
        }

        // Orta noktalar
        System.out.println("\nSınıf Orta Noktaları:");
        for (int i = 0; i < k; i++) {
            ortaNoktalar[i] = (sinifLimitleri[i][0] + sinifLimitleri[i][1]) / 2;
            System.out.printf("%.2f\n", ortaNoktalar[i]);
        }

        scanner.close();
    }
}
