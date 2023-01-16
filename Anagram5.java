// Unit 3, Assignment 1

public class Anagram5 {

    public static void main (String[] argv)
    {
	String s = "conversation";
	String s2 = "conservation";
	boolean yes = areAnagrams (s.toCharArray(), s2.toCharArray());
	System.out.println ("Are " + s + " and " + s2 + " anagrams? " + yes);

	s = "slop";
	s2 = "sloop";
	yes = areAnagrams (s.toCharArray(), s2.toCharArray());
	System.out.println ("Are " + s + " and " + s2 + " anagrams? " + yes);

	s = "sloop";
	s2 = "polls";
	yes = areAnagrams (s.toCharArray(), s2.toCharArray());
	System.out.println ("Are " + s + " and " + s2 + " anagrams? " + yes);

	s = "sloop";
	s2 = "pools";
	yes = areAnagrams (s.toCharArray(), s2.toCharArray());
	System.out.println ("Are " + s + " and " + s2 + " anagrams? " + yes);

    }

    static boolean areAnagrams (char[] A, char[] B)
    {

	if (A.length != B.length) {
	    return false;
	}

	char[] C = new char [B.length];
	for (int i=0; i<B.length; i++) {
	    C[i] = B[i];
	}

	// Get each char from A
	for (int i=0; i < A.length; i++) {

	    boolean found = false;

	    for (int j=0; j < C.length; j++) {
		// Set found to true and break out of the inner loop 
		// if an equivalent is found.
		if (A[i] == C[j]) {
		    found = true;
		    C[j] = '#';
		    break;
		}
	    }
	    
	    if (found == false) {
		return false;
	    }
	}

	return true;
    }

}
