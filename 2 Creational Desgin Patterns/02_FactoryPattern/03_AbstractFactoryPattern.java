interface IAnimal {
    void speak();

    void type();
}

//products
class Cat implements IAnimal {

    @Override
    public void speak() {
        System.out.println("Meow");
    }

    @Override
    public void type() {
        System.out.println("land");
    }
}

class Lion implements IAnimal {

    @Override
    public void speak() {
        System.out.println("Roarrr");
    }

    @Override
    public void type() {
        System.out.println("land");
    }
}

class Octopus implements IAnimal {

    @Override
    public void speak() {
        System.out.println("Gurrrr");
    }

    @Override
    public void type() {
        System.out.println("sea");
    }
}

//super factory
abstract class AnimalFactory {
    // land or sea factory need to implement this to return and object base on the param
    public abstract IAnimal getAnimal(String animalType);

    //static method to get the factory of a specific type
    public static AnimalFactory createAnimalFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("land")) {
            return new LandAnimalFactory();

        } else if (factoryType.equalsIgnoreCase("sea")) {
            return new SeaAnimalFactory();

        } else {
            System.out.println("Not supported");
        }
        return null;
    }

}

//sub category factory
class LandAnimalFactory extends AnimalFactory {

    @Override
    public IAnimal getAnimal(String animalType) {
        if (animalType.equalsIgnoreCase("lion")) {
            return new Lion();
        }
        if (animalType.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }
}

////sub category factory
class SeaAnimalFactory extends AnimalFactory {

    @Override
    public IAnimal getAnimal(String animalType) {

        if (animalType.equalsIgnoreCase("octopus")) {
            return new Octopus();
        } else if (animalType.equalsIgnoreCase("jellyfish")) {
            //create and return jellyfish

        }
        return null;
    }
}

class MainAbstractFactory {
    public static void main(String[] args) {
        //first getting factory of that type
        AnimalFactory animalFactory = AnimalFactory.createAnimalFactory("sea");
        //then using that factory getting the animal
        IAnimal lion = animalFactory.getAnimal("lion");
    }
}