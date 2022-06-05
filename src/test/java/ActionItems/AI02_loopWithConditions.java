package ActionItems;

import java.util.ArrayList;

public class AI02_loopWithConditions {
    public static void main(String[] args) {
        //creating array list with cities
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");

//using array inside for loop print only when city is Brooklyn or city is Manhattan
        for (int i = 0; i < cities.size(); i++) {

            if (cities.get(i) == "Brooklyn" || cities.get(i) == "Manhattan") {
                System.out.println("City is " + cities.get(i));
            }


        }//end of for loop

    }//end of main method

}//end of java class
