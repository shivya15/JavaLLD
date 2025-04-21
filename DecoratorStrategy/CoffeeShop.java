package DecoratorStrategy;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee coffee1 = new SimpleCoffee();
        System.out.println("Order: " + coffee1.getDescription() + ", Cost: $" + coffee1.getCost());

        Coffee coffee2 = new MilkDecorator(new SimpleCoffee());
        System.out.println("Order: " + coffee2.getDescription() + ", Cost: $" + coffee2.getCost());

        Coffee coffee3=new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("Order: " + coffee3.getDescription() + ", Cost: $" + coffee3.getCost());

        Coffee coffee4= new MilkDecorator(new SugarDecorator(new SimpleCoffee()));
        System.out.println("Order: " + coffee4.getDescription() + ", Cost: $" + coffee4.getCost());

        Coffee coffee5= new MilkDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("Order: " + coffee5.getDescription() + ", Cost: $" + coffee5.getCost());

    }
}
