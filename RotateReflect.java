public class RotateReflect {

    static ImageTool imTool = new ImageTool ();

    public static void main (String[] argv)
    {
        int[][][] pixels = imTool.imageFileToPixels ("device.jpg");
        imTool.showImage (pixels, "original");


        int[][][] rotatedPixels = rotateRight (pixels);
        imTool.showImage (rotatedPixels, "rotated-once");

        rotatedPixels = rotateRight (rotatedPixels);
        imTool.showImage (rotatedPixels, "rotated-twice");

        int[][][] reflectedPixels = reflect (pixels);
        imTool.showImage (reflectedPixels, "reflected");
    }
    
    public static int[][][] rotateRight (int[][][] pixels)
    {
        int[][][] rotatedPixels = new int [pixels[0].length][pixels.length][4];
        for (int pixRow=0; pixRow < pixels.length; pixRow++) {
            for (int pixCol = 0; pixCol < pixels[0].length; pixCol++) {
                for (int value = 0; value < 4; value++) {
                    rotatedPixels[pixCol][pixels.length-1-pixRow][value] = pixels[pixRow][pixCol][value];
                }
            }
        }

        return rotatedPixels;
    }

    public static int[][][] reflect (int[][][] pixels)
    {
        int[][][] verticalReflection = new int [pixels.length][pixels[0].length][4];
        for (int pixRow=0; pixRow < pixels.length; pixRow++) {
            for (int pixCol = 0; pixCol < pixels[0].length; pixCol++) {
                for (int value = 0; value < 4; value++) {
                    verticalReflection[pixRow][pixels[0].length-1-pixCol][value] = pixels[pixRow][pixCol][value];
                }
            }
        }

        int[][][] diagonalReflection = rotateRight(verticalReflection);
        diagonalReflection = rotateRight(diagonalReflection);
        diagonalReflection = rotateRight(diagonalReflection);

        return diagonalReflection;
    }

}
