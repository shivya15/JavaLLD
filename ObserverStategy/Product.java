package ObserverStategy;
import java.util.ArrayList;
import java.util.List;

public class Product implements OutOfStockProduct {
    private String productName;
    private boolean isOutOfStock;
    private List<OutOfStockObserver> observers = new ArrayList<>();

    public Product(String productName) {
        this.productName = productName;
        this.isOutOfStock = true; 
    }

    public String getProductName(){
        return productName;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void addUser(OutOfStockObserver observer) {
        this.observers.add(observer);
        System.out.println("Observer " + observer + " registered for " + productName);
    }

    public void removeUser(OutOfStockObserver observer) {
        this.observers.remove(observer);
        System.out.println("Observer " + observer + " unregistered for " + productName);
    }

    public void notifyUsers(){
        if(!isOutOfStock){
            System.out.println("\nProduct '" + productName + "' is now back in stock. Notifying registered users:");
            for (OutOfStockObserver observer : observers) {
                observer.update(productName);
            }
            observers.clear();
        }
    }

    public void setInStock() {
        this.isOutOfStock = false;
        notifyUsers();
    }

}
