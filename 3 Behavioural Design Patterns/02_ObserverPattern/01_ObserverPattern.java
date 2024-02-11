import java.util.LinkedList;
import java.util.List;

interface ICourse {
    //method to register a student (subscribing / adding observer)
    void register(IObserverStudent student);

    //method to unregister a student (unsubscribing / removing observer)
    void unregister(IObserverStudent student);

    //method to notify all the students (observers)
    void notifyAllObservers();

    //method to allow students (observers) to fetch the info
    //student can call and ask about the class
    String getUpdated(IObserverStudent student);

    //to update the topic
    void setStudyTopic(String topic);
}

//interface for the subscriber
interface IObserverStudent {
    //this method will update the student (observers)
    void update();

    //=> u can think these two as the setting type of event and
    //   getting type of event and base on the event take action

    // this will set the class topic (topic)
    void setClass(ICourse college);

    //student can get the class topic
    String getName();

}

//class for the individual student
class CourseSubscriber implements IObserverStudent {

    //name of student
    private String name;

    //to what its subscribing
    ICourse college;

    CourseSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        /*
        In the gmail u have option to fetch the updated data.
        (i.e. the mail u got latest)
         */
        String collegePlan = college.getUpdated(this);
        System.out.println("fetching... The college plan");
        System.out.println("It is " + collegePlan);
    }

    @Override
    public void setClass(ICourse college) {
        this.college = college;
    }

    @Override
    public String getName() {
        //name of the topic
        return this.name;
    }
}

// class for all the subscribers/ students that is enrolled in the class
class CSE implements ICourse {

    List<IObserverStudent> allStudents = new LinkedList<>();
    String topic;

    @Override
    public void register(IObserverStudent student) {
        allStudents.add(student);
        System.out.println(student.getName() + " is registered");
    }

    @Override
    public void unregister(IObserverStudent student) {
        allStudents.remove(student);
        System.out.println(student.getName() + " is unregistered");

    }

    @Override
    public void notifyAllObservers() {
        for (IObserverStudent student : allStudents) {
            student.update();
        }
    }

    @Override
    public String getUpdated(IObserverStudent student) {

        if (allStudents.contains(student)) {
            System.out.println(student.getName() + " Today's topic is " + this.topic);
        }
        return this.topic;
    }

    // to update the topic
    public void setStudyTopic(String topic) {
        this.topic = topic;

        // and when set the topic we need to notify all observers
        this.notifyAllObservers();
    }
}

class ObserverMain {
    public static void main(String[] args) {

        ICourse cse = new CSE();
        cse.setStudyTopic("kentai");

        IObserverStudent akhlaq = new CourseSubscriber("akhlaq");
        //registering student (observers) to a class
        cse.register(akhlaq);

        // attaching which class a student belong to
        akhlaq.setClass(cse);

        IObserverStudent dilsad = new CourseSubscriber("dilshad");
        cse.register(dilsad);
        dilsad.setClass(cse);

        IObserverStudent hesham = new CourseSubscriber("hesham");
        hesham.setClass(cse);
        cse.register(hesham);

        cse.setStudyTopic("hentai");

    }
}