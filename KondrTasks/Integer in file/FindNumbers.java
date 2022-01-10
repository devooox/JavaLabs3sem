import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
     
public class FindNumbers
{
   /**
      This class reads a file and returns an array list of all numbers in the file. 
      Only numbers following the Java number convention are matched. For example,
      14.9 is recognized but 200,000 results in two numbers 200 and 0.
      @param filename the file name
      @return a list of numbers
   */
   public static ArrayList<Integer> read(String filename) throws IOException
   {
      ArrayList<Integer> result = new ArrayList<Integer>();
      Scanner scanner = new Scanner(new File(filename));
      scanner.useDelimiter("[^0-9]+");
      while(scanner.hasNext()){
         result.add(Integer.parseInt(scanner.next()));
      }
      return result;
   }
}
