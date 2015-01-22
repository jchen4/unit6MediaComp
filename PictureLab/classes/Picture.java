import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 
     */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }
    
    /** Method to set all colors other than blue to 0 
     */
    public void keepBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }
    
    /** Method to make all pixels grayscale 
     */
    public void gray()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
                pixelObj.setRed(avg);
                pixelObj.setBlue(avg);
                pixelObj.setGreen(avg);
            }
        }
    }
    
    /** Method to triple red  
     */
    public void fish()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(pixelObj.getRed() * 3);
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int length = pixels.length;
        for (int row = 0; row < length; row++)
        {
            for (int col = 0; col < width/2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorHorrizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null; 
        int width = pixels[0].length;
        int length = pixels.length;
        for (int row = 0; row < length/2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                topPixel = pixels[row][col];
                botPixel = pixels[length - 1 - row][col];
                botPixel.setColor(topPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        int width = pixels[0].length;
        int length = pixels.length;
        int ctr = 0;
        if (width > length)
        {
            for (int row = 0; row < length; row++)
            {
                for (int col = 0; col < ctr; col++)
                {
                    topPixel = pixels[row][col];
                    botPixel = pixels[col][row];
                    botPixel.setColor(topPixel.getColor());
                }
                ctr ++;
            } 
        }
        else
        {
            for (int row = 0; row < width; row++)
            {
                for (int col = 0; col < ctr; col++)
                {
                    topPixel = pixels[row][col];
                    botPixel = pixels[col][row];
                    botPixel.setColor(topPixel.getColor());
                }
                ctr ++;
            } 
        }
    }
    
    /** Method to mirror snowman arms to 4 
     */
    public void mirrorArms()
    {
        int mirrorPoint = 193;
        Pixel topPixel = null;
        Pixel botPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 154; row < mirrorPoint; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 98; col < 304; col++)
            {
                topPixel = pixels[row][col];
                botPixel = pixels[mirrorPoint - 1 - row + mirrorPoint][col];
                botPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }
    
    /** creates collage from shrek pictures
     */
    public void createCollage2()
    {
        Pixel[][] shrexels = this.getPixels2D();
        
        int col = shrexels[0].length;
        int row = shrexels.length;
        
        Picture shrek1 = new Picture("shrek.jpg");
        Picture shrek2 = new Picture("shrek.jpg");
        Picture shrek3 = new Picture("shrek.jpg");
        Picture shrek4 = new Picture("shrek.jpg");
        
        this.copy2(shrek1, 0, row/2, 0, col/2, 0, 0);
        shrek2.gray();
        this.copy2(shrek2, 0, row/2, 0, col/2, 0, col/2);
        shrek3.sepia();
        this.copy2(shrek3, 0, row/2, 0, col/2, row/2, 0);
        shrek4.zeroBlue();
        shrek4.mirrorDiagonal();
        this.copy2(shrek4, 0, row/2, 0, col/2, row/2, col/2);
        
        this.write("H:\\GitHub//unit6MediaComp//PictureLab//images//shrekcollage.jpg");
        
        
    }
    
    /** Method to apply a sepia filter 
     */
    public void sepia()
    {
        this.gray();
        Pixel[][] pixel = this.getPixels2D();
        for (int row = 0; row < pixel.length; row++)
        {
            for (int col = 0; col < pixel[0].length; col++)
            {
                int red = pixel[row][col].getRed();
                int blue = pixel[row][col].getBlue();
                int green = pixel[row][col].getGreen();
                if (red < 60)
                {
                    pixel[row][col].setRed((int)(red*.9));
                    pixel[row][col].setBlue((int)(blue*.9));
                    pixel[row][col].setGreen((int)(green*.9));
                }
                else if (red < 190)
                {
                    pixel[row][col].setBlue((int)(blue*.8));
                }
                else
                {
                    pixel[row][col].setBlue((int)(blue*.8));
                }
            }
        }
        
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }
    
    
    public void copy2(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,
         int startDestRow, int startDestCol )
    {
        Pixel[][] pixels = new Pixel[endSourceRow-startSourceRow][endSourceCol-startSourceCol];
        Pixel[][] pixelsNew = this.getPixels2D();
        Pixel[][] pixelsNew2 = sourcePicture.getPixels2D();
        for (int row = startSourceRow; row < endSourceRow; row++)
        {
            for (int col = startSourceCol; col < endSourceCol; col++)
            {
                pixels[row - startSourceRow][col - startSourceCol] = pixelsNew2[row][col];
            }
        }
        
        
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixelsNew[row + startDestRow][col + startDestCol].setColor(pixels[row][col].getColor());
            }
        } 
        
    }
    
    public Picture scale()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] pixelsHalf = new Pixel[pixels.length/2][pixels[0].length/2];
        for (int row = 0; row < pixelsHalf.length; row++)
        {
            for (int col = 0; col < pixelsHalf[0].length; col++)
            {
                pixelsHalf[row][col] = pixels[row*2][col*2];
            }
        } 
        
        Picture pic = new Picture(pixels.length/2, pixels[0].length/2);
        Pixel[][] pixelsNew = pic.getPixels2D();
        for (int row = 0; row < pixelsHalf.length; row++)
        {
            for (int col = 0; col < pixelsHalf[0].length; col++)
            {
                pixelsNew[row][col].setColor(pixelsHalf[row][col].getColor());
            }
        } 
        return pic;
    }
    
    public Picture rotate(Picture pic)
    {
        Pixel[][] pixels = pic.getPixels2D();
        Picture newpic = new Picture(pixels.length, pixels[0].length);
        Pixel[][] pixels2 = newpic.getPixels2D();
        for (int row = 0; row < pixels.length; row++)        
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixels2[col][row] = pixels[row][col];
            }
        }
        return newpic;
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("snowman.jpg");
        beach.mirrorDiagonal();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
