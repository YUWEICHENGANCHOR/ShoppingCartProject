import java.util.Scanner;

public class Test01 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Input the price what you want");
        double price = scan.nextDouble();

        System.out.println("Input the amount what you want");
        int amount = scan.nextInt();

        double totalPrice = price*amount;
        System.out.println("Input the amount what you buy are: " + totalPrice + " dollars");

        System.out.println("Input the amount you want to pay ");
        double money = scan.nextDouble();

        double change = 0.0;
        if(money >= totalPrice){
            change = money - totalPrice;
            System.out.println("Total you buy are: " + totalPrice + "\n you pay: " + money + " \n And will give the change: " + change);
        } else {
            System.out.println("The money is not enough");
        }

    }
}
