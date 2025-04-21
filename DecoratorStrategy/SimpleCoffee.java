package DecoratorStrategy;

public class SimpleCoffee implements Coffee {
    public String getDescription(){
        return "Simple Coffee";
    }

    public int getCost(){
        return 20;
    }
}
