/*
Liskov Substitution Principle states that sub/child class can be replaced by super/parent class.
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