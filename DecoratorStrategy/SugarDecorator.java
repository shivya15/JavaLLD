package DecoratorStrategy;

public class SugarDecorator extends CoffeeDecorator {
    
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDescription() {
        return super.getDescription() + ", with Sugar";
    }

    public int getCost() {
        return super.getCost() + 5;
    }
}
