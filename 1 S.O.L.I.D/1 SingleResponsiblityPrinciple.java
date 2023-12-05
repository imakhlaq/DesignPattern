/*
Single Responsibility Principle means that one class should have one and only one responsibility. And only one actor(for one thing) should use that class.
*/

class shape {

    public void calculateArea() {

    }

    public String printInString() {
        return "data in string";
    }

}
/*
Above Shape class have methods that belong to only shape.
*/

//==========================================================================================================================================

class shapeCalculator {

    // this method helps to do calculations on shape
    public void calculateArea() {

    }

    //breaking SRS
    public String printInJSON() {
        return "data in string";
    }

}
/*
Above ShapeCalculator class have two methods.

printInString(): This method print in JSON. Which is different from doing calculation. And it will be used where u need to print the data in JSON format. So another actor is going to be using this method so u have to define this menthod in andother class.


FIX:
*/

class ShapeCalculator {

    // this method helps to do calculations on shape
    public void calculateArea() {

    }
}

class shapePrint{

    //Not-breaking SRS
    public String printInJSON() {
        return "data in string";
    }
}

//==========================================================================================================================================

class Employee {

    private void getEmployeesDetails(String employee) {

    }

    public void hireEmployee(String employee) {

    }

    public void getSalary(String employee) {

    }

    public void getStatus(String employee) {

    }

    public void evaluateEmployee(String employee) {

    }
}

/*
Employee class only contains methods related to employee. Yet it is breaking SRS....how?

class Employee{

    private void getEmployeesDetails(String employee){  => will be used by rest of the method to get details of employee

    }
    public void hireEmployee(String employee){         => used by HR

    }
    public void getSalary(String employee){            => used by financial team

    }
    public void getStatus(String employee){            =>  used by manager

    }
    public void evaluateEmployee(String employee){     => used by manager

    }
}
Even though this employee class have only employees related methods but 4 actors are going to use these method. So multiple actor like HR, Financial team, Manager are going to access these methods so this break the single responsibility principle.

*/

// FIX

abstract class EmployeeDetails {

    private void getEmployeesDetails(String employee){ // => will be used by rest of the method to get details of employee

    }
}

class ManageEmployee extends EmployeeDetails{

    public void getStatus(String employee){          //  =>  used by manager

    }
    public void evaluateEmployee(String employee){   //  => used by manager

    }
}

class EmployeeSalary extends EmployeeDetails{

    public void getSalary(String employee){           // => used by financial team

    }
}


class HireEmployee extends EmployeeDetails{

    public void hireEmployee(String employee){       //  => used by HR


    }
}