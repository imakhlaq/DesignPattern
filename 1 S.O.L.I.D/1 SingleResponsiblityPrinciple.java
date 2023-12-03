/*
Single Responsiblity Principle means that one class should have one and only one responsibility. And only one actor(for one thing) should use that class.
 */

class shape {
    public void calculateArea() {

    }

    public String printInString() {
        return "data in string"
    }

}
/*
Above Shape class have methods that belong to only shape.
 */

class shapeCalculator {

    // this method helps to do calculations on shape
    public void calculateArea() {

    }

    //but this class print the data in string
    public String printInString() {
        return "data in string"
    }

}
/*
Above ShapeCalculator class have two methods.
 */