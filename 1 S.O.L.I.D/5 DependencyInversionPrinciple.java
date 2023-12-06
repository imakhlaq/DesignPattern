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
    public void hireDirector() {
        System.out.println("Hired an Director");
    }

}

class Producer {
    public void hireProducer() {
        System.out.println("Hired an Actor");
    }

}

class Writer {
    public void hireWriter() {
        System.out.println("Hired an Actor");
    }

}


//now moviemaker is needed to hire the all people


class MovieMaker {

    public void makeMovie() {

        var actor = new Actor();
        var director = new Director();
        var producer = new Producer();
        var writer = new Writer();

        actor.hireActor();
        director.hireDirector();
        producer.hireProducer();
        writer.hireWriter();


        /*
        Breaking Open Close Principle too
        var dancer = new dancer();
        dancer.hireDancer();

         */

    }

}

/*now our MovieMaker class which is a higher level class is dependent on these low level classes like
 Actor, Director, Producer, Writer.

So it's breaking the Dependency inversion principle.


MovieMaker class is also breaking the Open Close Principle. Because if u want to hire a Dancer now
u have to modify the makeMovie()
 */


//FIX

interface IMovieMaker {
    void hirePeople();
}

//Low level classes
class ActorDIP implements IMovieMaker {

    @Override
    public void hirePeople() {
        System.out.println("Hired Actor");

    }
}

class DirectorDIP implements IMovieMaker {

    @Override
    public void hirePeople() {
        System.out.println("Hired an Director");
    }
}

class ProducerDIP implements IMovieMaker {

    @Override
    public void hirePeople() {
        System.out.println("Hired an Actor");
    }
}

class WriterDIP implements IMovieMaker {

    @Override
    public void hirePeople() {
        System.out.println("Hired an Actor");
    }
}


//High level class
class MovieMakerDIP {

    public void makeMovie(IMovieMaker movieMaker) {
        movieMaker.hirePeople();

        /*
       Now OCP is also not breaking
         */
    }
}

/*
Now there is no dependency between the low level classes and high level class.
 */

class Main {
    public static void main(String[] args) {
        MovieMakerDIP movieMakerDIP = new MovieMakerDIP();

        movieMakerDIP.makeMovie(new ActorDIP());
        movieMakerDIP.makeMovie(new ProducerDIP());
        movieMakerDIP.makeMovie(new WriterDIP());

            /*
       movieMakerDIP.makeMovie(new DancerDIP());

         */

    }
}


/*
                                    MovieMakerDIP (High level class)
                                          |
                                          |
                                     IMovieMaker      (Interface)
                                          |
                                          |
                ActorDIP               DirectorDIP           ProducerDIP (Low level classes)

eg: Always remember that if a company CEO want to talk to employees he has to do with using the managers
of each office.


 */