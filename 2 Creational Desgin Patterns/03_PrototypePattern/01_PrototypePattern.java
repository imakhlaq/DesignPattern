import java.util.HashMap;
import java.util.Map;

//implementing Cloneable interface so we can clone them
interface IDepartment extends Cloneable {
    String getRank();

    String getDepartmentType();

    void setRank(String rank);

    void setDepType(String depType);

}


abstract class Department implements IDepartment {

    private String rank;
    private String depType;

    @Override
    public String getRank() {
        return this.rank;
    }

    @Override
    public String getDepartmentType() {
        return this.depType;
    }

    @Override
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void setDepType(String depType) {
        this.depType = depType;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class CSEDep extends Department {

}

class ESCDep extends Department {
}

class CacheStore {

    static Map<String, Department> cache = new HashMap<>();


    static public Map<String, Department> loadFromCache() {
        return CacheStore.cache;
    }


    static public Object getFromCache(String type) throws CloneNotSupportedException {


        // mocking added some object in cache
        var cse = new CSEDep();
        cse.setRank("12");
        cse.setDepType("CSE");

        //cloning the object and storing in the cache
        var cloneCSE = cse.clone();
        CacheStore.StoreInCache((Department) cloneCSE);

        var esc = new ESCDep();
        esc.setRank("2");
        esc.setDepType("ESC");

        //cloning and storing object in the cache
        var cloneESC = esc.clone();
        CacheStore.StoreInCache((Department) cloneESC);

        return CacheStore.cache.get(type);
    }


    static public void StoreInCache(Department department) {

        //in the getFromCache(String type) methods we mocked storage

        //use any specific key in this way u cant keep multiple instances
        CacheStore.cache.put(department.getDepartmentType(), department);
    }
}

class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {

        //loading stuff from cache
        var setting = CacheStore.loadFromCache();
        if (setting.isEmpty()) {
            System.out.println("store is empty");
        } else {
            System.out.println("Rank " + setting.get("CSE").getRank());
            System.out.println("Rank " + setting.get("ESC").getDepartmentType());
        }

        //this method will create few objects and store it in the cache
        var CSECache = (CSEDep) CacheStore.getFromCache("CSE");
        if (CSECache.getRank() != null) {
            System.out.println("Rank " + CSECache.getRank() + " " + CSECache.getDepartmentType());
        }

        //this method will create few objects and store it in the cache
        var ESCCache = (ESCDep) CacheStore.getFromCache("ESC");
        if (ESCCache.getRank() != null) {
            System.out.println("Rank " + ESCCache.getRank() + " " + ESCCache.getDepartmentType());
        }


    }
}