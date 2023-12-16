interface ICar {
    String carColor();

    Double maxSpeed();

    Double mileage();
}

//product
class BasicCar implements ICar {

    @Override
    public String carColor() {
        return "Blue color";
    }

    @Override
    public Double maxSpeed() {
        return 150.2;
    }

    @Override
    public Double mileage() {
        return 20.2;
    }
}

//product
class SportsCar implements ICar {

    @Override
    public String carColor() {
        return "Red and White";
    }

    @Override
    public Double maxSpeed() {
        return 250.2;
    }

    @Override
    public Double mileage() {
        return 8.4;
    }
}


// factory that create cars
class CarFactory {
    public static ICar carFactory(String carType) {

        if (carType.equalsIgnoreCase("sports")) {
            return new SportsCar();
        } else if (carType.equalsIgnoreCase("basic")) {
            return new BasicCar();
        } else {
            System.out.println("Invalid car");
        }
        return null;
    }
}

class MainFactory {
    public static void main(String[] args) {
        //u can create as many instance u need
        ICar sportsCar = CarFactory.carFactory("sports");

        ICar basicCar = CarFactory.carFactory("basic");
    }
}