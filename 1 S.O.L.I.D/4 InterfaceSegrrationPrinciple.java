/*
Interface Segregation Principle states that instead of having a big interface with a bunch of methods. Divide them into small interfaces.

A class should not be forced to implement all the methods that it does not require.

So we need ISP for this
 */

interface IMechanicalCat {
    void meow();
}

interface IPetCat extends IMechanicalCat {
    void drinkMilk();
}

class MechanicalCatISP implements IMechanicalCat {
    @Override
    public void meow() {
        System.out.println("Meow Meow");
    }
}

class PetCatISP implements IPetCat {

    @Override
    public void meow() {
        System.out.println("Meow Meow");
    }

    @Override
    public void drinkMilk() {
        System.out.println("Drinking Milk");
    }
}

class MainISP {
    public static void main(String[] args) {

        IMechanicalCat mechanicalCat = new MechanicalCatISP();
        IPetCat petCat = new PetCatISP();

        petCat.meow();
        petCat.drinkMilk();

        mechanicalCat.meow();

        /*
        Here we have separated one interface into multiple interface. So we don't have to implement those methods that are not needed in the class.


        Now subclass can be replaced by the super class. So this will validate the Liskov Substitution Principle.

        IMechanicalCat (superclass/interface)  == MechanicalCatISP (subclass)
        IPetCat (superclass/interface)  == PetCatISP (subclass)


         */

    }
}
