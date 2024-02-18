import javax.management.monitor.Monitor;

// Strategy interface
interface IPayment {
    boolean payNow(String details);
}


// Concrete Strategy classes
//Strategy #1
class CreditCard implements IPayment {
    @Override
    public boolean payNow(String details) {

        // using details request to the server and transfer the money
        return false;
    }
}

//Strategy #2
class DebitCard implements IPayment {
    @Override
    public boolean payNow(String details) {

        // using details request to the server and transfer the money
        return false;
    }
}

//Strategy #3
class NetBanking implements IPayment {
    @Override
    public boolean payNow(String details) {
        return false;
    }
}

//Strategy #3
class UPI implements IPayment {
    @Override
    public boolean payNow(String details) {
        return true;
    }
}

//Context
class ProductC {

    String name;
    Double price;

    ProductC(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {

    ProductC product;
    IPayment payment;

    Order(ProductC product, IPayment payment) {
        this.payment = payment;
        this.product = product;
    }

    public String orderNow(String orderDetails) {

        if (payment.payNow(orderDetails)) return "order is places for " + product.name;

        return "Order is unsuccessful for " + product.name;
    }
}

//client
class StrategyMain {
    public static void main(String[] args) {

        // customer want to buy this product
        var monitor = new ProductC("LG UltraGear", 25000.0);

        // customer a payment method
        var chosenMethod = "UPI";
        if (chosenMethod.equalsIgnoreCase("creditCard")) {

            var order = new Order(monitor, new CreditCard());
            // card number
            var orderStatus = order.orderNow("91231488131331");

            System.out.println(orderStatus);
        }

        if (chosenMethod.equalsIgnoreCase("upi")) {

            var order = new Order(monitor, new UPI());
            // card number
            var orderStatus = order.orderNow("imakhlaq@upi");

            System.out.println(orderStatus);
        }

    }
}