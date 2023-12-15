
class Logger {

    // to store the instance of the Logger
    private static Logger singleInstance;

    String loggerFilePath;

    // private constructor to restrict the creation of object from outside the class
    private Logger(String loggerFilePath) {
        this.loggerFilePath = loggerFilePath;
    }

    // static method to get the instance of the logger class
    public static Logger getInstance(String loggerFilePath) {

        //checking if instance already exits
        if (Logger.singleInstance != null) return Logger.singleInstance;

        //if not create and store in class and return
        Logger.singleInstance = new Logger(loggerFilePath);
        return Logger.singleInstance;
    }

    public void debug(String data) {
        System.out.println(data);
    }
}


class SingletonPattern {
    public static void main(String[] args) {

        //creating instance using static method
        Logger log = Logger.getInstance("F:data");
        log.debug("logg here");
    }
}