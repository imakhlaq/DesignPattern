
// Lazy loading


class LoggerLazyLoading {

    // to store the instance of the Logger
    private static LoggerLazyLoading singleInstance;

    String loggerFilePath;

    // private constructor to restrict the creation of object from outside the class
    private LoggerLazyLoading(String loggerFilePath) {
        this.loggerFilePath = loggerFilePath;
    }

    // static method to get the instance of the logger class
    public static LoggerLazyLoading getInstance(String loggerFilePath) {

        //checking if instance already exits
        if (LoggerLazyLoading.singleInstance != null) return LoggerLazyLoading.singleInstance;

        //if not create and store in class and return
        LoggerLazyLoading.singleInstance = new LoggerLazyLoading(loggerFilePath);
        return LoggerLazyLoading.singleInstance;
    }

    public void debug(String data) {
        System.out.println(data);
    }
}


class SingletonPattern {
    public static void main(String[] args) {

        //creating instance using static method
        LoggerLazyLoading log = LoggerLazyLoading.getInstance("F:data");
        log.debug("logg here");
    }
}