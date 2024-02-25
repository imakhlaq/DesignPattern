interface IPizza {

    //all the special methods that will be added need to be called in this method
    void makePizza();
}

//base pizza
class BasePizza implements IPizza {

    @Override
    public void makePizza() {
        System.out.println("making normal pizza");
    }
}

//Base Pizza Decorator class
// u dont need to create class of basic decorator
abstract class PizzaDeco implements IPizza {

    protected IPizza pizza;

    PizzaDeco(IPizza pizza) {
        this.pizza = pizza;
    }

    /*
     u can add more method and fields here and there u have a pizza object also
     and u have access to its all properties and methods inside this class.
    */

    @Override
    public void makePizza() {
        pizza.makePizza();

    }
}

// Cheese Pizza Decorator class
class CheesePizzaDeco extends PizzaDeco {

    protected IPizza pizza;

    CheesePizzaDeco(IPizza pizza) {
        // we need a base pizza to customize a pizza
        super(pizza);
        this.pizza = pizza;
    }

    @Override
    public void makePizza() {
        //first basic pizza will be created and then u can make addition
        super.makePizza();

        //adding cheese
        this.addCheese();

    }

    // by these methods we are adding more functionality to base object (decorating)
    private void addCheese() {
        System.out.println("Adding cheese to pizza");
    }

    private void veggies() {
        System.out.println("Adding cheese to veggies");
    }

    // add more methods to customize the pizza object
}

class VegPizzaDeco extends PizzaDeco {

    protected IPizza pizza;

    VegPizzaDeco(IPizza pizza) {
        super(pizza);
        this.pizza = pizza;
    }

    @Override
    public void makePizza() {
        // to make special pizza u need base pizza, so we are calling make pizza method
        super.makePizza();

        //add veggies
        this.addVeggies();
    }

    // by these methods we are adding more functionality to base object (decorating)
    private void addCheese() {
        System.out.println("Adding cheese to pizza");
    }

    private void addVeggies() {
        System.out.println("Adding cheese to pizza");
    }

    private void addChicken() {
        System.out.println("Adding cheese to chicken");
    }
    // add more methods to customize the pizza object
}

class DecoratorMain {
    public static void main(String[] args) {

        //customer adds veg pizza with cheese
        IPizza vegPizza = new VegPizzaDeco(new BasePizza());
        vegPizza.makePizza();

        //customer order pizza with veggies and cheese
        IPizza cheesePizza = new CheesePizzaDeco(new BasePizza());
        cheesePizza.makePizza();

        //passing cheesePizza in the vegPizza + chicken too


    }
}