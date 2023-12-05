/*
Open/Close Principle State that a class should be open for extension/new features but close for the modification (i.e. close for modification in existing code.So u don't have to modify the code and test again).
*/

class Restaurant {

    public void serveFood(String order){
        if (order.toLowerCase().equals("pizza")==true){
            System.out.println("Tell cheif cook to cook piza");
        }
        else if (order.toLowerCase().equals("biryani")==true){
            System.out.println("Tell cheif cook to cook biryani");
        }
        else if (order.toLowerCase().equals("roasted")==true){
            System.out.println("Tell cheif cook to cook roasted");
        }
    }
    
}

/*
Imagine now your resturent now also started serving "aalu paratha".now u have to add functionality like this..


class Restaurant {

    public void serveFood(String order){
        if (order.toLowerCase().equals("pizza")==true){
            System.out.println("cook piza");
        }
        else if (order.toLowerCase().equals("biryani")==true){
            System.out.println("cook biryani");
        }
        else if (order.toLowerCase().equals("roasted")==true){
            System.out.println("cook roasted");
        }
        //NEW FOOD ADDED
         else if (order.toLowerCase().equals("aalu paratha")==true){
            System.out.println("cook aalu paratha");
        }
    }

}

But now you have broken the open close principle because you have modified the previous implementation.
Above code is also breaking the SPR because in the Restaurant class you can argua that cooking does not belong their..
 */

interface IFood {
    String cheifCook();
}

class Pizza implements IFood{

    @Override
    public String cheifCook() {
       //code to cook pizza
        return "cook piza";

    }
}

class Biryani implements IFood{

    @Override
    public String cheifCook() {
        //code to cook pizza
        return "cook Biryani";
    }
}
//........ more dished with foodI implemented

//now every time a food is added. create a class and and implemnt the IFood interface
class AlluParatha implements IFood{

    @Override
    public String cheifCook() {
        //code to cook pizza
        return "cook AlluParatha";
    }
}


class RestaurantWithOCP {
    //now u have dont have to modify the code of serving even after we add a new meal to resturent
    public void serveFood(IFood order){
       var myOrder=order.cheifCook();
    }

}

class Main {
    public static void main(String[] args) {

        var restaurantWithOCP=new RestaurantWithOCP();
        restaurantWithOCP.serveFood(new Pizza());
        restaurantWithOCP.serveFood(new AlluParatha());
        restaurantWithOCP.serveFood(new Biryani());
        restaurantWithOCP.serveFood(new Pizza());
    }
}

/*

 */