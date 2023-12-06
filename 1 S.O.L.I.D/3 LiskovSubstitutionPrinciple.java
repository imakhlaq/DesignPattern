/*
Liskov Substitution Principle states that sub/child class can be replaced by super/parent class.



It is way too test IS-A (inheritance) relationship.



Animal
  |
Insect
  |
Snail


if one thing is true for something it has to be true for all its descendants. Like if Animal can speak
and snail, which is child of animal have to have speak property. Or inheritance there is not valid.


That why most of the time we look for composition not inheritance. Because in composition it's not
required that container should have all properties.

It means loosely coupled relations stick together.

 */

interface ICat {

    void meow();

    void drinkMilk();
}

class PetCat implements ICat {

    @Override
    public void meow() {
        System.out.println("Meow Meow");
    }

    @Override
    public void drinkMilk() {
        System.out.println("Drinking Milk");
    }
}

class MechanicalCat implements ICat {

    @Override
    public void meow() {
        System.out.println("Meow Meow");
    }

    @Override
    public void drinkMilk() {
        //mechanical cat can't drink water
        throw new RuntimeException("Mechanical cat can/'t drink milk");
    }
}

class MainLSP {
    public static void main(String[] args) {

        ICat petCat = new PetCat();
        ICat mechanicalCat = new MechanicalCat();

        petCat.meow();
        petCat.drinkMilk();

        mechanicalCat.meow();
        mechanicalCat.drinkMilk();
        /*
        Here subclass can't be replaced with superclass.

        ICat (superclass/interface)  == MechanicalCat (subclass)  =====>❌
        ICat (superclass/interface)  == PetCat (subclass)         =====>✅


        ICat (superclass) cant replace MechanicalCat (subclass) because mechanical cat can't drink Milk. So we are breaking the Liskov Substitution.
        The solution is I (Interface Segregation Principle ) in S.O.L.I.D
        */

    }
}