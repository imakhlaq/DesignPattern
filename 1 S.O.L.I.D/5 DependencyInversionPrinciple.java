/*
It says that higher classes should not directly depend on the low level classes.
Both should depend upon level of abstraction.


A higher level class should not have much information about low level class
 */


class Actor {
    public void hireActor() {
        System.out.println("Hired an Actor");
    }

}

class Director {
    public void hireActor() {
        System.out.println("Hired an Director");
    }

}

class Producer {
    public void hireActor() {
        System.out.println("Hired an Actor");
    }

}

class Writer {
    public void hireActor() {
        System.out.println("Hired an Actor");
    }

}
