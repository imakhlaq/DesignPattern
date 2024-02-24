interface IPizza {

    void makePizza();
}

//base pizza
class BasePizza implements IPizza {

    @Override
    public void makePizza() {
        System.out.println("making normal pizzza");
    }
}

//Base Pizza Decorator class
class BasePizzaDecorator implements IPizza {

    protected IPizza pizza;

    BasePizzaDecorator(IPizza pizza) {
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
class CheesePizzaDecorator extends BasePizzaDecorator {

    protected IPizza pizza;

    CheesePizzaDecorator(IPizza pizza) {
        // we need a base pizza to customize a pizza
        super(pizza);
        this.pizza = pizza;
    }

    @Override
    public void makePizza() {
        //first basic pizza will be created and then u can make addition
        super.makePizza();

        //  this.addCheese();
    }

    // by these methods we are adding more functionality to base object (decorating)
    public void addCheese() {
        System.out.println("Adding cheese to pizza");
    }

    public void veggies() {
        System.out.println("Adding cheese to veggies");
    }

    // add more methods to customize the pizza object
}

class VegPizzaDecorator extends BasePizzaDecorator {

    protected IPizza pizza;

    VegPizzaDecorator(IPizza pizza) {
        super(pizza);
        this.pizza = pizza;
    }

    @Override
    public void makePizza() {
        // to make special pizza u need base pizza, so we are calling make pizza method
        super.makePizza();

        //this.addVeggies();
    }

    // by these methods we are adding more functionality to base object (decorating)
    public void addCheese() {
        System.out.println("Adding cheese to pizza");
    }

    public void addVeggies() {
        System.out.println("Adding cheese to pizza");
    }

    // add more methods to customize the pizza object
}

class DecoratorMain {
    public static void main(String[] args) {

        //customer adds veg pizza with cheese
        VegPizzaDecorator pizza = new VegPizzaDecorator(new BasePizza());
        pizza.makePizza();
        pizza.addCheese();

        //customer order pizza with veggies and cheese
        CheesePizzaDecorator cheesePizzaDecorator = new CheesePizzaDecorator(new BasePizza());
        cheesePizzaDecorator.makePizza();
        cheesePizzaDecorator.addCheese();
        cheesePizzaDecorator.veggies();


    }
}