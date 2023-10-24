import java.io.*;

public class DistanceCalculator {

	private double speed; // speed (mph)
	private double time;  // time (min)

	public DistanceCalculator() {
		this.speed = 0;
		this.time = 0;
	}
    
    public double getSpeed() { return this.speed; }
    public double getTime() { return this.time; }

	public void getUserInput() {
		this.speed = this.getNonnegDouble("Enter a speed (miles/hour): ");
		this.time = this.getNonnegDouble("Enter a time traveled (minutes): ");
	}

	public void printDistance() {
		System.out.format("The distance traveled is %.3f miles.\n", this.calcDist());
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
	
} // end DistanceCalculator class
