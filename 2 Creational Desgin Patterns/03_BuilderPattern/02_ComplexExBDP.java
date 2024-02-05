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

    LawnFurniture(String name, Double price) {
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

    //optional attr
    Flower flower;

    Decor(DecorBuilder decorBuilder) {
        this.flower = decorBuilder.flower;
        this.furniture = decorBuilder.furniture;
    }


    public static class DecorBuilder {
        //mandatory attr
        Furniture furniture;

        //optional attr
        Flower flower;


        DecorBuilder(String furniture) {

            if (furniture.equalsIgnoreCase("Kitchen")) {
                this.furniture = new KitchenFurniture("chair", 22.3);
            } else {
                this.furniture = new LawnFurniture("table", 102.3);
            }
        }

        public DecorBuilder setFlower(String flower) {
            if (flower.equalsIgnoreCase("indoor")) {
                this.flower = new OutdoorFlower("chair", 22.3);
            } else {
                this.flower = new IndoorFlower("table", 104.3);
            }

            return this;
        }

        //more setters for more optional attr and return this. so u can chain stuff


        //builder method that is used to build
        public Decor build() {
            return new Decor(this);
        }

    }


}