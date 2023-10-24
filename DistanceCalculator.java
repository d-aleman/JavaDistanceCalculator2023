import java.io.*;

public class DistanceCalculator {

	private double speed; // speed (unit determined by user)
	private double time;  // time (min)
    private String distanceUnit; // distance unit ("mi" or "km")
    private String convertedDistanceUnit; // distance unit not selected
    private String speedUnit; // sped unit ("mph" or "kph")

	public DistanceCalculator() {
		this.speed = 0;
		this.time = 0;
        this.distanceUnit = "mi";
        this.convertedDistanceUnit = "km";
        this.speedUnit = "mph";
	}

	public void getUserInput() {
        this.getDistUnit();
		this.speed = this.getNonnegDouble("Enter a speed (" + this.speedUnit + "): ");
		this.time = this.getNonnegDouble("Enter a time traveled (minutes): ");
	}

	public void printDistance() {
        double dist = this.calcDist();
        double convertedDist = this.convertDistance(dist);
		System.out.format("The distance traveled is %.3f %s (%.3f %s).\n", dist, this.distanceUnit, convertedDist, this.convertedDistanceUnit);
	}
    
    public double convertDistance(double dist) {
        final double MI_TO_KM = 1.60934;
        double convertedDist = this.distanceUnit.equals("mi") ? dist * MI_TO_KM : dist / MI_TO_KM;
        return convertedDist;
    }
	
	public double calcDist() {
		return this.speed * this.time / 60.0;
	}
	
	// get a non-negative double from the user
	public double getNonnegDouble(String prompt) {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		double x = 0;
		boolean valid;
		do {
			valid = true;
			System.out.print(prompt);
			try {
				x = Double.parseDouble(cin.readLine());
			} 
			catch (NumberFormatException e) {
				System.out.println("ERROR: Number format exception!\n");
				valid = false;
			} 
			catch (IOException e) {
				System.out.println("ERROR: IO exception!\n");
				valid = false;
			}
			if (valid && x < 0) {
				valid = false;
				System.out.println("ERROR: Value must be non-negative!\n");
			}
		} while (!valid);
		return x;
	} // end of getNonnegDouble()
    
    // get a distance unit from user, either "mph" or "km"
    public void getDistUnit() {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String unit = "";
        boolean valid;
        do {
            valid = true;
            System.out.print("Enter a distance unit (\"mi\" or \"km\"): ");
            try {
                unit = cin.readLine();
            }
            catch (IOException e) {
                System.out.println("ERROR: IO exception!\n");
                valid = false;
            }
            if (valid && !(unit.equals("mi") || unit.equals("km")) ) {
                valid = false;
                System.out.println("ERROR: Invalid distance unit!\n");
            }
        } while (!valid);
        
        // Assign converted distance unit, speed unit according to distance unit
        this.distanceUnit = unit;
        this.convertedDistanceUnit = this.distanceUnit.equals("mi") ? "km" : "mi";
        this.speedUnit = this.distanceUnit.equals("mi") ? "mph" : "kph";

    } // end of getDistUnit()
    
	
} // end DistanceCalculator class
