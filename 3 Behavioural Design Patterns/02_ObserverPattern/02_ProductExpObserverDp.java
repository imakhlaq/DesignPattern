import java.util.LinkedList;
import java.util.List;

// this is need to be observed
interface IProduct {
    void subscribe(IBuyers buyers);

    void unsubscribe(IBuyers buyers);

    void notifyAllSubs();

    String[] getUpdated(IBuyers buyers);

    void changeStatus(String stockStatus);
}


//this is the observer
interface IBuyers {

    void buyProduct(String name);

    void returnProduct(String name);

    void update();

    void setProduct(IProduct subject);

}

//subject is what is need to be observed
class Product1 implements IProduct {

    public String productName;
    public String stocks;
    public String price;

    //adding buyers/observers to the List that need to be notified
    public List<IBuyers> buyersList = new LinkedList<>();

    // setting name, price, stocks (topic)
    Product1(String productName, String stocks, String price) {
        this.price = price;
        this.stocks = stocks;
        this.productName = productName;
    }

    @Override
    public void subscribe(IBuyers buyer) {
        this.buyersList.add(buyer);
    }

    @Override
    public void unsubscribe(IBuyers buyer) {
        this.buyersList.remove(buyer);
    }

    @Override
    public void notifyAllSubs() {
        for (var buyer : buyersList) {
            buyer.update();
        }
    }

    @Override
    public String[] getUpdated(IBuyers buyer) {
        if (this.buyersList.contains(buyer)) {

            return new String[]{this.productName, this.stocks, this.price};

        }
        return null;
    }

    @Override
    public void changeStatus(String status) {
        this.stocks = status;
        this.notifyAllSubs();
    }
}

//observer
class Buyers implements IBuyers {

    String name;
    IProduct product;

    Buyers(String name, IProduct product) {
        this.name = name;

        this.product = product;
        product.subscribe(this);
    }

    public void update() {
        var productDetails = this.product.getUpdated(this);

        System.out.println(this.name + " " + productDetails[0] + " price is " +
                productDetails[2] + " and only " + productDetails[1] + " are in stocks");
    }

    @Override
    public void buyProduct(String name) {
        //name can be used to determine product if customer have many products.(u also need to maintain a List)
        if (product.getUpdated(this)[1].equals("OUTOFSTOCK")) {
            System.out.println("It's out of stock");
            return;
        } else if (product.getUpdated(this)[1].equals("0")) {
            product.changeStatus("OUTOFSTOCK");
            return;

        }
        product.changeStatus(String.valueOf(Integer.parseInt(product.getUpdated(this)[1]) - 1));


    }

    @Override
    public void returnProduct(String name) {
        if (product.getUpdated(this)[1].equals("OUTOFSTOCK")) {
            product.changeStatus("OUTOFSTOCK");
            return;
        }
        product.changeStatus(String.valueOf(Integer.parseInt(product.getUpdated(this)[1]) - 1));

    }

    //no need to add because in constructor you're passing the product that need to observe
    @Override
    public void setProduct(IProduct product) {

    }
}

class ProductObserver {
    public static void main(String[] args) {

        IProduct tv = new Product1("LG", "3", "1999");
        IProduct mobile = new Product1("s23 Ultra", "10", "1399");

        IBuyers akhlaq = new Buyers("Akhlaq", mobile);

        IBuyers hesham = new Buyers("hesham", mobile);
        IBuyers akhlaqtv = new Buyers("akhlaq", tv);

        akhlaq.buyProduct("s23 Ultra");
        akhlaq.buyProduct("s23 Ultra");
        mobile.unsubscribe(hesham);
        akhlaq.buyProduct("s23 Ultra");
        //error happening because customer is unsubscribing, and it does not existing in the products list so its returning true.
        hesham.returnProduct("s23 Ultra");
        akhlaq.update();
    }
}