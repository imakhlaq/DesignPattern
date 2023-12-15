
class Logger {

    String loggerFilePath;

    // to store the instance of the Logger
    Logger singleInstance;

    // private constructor to restrict the creation of object from outside of the class
    private Logger(String loggerFilePath) {
        this.loggerFilePath = loggerFilePath;
    }

    // static method to get the instance of the logger class
    public static Logger getInstance(String loggerFilePath) {

        if (this.singleInstance != null) return this.singleInstance;

        this.singleInstance = new Logger(loggerFilePath);
        return this.singleInstance;
    }

    public void debugg(String data) {
        System.out.println(data);
    }
}


class SingletonePattern {
    public static void main(String[] args) {
        Logger log = Logger.getInstance("F:data");
        log.debugg("logg here");
    }
}