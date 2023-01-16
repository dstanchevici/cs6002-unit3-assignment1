// Unit 3, Assignment 1

public class Anagram3 {

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

	// Get each char from A
	for (int i=0; i < A.length; i++) {
	    // Declare a boolean flag to signal if 
	    // this char from A has an equivalent in B.
	    boolean found = false;
	    // Compare the current char from A against each char in B
	    for (int j=0; j < B.length; j++) {
		// Set found to true and break out of the inner loop 
		// if an equivalent is found.
		if (A[i] == B[j]) {
		    found = true;
		    B[j] = '#';
		}
	    }
	    
	    // If the current char from A has an equivalent in B, 
	    //  continue to the next char in A. Else, return false.
	    if (found == false) {
		return false;
	    }
	}
	// If end of loop is reached w/o returning false,
	//  it means all chars from A have doubles in B; return true.
	return true;
    }

}
