class LoggerThreadSafe {

    private static volatile LoggerThreadSafe instance;
    private static final Object object = new Object();

    public static LoggerThreadSafe getInstance() {

        LoggerThreadSafe singleton = LoggerThreadSafe.instance;

        if (singleton == null) {
            
            synchronized (object) {
                singleton = LoggerThreadSafe.instance;

                if (singleton == null) {
                    instance = singleton = new LoggerThreadSafe();
                }

            }
        }

        return singleton;
    }

}