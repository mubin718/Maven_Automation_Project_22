package ActionItems;


import java.util.ArrayList;

public class AI01_forLoop {

    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Bangladesh");
        country.add("Canada");
        country.add("Mexico");

        //declare integer for ArrayList
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(416);
        countryCode.add(52);
        
        //Using String country and int countryCode with for loop and ArrayList
        for (int i = 0; i < country.size(); i++){


            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of loop


    }//end of main method
}//end of java class
