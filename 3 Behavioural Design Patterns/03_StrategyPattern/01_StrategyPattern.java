
// Strategy interface
interface IPayment {
    boolean payNow(String details);
}


// Concrete Strategy classes
//Strategy #1
class CreditCard implements IPayment {
    @Override
    public boolean payNow(String details) {
        return false;
    }
}

//Strategy #2
class DebitCard implements IPayment {
    @Override
    public boolean payNow(String details) {
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

//Context
class ProductC {

    String name;
    String price;
}

//client
class StrategyMain {
    public static void main(String[] args) {

    }
}