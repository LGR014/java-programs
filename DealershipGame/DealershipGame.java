import java.util.Scanner;

public class DealershipGame {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] cars = {"Elantra N", "IONIQ 5", "Tucson", "Sonata", "Santa Fe" };
        double[] prices = {32999, 45000, 35000, 28000, 42000};
        boolean[] bought = {false, false, false, false, false}; 
        int purchased = 0;
        double budget = 75000;
        
        

        System.out.println("Welcome to Kanata Hyundai!");
        while (budget >= 28000) {
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
            System.out.println("\n Remaining budget: $" + budget);
        } else {
            System.out.println("\n Sorry, you cant afford the " + chosenCar + "!");
        }
        }
        for (int i = 0; i < bought.length; i++) {
            if (bought[i] == true) {
                purchased++;
            }
        }
        System.out.println("\n Your budget isn't sufficient for any more vehicles!"); 
        System.out.println("\n You have purchased " + purchased + " vehicles!");
        System.out.println("\n Thank you for visiting Kanata Hyundai!");    
        
    }

    }
