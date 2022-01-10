import java.util.Set;
import java.util.HashSet;

/**
   This SetUtil class tests various usages of the Set class. 
   param1 is a string. You will create a set with all vowels, a,e,i,o,u. Then you will return 
   string with all vowels removed. Vowels may be lower or upper case.
*/
public class SetUtil
{

 public static String check(String str)
 {
      HashSet<Character> stack = new HashSet<Character>();
      stack.add('a');
      stack.add('e');
      stack.add('i');
      stack.add('o');
      stack.add('u');
      stack.add('y');
	  return processSet(stack, str);
 }


 public static String processSet(Set<Character> set, String str)
 {
     StringBuffer sb = new StringBuffer();

	 for (int i = 0; i < str.length(); i++)
     {
      if (!set.contains(str.charAt(i))) {
         sb.append(str.charAt(i));
      }
	 }
     
     return sb.toString();
 }
}
