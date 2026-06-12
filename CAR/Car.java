public class Car {

   String model;
   int year;
   double price;

   Car(String model, int year, double price) {
    this.model = model;
    this.year = year;
    this.price = price;
   }

    void printInfo() {
        System.out.println(year + " " + model + " $ " + price);

    }
}

