package ObserverStategy;
import ObserverStategy.OutOfStockObserver;

public interface OutOfStockProduct {
    void addUser(OutOfStockObserver user);
    void removeUser(OutOfStockObserver user);
    void notifyUsers();
}

