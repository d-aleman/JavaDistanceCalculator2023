public class DistanceV5 {
	
	public static void main(String[] args) {
		
		DistanceCalculator dc = new DistanceCalculator();
        boolean doContinue = true;
        
        do {
            System.out.println("\n-----------------------------------------------------");
            System.out.println("Distance calculator (enter 0 for both values to quit)");
            System.out.println("-----------------------------------------------------");
            
            dc.getUserInput();
            if (dc.getSpeed() == 0 && dc.getTime() == 0)
            {
                doContinue = false;
            }
            else
            {
                dc.printDistance();
            }
            
		} while (doContinue);
        
        System.out.println("\nGoodbye!");
        
	} // end of main function
		
} // end of class
