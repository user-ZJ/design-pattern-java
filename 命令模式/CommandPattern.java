import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
    public interface Order {
        void execute();
    }
    public class Stock {

        private String name = "ABC";
        private int quantity = 10;

        public void buy(){
            System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] bought");
        }
        public void sell(){
            System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] sold");
        }
    }
    public class BuyStock implements Order {
        private Stock abcStock;

        public BuyStock(Stock abcStock){
            this.abcStock = abcStock;
        }

        public void execute() {
            abcStock.buy();
        }
    }
    public class SellStock implements Order {
        private Stock abcStock;

        public SellStock(Stock abcStock){
            this.abcStock = abcStock;
        }

        public void execute() {
            abcStock.sell();
        }
    }
    public class Broker {
        private List<Order> orderList = new ArrayList<Order>();

        public void takeOrder(Order order){
            orderList.add(order);
        }

        public void placeOrders(){
            for (Order order : orderList) {
                order.execute();
            }
            orderList.clear();
        }
    }

    public static void main(String [] args){
        CommandPattern cp = new CommandPattern();
        Stock abcStock = cp.new Stock();

        BuyStock buyStockOrder = cp.new BuyStock(abcStock);
        SellStock sellStockOrder = cp.new SellStock(abcStock);

        Broker broker = cp.new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
