import java.util.Random;
import java.util.Scanner;

public class SistematikÖrnekleme {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Evren büyüklüğünü giriniz ");
        int N=input.nextInt();
        System.out.println("Örneklem hacmini giriniz ");
        int n=input.nextInt();
        int k=N/n;
        System.out.println("k değeri: "+k);
        Random r=new Random();
        int a=r.nextInt(k)+1;
        System.out.println("1 ile k arasında rastgele başlangıç noktası a : "+a);

        System.out.println("Seçilen örneklem birimleri:");

        for(int i=0;i<n;i++){
            int secilenbirim=a+i*k;
            System.out.println(secilenbirim+" ");

        }









    }
}
