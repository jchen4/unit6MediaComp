/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testArms()
  {
      Picture snowman = new Picture("snowman.jpg");
      snowman.mirrorArms();
      snowman.explore();
      
  }
  
  public static void testKeepBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepBlue();
    beach.explore();
  }
  
  public static void testGray()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.gray();
    beach.explore();
  }
  
  public static void testFish()
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.fish();
    beach.explore();
  }
  
  public static void testCrop()
  {
    Picture beach = new Picture("beach.jpg");
    Picture snowman = new Picture("snowman.jpg");
    beach.copy2(snowman, 10, 200, 10, 200 ,100, 100);
    beach.explore();
  }
  
  public static void testScale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.scale().explore();
  }
  
  public static void testCollage2()
  {
    Picture shrek = new Picture(464, 434);
    shrek.createCollage2();
    shrek.explore();
    
  }
  
  public static void rotate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.rotate(beach).explore();
   
  }
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepBlue();
    testCollage2();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}