
import java.util.*;

public class PangramMissing {

    public static void main (String[] argv)
    {
	String[] testSet1 = {"the", "lazy", "dog", "jumps", "on", "the", "fox"};
	char[] missing = pangramCheck (testSet1);
	System.out.println (Arrays.toString(missing));

	String[] testSet2 = {"black", "quartz", "sphinx", "takes", "vow"};
	missing = pangramCheck (testSet2);
	System.out.println (Arrays.toString(missing));

	String[] testSet3 = {"two", "driven", "jocks", "help", "fax", "my", "big", "quiz"};
	missing = pangramCheck (testSet3);
	System.out.println (Arrays.toString(missing));
    }
    
    public static char[] pangramCheck (String[] words)
    {
	String str = "";
	for (String w: words) {
	    str += w;
	}
	
	int numMissing = 26;
	for (int i=(int) 'a'; i<=(int) 'z'; i++) {
	    for (int j=0; j<str.length(); j++) {
		int ltr = (int) str.charAt(j);
		if (i == ltr) {
		    // System.out.println (((char) i) + " found in " + str); 
		    numMissing--;
		    // System.out.println ("Current numMissing=" + numMissing);
		    break;
		}
	    }
	}

	char[] missing = new char [numMissing];
	int missingInd = 0;
	for (int i=(int) 'a'; i<=(int) 'z'; i++) {

	    boolean absent = true;
	    for (int j=0; j<str.length(); j++) {
		int ltr = (int) str.charAt(j);
		if (i == ltr) {
		    absent = false;
		    break;
		}
	    }

	    if (absent) {
		missing[missingInd++] = (char) i;
	    }

	}
	
	return missing;
    }

}
