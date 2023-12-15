class LoggerEagerLoading {

    //at time of class loading creating instance
    private static LoggerEagerLoading loggerEagerLoading = new LoggerEagerLoading();

    public static LoggerEagerLoading getInstance() {
        return LoggerEagerLoading.loggerEagerLoading;
    }

    public void debug(String data) {
        System.out.println(data);
    }
}

class SingletonPatternWithEagerLoading {
    public static void main(String[] args) {

        //creating instance using static method
        LoggerEagerLoading log = LoggerEagerLoading.getInstance();
        log.debug("logg here");
    }
}



/*
Pros
    -Thread safe
    -Easy to implement

Cons
    -No args can be passed

 */