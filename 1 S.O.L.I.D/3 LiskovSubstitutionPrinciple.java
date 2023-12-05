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