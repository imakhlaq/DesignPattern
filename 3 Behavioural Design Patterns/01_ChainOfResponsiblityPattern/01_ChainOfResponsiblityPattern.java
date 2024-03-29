import java.util.LinkedList;
import java.util.List;

//it is used to replace if else hell
interface IApplicant {
    boolean setDetails(String name, Integer age, String email);

    boolean setSkill(List<String> skills);
}

class Person implements IApplicant {

    String name;
    Integer age;
    String email;
    List<String> skills = new LinkedList<>();

    @Override
    public boolean setDetails(String name, Integer age, String email) {

        if (name.isEmpty() || age < 16 || email.isEmpty()) return false;

        this.name = name;
        this.age = age;
        this.email = email;
        return true;
    }

    @Override
    public boolean setSkill(List<String> skills) {

        if (skills.isEmpty()) return false;

        this.skills.addAll(skills);
        return true;
    }
}

//the handler interface
interface IJobChain {
    //method that is used to set next handler
    void setNextChain(IJobChain jobChain);

    //the logic to do the work and in else condition call hire applicant on the person
    void hireApplicant(Person person);
}

//sol1
class MANG implements IJobChain {

    //jobChain that will be injected throw set nextChain method
    private IJobChain jobChain;

    @Override
    public void setNextChain(IJobChain jobChain) {
        //assigning the next jobchain
        this.jobChain = jobChain;
    }

    @Override
    public void hireApplicant(Person person) {
        if (person.skills.contains("dsa")) {
            System.out.println("selected for the MANG");
        } else {

            //calling for next chain for solution
            jobChain.hireApplicant(person);
        }
    }

}

//sol2
class Product implements IJobChain {

    private IJobChain jobChain;

    @Override
    public void setNextChain(IJobChain jobChain) {

        this.jobChain = jobChain;
    }

    @Override
    public void hireApplicant(Person person) {
        if (person.skills.contains("Product")) {
            System.out.println("selected from Product");
        } else {

            this.jobChain.hireApplicant(person);
        }
    }
}

//sol3
class Service implements IJobChain {

    private IJobChain jobChain;

    @Override
    public void setNextChain(IJobChain jobChain) {

        this.jobChain = jobChain;
    }

    @Override
    public void hireApplicant(Person person) {
        if (person.skills.contains("Service")) {
            System.out.println("selected for service");
        } else {

            jobChain.hireApplicant(person);
        }
    }
}

class ChainOfResponsiblity {
    public static void main(String[] args) {

        MANG mang = new MANG();
        Product product = new Product();
        Service service = new Service();

        // MANG -> Product -> Service
        /*
        if mang does not work call for the product and product does not work call for the service.
        NOTE: one must be correct soln.
         */
        //setting the next chain. if current doesn't work
        mang.setNextChain(product);
        product.setNextChain(service);

        Person p1 = new Person();
        p1.setDetails("Akhlaq", 22, "imakhlaqxd@gmail.com");
        p1.setSkill(List.of("Service"));

        Person p2 = new Person();
        p2.setDetails("Dilshad", 18, "dilshad@gmail.com");
        p2.setSkill(List.of("dsa"));

        mang.hireApplicant(p1);
        mang.hireApplicant(p2);
    }
}