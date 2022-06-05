package ActionItems;

public class AI01_whileLoop {

    public static void main(String[] args) {
        //iterate through region and its areaCode using linear array and while loop
        String[] region = new String[] {"11219", "11218", "90004", "33139"};
        int[] areaCode = new int[] {718,646,213,305};

        int i = 0;
        while(i < region.length){

            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);

            i = i + 1;
        }//end of while loop

    }//end of main method
}//end of java class
