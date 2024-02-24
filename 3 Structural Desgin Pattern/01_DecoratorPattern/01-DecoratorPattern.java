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

//Base Decorator class
class BasePizzaDecorator implements IPizza {

    protected IPizza pizza;

    public void decorate(IPizza pizza) {
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