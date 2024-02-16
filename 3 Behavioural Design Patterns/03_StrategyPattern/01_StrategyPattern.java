interface IPayment {
    boolean payNow(String details);
}


class CreditCard implements IPayment {
    @Override
    public boolean payNow(String details) {
        return false;
    }
}

class DebitCard implements IPayment {
    @Override
    public boolean payNow(String details) {
        return false;
    }
}

class NetBanking implements IPayment {
    @Override
    public boolean payNow(String details) {
        return false;
    }
}