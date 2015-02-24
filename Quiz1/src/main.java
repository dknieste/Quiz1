/*
 * Author: Diana Knieste
 * Date: February 
 * Assignment: Quiz 1
 * Description: This is a small program that calculates 
 * the Passer Rating of a football player based on an 
 * equation used by the NFL.
 */

import java.util.Scanner;
import java.lang.Math;

/*
 * This is the main class. It asks the user a series of questions
 * related to a specific player's stats. It then passes those variables
 * through a method and returns the Passer Rating.
 */

public class main {
	public static void main(String[] args) {

		System.out.println("Welcome to the Passer Rating Program.");

		Scanner InputCompletions = new Scanner(System.in);
		System.out.println("Type the number of completions: ");
		double COMP = InputCompletions.nextDouble();

		Scanner InputAttemps = new Scanner(System.in);
		System.out.println("Type the number of passing attempts: ");
		double ATT = InputAttemps.nextDouble();

		Scanner InputYards = new Scanner(System.in);
		System.out.println("Type the number of passing yards: ");
		double YDS = InputYards.nextDouble();

		Scanner InputTDs = new Scanner(System.in);
		System.out.println("Type the number of touchdown passes: ");
		double TD = InputTDs.nextDouble();

		Scanner InputInterceptions = new Scanner(System.in);
		System.out.println("Type the number of interceptions: ");
		double INT = InputInterceptions.nextDouble();

		double PasserRating = CalcPasserRating(COMP, ATT, YDS, TD, INT);

		System.out
				.printf("The player's Passer Rating is: %.1f%n", PasserRating);
	}

	/*
	 * This is a method which computes the Passer Rating according to the
	 * equation found here: http://en.wikipedia.org/wiki/Passer_rating The
	 * variables a, b, c, d are used to break up the equation into smaller
	 * steps.
	 */
	protected static double CalcPasserRating(double COMP, double ATT,
			double YDS, double TD, double INT) {

		double a = ((COMP / ATT) - 0.3) * 5;
		double mma = Math.max(0.0, (Math.min(a, 2.375)));

		double b = ((YDS / ATT) - 3) * 0.25;
		double mmb = Math.max(0.0, (Math.min(b, 2.375)));

		double c = (TD / ATT) * 20;
		double mmc = Math.max(0.0, (Math.min(c, 2.375)));

		double d = (0.095 - (INT / ATT)) * 25;
		double mmd = Math.max(0.0, (Math.min(d, 2.375)));

		double PasserRating = ((mma + mmb + mmc + mmd) / 6) * 100;
		return PasserRating;
	}
}
