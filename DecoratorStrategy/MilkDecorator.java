package DecoratorStrategy;

public class MilkDecorator extends CoffeeDecorator {
    
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDescription() {
        return super.getDescription() + ", with Milk";
    }

    public int getCost() {
        return (super.getCost() + 10);
    }


}
