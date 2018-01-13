import java.text.NumberFormat;
import java.util.Scanner;

public class BattingStatisticsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Batting Average Calculator\n");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		number.setMaximumFractionDigits(3);
		
		while (choice.equalsIgnoreCase("y")) {
			int timesAtBat = ConsoleBatStats.getInt("Enter number times at bat (1-30): ", 1, 30);		
			System.out.println();
			System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run\n");
			
			int[] results = new int[timesAtBat];
			int hitsTotal = 0;
			int basesTotal = 0;
			
			for (int i = 0; i < timesAtBat; i++) {
				results[i] = ConsoleBatStats.getInt("Result for at bat " + (i+1) + ": ", 0, 4);
				basesTotal += results[i];
					if (results[i] >0) {
						hitsTotal++;
					}
			}
		
			double battingAvg = (double) hitsTotal/timesAtBat;
			double sluggingPct = (double) basesTotal/timesAtBat;
//			System.out.println("basesTotal " + basesTotal);  //used for TESTING
//			System.out.println("hitsTotal " + hitsTotal);    //used for TESTING
			

			System.out.println("");
			
			System.out.println("Batting average: " + number.format(battingAvg));
			System.out.println("Slugging percent: " + number.format(sluggingPct) + "\n");
 		
			System.out.print("Another player?(y/n): ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("bye");
		sc.close();
	}
	

}
