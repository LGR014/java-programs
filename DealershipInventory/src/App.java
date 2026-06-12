public class App {
    public static void main(String[] args) throws Exception {

        String[] cars = {"Elantra N", "IONIQ 5", "Tucson", "Sonata", "Santa Fe"};
        double[] prices = {32999.99, 45000, 35000, 28000, 42000};

        double highestPrice = prices[0];
        String mostExpensive = cars[0];

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " $" + prices[i]);
        if (prices[i] > highestPrice) {
            highestPrice = prices[i];
            mostExpensive = cars[i];

            }
        }
            System.out.println("Most Expensive: " + mostExpensive + " $" + highestPrice);
        


        
    }
}
