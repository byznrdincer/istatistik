import java.util.Scanner;

public class BasitRastgeleOrnekleme {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("please enter the  max number ");
        int max=input.nextInt();
        System.out.println("please enter the min number ");
        int min=input.nextInt();
        int random= (int)(Math.random()*(max-min+1))+min;
        System.out.println("the random number is "+random);
    }
}
