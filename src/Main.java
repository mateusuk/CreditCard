import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Enter the Credit Card limit: ");
        double limit = read.nextDouble();

        CreditCard card = new CreditCard(limit);

        int exit = 1;

        while (exit !=0){
            System.out.println("Enter the desciption of the product: ");
            String description = read.next();

            System.out.println("Enter the price of the purchase: ");
            double price = read.nextDouble();

            Shopping shopping = new Shopping(description,price);
            boolean succefullyPurchase = card.buyingItem(shopping);

            if (succefullyPurchase){
                System.out.println("Order confirmed");
                System.out.println("Enter 0 to exit and 1 to continue");
                exit= read.nextInt();
            }else {
                System.out.println("declined");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("Order: \n");
        Collections.sort(card.getShoppings());
        for (Shopping s : card.getShoppings()){
            System.out.println(s.getDescription() + " - "+s.getPrice());
        }
        System.out.println("\n***************");

        System.out.println("\n remain : " +card.getBalance());

    }
}
