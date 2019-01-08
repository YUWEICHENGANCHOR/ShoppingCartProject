import java.util.Scanner;

public class ShoppingCartProject {

    static int totalItems;
    static String[] items;
    static double[] prices;
    static int [] quantity;

    public static void main(String[] args){
        //use array
        System.out.println("Welcome to my store");
        totalItems = getNumberOfItems("how many item do you want to buy: ");
        items = new String[totalItems];
        prices = new double[totalItems];
        quantity = new int[totalItems];

        int count = 0;
        while(count < totalItems) {
            getItemDetails(count);
            count ++ ;
        }

        displayCart();

    }

    private static void displayCart() {

        System.out.println("####################################");
        System.out.println("Shopping cart details:");
        System.out.println("####################################");



        for(int i = 0; i < totalItems; i++){
            showLineItem(i);
        }

        System.out.println("####################################");
        double subtotal = calculateSubtotal();
        double tax = subtotal* 8.75;
        double total = subtotal + tax;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Sales tax @ 8.75%: " + tax);
        System.out.println("Total cost: " + total);
        System.out.println("Average cost of all items " + subtotal / getTotalItems());
        System.out.println("Thanks for shopping with us");


    }

    private static int getTotalItems() {
        int sum = 0;
        for (int item: quantity){
            sum += item;
        }
        return sum;
    }

    private static double calculateSubtotal() {

        double total = 0;
        for(int i =0; i < totalItems; i++){
            total += prices[i] * quantity[i];
        }
        return total;
    }

    private static void showLineItem(int index) {

        String quantityText = quantity[index] + "\t--\t"; //3
        String itemText = items[index] +  "-----------------";//pencils
        String priceText = prices[index] + " = " + prices[index] * quantity[index];

        System.out.println(quantityText + itemText + priceText);

    }

    private static void getItemDetails(int index) {
        items[index] = getItemName("What is the name of item # " + (index + 1) + "?");
        prices[index] = getItemPrice("What is the price of item # " + (index + 1) + "?");
        quantity[index] = getNumberOfItems("How many of item # " + (index + 1) + "?");
    }

    private static double getItemPrice(String m){
        System.out.print(m);
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    private static String getItemName(String m){
        System.out.print(m);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    private static int getItemQuantity(String m){
        System.out.print(m);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    private static int getNumberOfItems(String m){
        System.out.print(m);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }


}
