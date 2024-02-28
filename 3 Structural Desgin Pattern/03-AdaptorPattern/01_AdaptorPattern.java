//the target class
//your UPI service that only pay using INR
class TransactionForINR {

    public void pay(Double money) {
        System.out.println("Paying using INR " + money);
    }
}

//interface for adaptor
// interface to adaptor
interface IInternationalCurrency {
    void pay(String currency, Double amt);
}

//adapter class
class InternationalCurrency implements IInternationalCurrency {

    @Override
    public void pay(String currency, Double amt) {

        TransactionForINR transactionForINR = new TransactionForINR();

        if (currency.equalsIgnoreCase("dollar")) {
            transactionForINR.pay(this.convertDollarToINR(amt));

        } else if (currency.equalsIgnoreCase("euro")) {
            transactionForINR.pay(this.convertEuroToINR(amt));
        }
    }

    // convert the dollar to inr
    private Double convertDollarToINR(Double amt) {

        return amt * 82.4;
    }

    // convert the dollar to inr
    private Double convertEuroToINR(Double amt) {

        return amt * 95;
    }
}

//adaptee class


//client class
class AdaptorMain {
    public static void main(String[] args) {


        //for indian user they can pay using INR so u don't need the adaptor
        TransactionForINR transactionForINR = new TransactionForINR();
        transactionForINR.pay(45.33);

        //for the USA and british u need to use adaptor to convert their currency to INR
        IInternationalCurrency internationalCurrency = new InternationalCurrency();
        internationalCurrency.pay("dollar", 12.0);
        internationalCurrency.pay("euro", 6.0);
    }
}
