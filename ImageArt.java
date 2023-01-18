
public class ImageArt {

    static ImageTool imTool = new ImageTool ();

    public static void main (String[] argv)
    {
	// Instead of test.jpg, use your own image.
        int[][][] pixels = imTool.imageFileToPixels ("kitty.jpg");
        imTool.showImage (pixels, "original");

	int[][][] transPixels = transform1 (pixels);
        imTool.showImage (transPixels, "after transform-1");

	transPixels = transform2 (transPixels);
        imTool.showImage (transPixels, "after transform-2");
    }

    public static int[][][] transform1 (int[][][] pixels)
    {
	int[][][] transPixels = new int [pixels.length * 2][pixels[0].length][4];
	
	// Copy upper part
	int transRowInd = 0;
	for (int i=0; i < pixels.length; i++) {
	    for (int j=0; j < pixels[0]. length; j++) {
		transPixels[transRowInd][j][0] = pixels[i][j][0];
		transPixels[transRowInd][j][1] = pixels[i][j][1];
		transPixels[transRowInd][j][2] = pixels[i][j][2];
		transPixels[transRowInd][j][3] = pixels[i][j][3];
	    }
	    transRowInd++;
	}

	// Add horizontal reflection
	for (int i=pixels.length-1; i >= 0; i--) {
	    for (int j=0; j < pixels[0]. length; j++) {
		transPixels[transRowInd][j][0] = pixels[i][j][0];
		transPixels[transRowInd][j][1] = pixels[i][j][1];
		transPixels[transRowInd][j][2] = pixels[i][j][2];
		transPixels[transRowInd][j][3] = pixels[i][j][3];
	    }
	    transRowInd++;
	}

	return transPixels;
    }

    public static int[][][] transform2 (int[][][] pixels)
    {
	int[][][] transPixels = new int [pixels.length][pixels[0].length][4];
	for (int i=0; i < pixels.length/2; i++) {
	    for (int j=0; j < pixels[0]. length; j++) {
		transPixels[i][j][0] = pixels[i][j][0];
		transPixels[i][j][1] = pixels[i][j][1];
		transPixels[i][j][2] = pixels[i][j][2];
		transPixels[i][j][3] = pixels[i][j][3];
	    }
	}	

	double adjustment = 10.0;
	double contrast = 0.8;
	// Adjust reflection
	for (int i = pixels.length/2; i < pixels.length; i++) {
	    for (int j=0; j < pixels[0]. length; j++) {
		transPixels[i][j][0] = pixels[i][j][0] + 150;
		transPixels[i][j][1] = enforcePixelBounds (contrast * pixels[i][j][1] - adjustment);
		transPixels[i][j][2] = enforcePixelBounds ( contrast * pixels[i][j][2] - adjustment);
		transPixels[i][j][3] = enforcePixelBounds ( contrast * pixels[i][j][3] - adjustment);
	    }
	}	

	return transPixels;
    }

    static int enforcePixelBounds (double pixelValue)
    {
	int value = (int) pixelValue;
	if (value < 0) {
	    return 0;
	}
	if (value > 255) {
	    return 255;
	}
	return value;
    }

}
