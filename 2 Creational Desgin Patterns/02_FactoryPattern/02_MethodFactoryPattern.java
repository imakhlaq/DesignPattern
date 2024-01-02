interface ICard {
    String cardType();

    Double maxCredit();
}

class PlatinumCard implements ICard {

    @Override
    public String cardType() {
        return "Platinum Card";
    }

    @Override
    public Double maxCredit() {
        return 50000.40;
    }
}

class GoldCard implements ICard {

    @Override
    public String cardType() {
        return "Gold Card";
    }

    @Override
    public Double maxCredit() {
        return 10000.22;
    }
}

//u can replace with an Interface too
abstract class Factory {
    protected abstract ICard createFactory();

    public ICard getFactory() {
        return createFactory();
    }
}

//this will create abstraction over the Factory
class PlatinumCardFactory extends Factory {

    @Override
    protected ICard createFactory() {
        return new PlatinumCard();
    }
}

class GoldCardFactory extends Factory {

    @Override
    protected ICard createFactory() {
        return new GoldCard();
    }
}

class MainFactoryMethod {
    public static void main(String[] args) {
        var cardType = "gold";

        if (cardType.equalsIgnoreCase("gold")) {
            ICard card = new PlatinumCardFactory().createFactory();

        } else if (cardType.equalsIgnoreCase("platinum")) {
            ICard card = new GoldCardFactory().createFactory();

        }
    }
}