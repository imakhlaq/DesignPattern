interface IItem {
    Double getPrice();

    String getName();
}

abstract class Furniture implements IItem {
    String name;
    Double price;
}

abstract class Flower implements IItem {
    String name;
    Double price;
}

class KitchenFurniture extends Furniture {

    KitchenFurniture(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class LawnFurniture extends Furniture {
    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class IndoorFlower extends Flower {

    IndoorFlower(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class OutdoorFlower extends Flower {

    OutdoorFlower(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class Decor {

    //mandatory attr
    Furniture furniture;

    //optional
    Flower flower;


}