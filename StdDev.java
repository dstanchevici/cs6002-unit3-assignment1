import java.util.*;

public class StdDev {

    static double mean, stdDev;

    public static void main (String[] argv)
    {
	double[] x = {600, 200, 300, 100};
	double[] y = trimmed (x);
	System.out.println ("Mean=" + mean + " StdDev=" + stdDev + " Trimmed data: " + Arrays.toString(y));
	// Should print: mean=300, stdDev=187.082, same data

	double[] x2 = {600, 590, 601, 598, 614, 603, 613, 604, 602, 599, 601, 598, 602, 599, 602};
	double[] y2 = trimmed (x2);
	System.out.println ("Mean=" + mean + " Std-dev=" + stdDev + " Trimmed data: " + Arrays.toString(y2));
	// Should print: mean=601.733, stdDev=5.591, removes 590, 614, 613
    }

    public static double[] trimmed (double[] values)
    {
        // Set mean and stdDev to 0
        mean = 0.0;
        stdDev = 0.0;

        // Find mean and std for the passed range of values
        for (double value: values) {
            mean += value/values.length;
            stdDev += (value * value) / values.length;
        }
        stdDev = Math.sqrt(stdDev - mean * mean);

        // Remove outliers by two stds
        int nTrimmed = 0;
        for (double value: values) {
            if (value >= mean - stdDev * 2 && value <= mean + stdDev * 2) {
                nTrimmed ++;
            }
        }

        double[] trimmed = new double [nTrimmed];
        int trimmedInd = 0;
        for (double value: values) {
            if (value >= mean - stdDev * 2 && value <= mean + stdDev * 2) {
                trimmed[trimmedInd++] = value;
            }
        }

        return trimmed;
    }

}
