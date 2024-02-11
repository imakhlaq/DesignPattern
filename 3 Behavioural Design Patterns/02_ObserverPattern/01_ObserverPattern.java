interface ICourse {
    //method to register a student (subscribing / adding observer)
    void register(IObserverStudent student);

    //method to unregister a student (unsubscribing / removing observer)
    void unregister(IObserverStudent student);

    //method to notify all the students (observers)
    void notifyObservers();

    //method to allow students (observers) to fetch the info
    //student can call and ask about the class
    String getUpdated(IObserverStudent student);
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

    //name for the topic
    private String topic;

    // to what its subscribing
    ICourse college;

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
        return this.topic;
    }
}

// class for all the subscribers/ students that is enrolled in the class
