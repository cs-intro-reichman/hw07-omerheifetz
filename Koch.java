/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        return;
    }
    	double x2_new = x1 + (x2 - x1) / 3.0;
    	double y2_new = y1 + (y2 - y1) / 3.0;
    	double x4_new = x1 + 2 * (x2 - x1) / 3.0;
    	double y4_new = y1 + 2 * (y2 - y1) / 3.0;
    	double x3_new = (x1 + x2) / 2.0 + Math.sqrt(3) * (y1 - y2) / 6.0;
    	double y3_new = (y1 + y2) / 2.0 + Math.sqrt(3) * (x2 - x1) / 6.0;
    	curve(n - 1, x1, y1, x2_new, y2_new);
    	curve(n - 1, x2_new, y2_new, x3_new, y3_new);
    	curve(n - 1, x3_new, y3_new, x4_new, y4_new);
    	curve(n - 1, x4_new, y4_new, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		double x1 = 0.2, y1 = 0.65;
    	double x2 = 0.8, y2 = 0.65;
    	double x3 = 0.5, y3 = 0.13;
		curve(n, x1, y1, x2, y2);
   		curve(n, x2, y2, x3, y3);
    	curve(n, x3, y3, x1, y1);
	}
}
