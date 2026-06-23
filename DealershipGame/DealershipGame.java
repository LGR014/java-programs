import java.util.Scanner;

public class DealershipGame {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] cars = {"Elantra N", "IONIQ 5", "Tucson", "Sonata", "Santa Fe" };
        double[] prices = {32999, 45000, 35000, 28000, 42000};
        boolean[] bought = {false, false, false, false, false}; 
        boolean[] sold = {false, false, false, false, false};
        int purchased = 0;
        double budget = 75000;
        int totalAmount = 0;

        while (budget >= 0) {
        System.out.println("Would you like to (1) BUY A CAR or (2) SELL A CAR?");
        int action = scanner.nextInt(); 
        if (action == 1) {
        System.out.println("You have $" + budget + " to spend.");
        System.out.println("\n Available Cars");

         for (int i = 0; i < cars.length; i++) {
            if (bought[i] == true) {
            System.out.println((i + 1) + ". " + cars[i] + " $" + prices[i] + (" OWNED"));
        } else if (budget < prices[i]) {
            System.out.println((i + 1) + ". " + cars[i] + " $" + prices[i] + " INSUFFICIENT FUNDS");
        } else {
            System.out.println((i + 1) + ". " + cars[i] + " $" + prices[i]);  
        } 
    }  

        System.out.println("\nEnter the number of the car you want to buy: ");
            int choice = scanner.nextInt();
            choice = choice - 1;

        String chosenCar = cars[choice];
        double chosenPrice = prices[choice];

        if (chosenPrice <= budget) {
            budget = budget - chosenPrice;
            bought[choice] = true;
            System.out.println("\n You bought the " + chosenCar + "!");
            System.out.println("\n Remaining budget: $" + String.format("%.2f", budget));
            System.out.println("Would you like to buy another vehicle or sell a vehicle?");
        } else {
            System.out.println("\n Sorry, you cant afford the " + chosenCar + "!");
        }
        } else if (action == 2) {
            System.out.println("\n Which car would you like to sell?");
            int sellChoice = scanner.nextInt();
                sellChoice = sellChoice - 1;

            if (bought[sellChoice] == true) {
                double resaleValue = prices[sellChoice] * 0.80;
                budget = budget + resaleValue;
                bought[sellChoice] = false;
                System.out.println("\n You sold the " + cars[sellChoice] + " for $ " + resaleValue);
                System.out.println("\n New Budget is: " + String.format("%.2f", budget));                
            } else {
                System.out.println("You don't own that car!");
            }
        }
        for (int i = 0; i < bought.length; i++) {
            if (bought[i] == true) {
                purchased++;  
                totalAmount += prices[i];    
            }
        }
    } 

        System.out.println("\n Your budget isn't sufficient for any more vehicles!"); 
        System.out.println("\n You have purchased " + purchased + " vehicles!");
        System.out.println("\n Total money spent: $" + totalAmount);
        System.out.println("\n Thank you for visiting Kanata Hyundai!");    
        
    }

}

