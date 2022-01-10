import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Arithmetic
{
   /**
      This class reads a file containing arithmetic expressions and returns an 
      array list of the results. 
      @param filename the file name
      @return a list of results
   */
   public static ArrayList<Integer> read(String filename) throws IOException
   {
      ArrayList<Integer> result = new ArrayList<Integer>();
      Scanner scanner = new Scanner(new File(filename));
      while (scanner.hasNextInt()) {
         int tmp1 = scanner.nextInt();
         char sign = scanner.next().charAt(0);
         int tmp2;
         try {
            tmp2 = Integer.parseInt(scanner.next());
         } catch (NumberFormatException e) {
            throw new IOException();
         }
         switch(sign) {
            case '+':
               result.add(tmp1+tmp2);
               break;
            case '-':
               result.add(tmp1-tmp2);
               break;
            case '*':
               result.add(tmp1*tmp2);
               break;
            default:
               throw new IOException();
         }
      }
      return result;
   }
   
   // This method checks your work.
   
   public static String check(String filename)
   {
      try
      {
         return read(filename).toString();
      }
      catch (IOException ex)
      {
         return "I/O exception thrown";
      }
      catch (Exception ex)
      {
         return ex.getMessage();
      }
   }
}   
