

//eager loading is thread safe by default
class LoggerThreadSafeBasic {

    private static LoggerThreadSafeBasic instance = new LoggerThreadSafeBasic();

    public static LoggerThreadSafeBasic getInstance() {

        return LoggerThreadSafeBasic.instance;
    }
}

// using the synchronized method
class LoggerThreadSafeSyncMethod {

    private static LoggerThreadSafeSyncMethod instance;

    public static synchronized LoggerThreadSafeSyncMethod getInstance() {

        if (LoggerThreadSafeSyncMethod.instance != null) return LoggerThreadSafeSyncMethod.instance;

        LoggerThreadSafeSyncMethod.instance = new LoggerThreadSafeSyncMethod();
        return LoggerThreadSafeSyncMethod.instance;

    }
}


//BEST using sync block and volatile keyword
class LoggerThreadSafe {

    private static volatile LoggerThreadSafe instance;
    private static final Object object = new Object();

    public static LoggerThreadSafe getInstance() {

        //this increase performance by margin
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