public class Arithmetic
{
   /**
      Checks whether an arithmetic expression is valid.
      @param value1 a string that should contain an integer
      @param operator a string that should contan an operator + - * or /
      @param value2 a string that should contain an integer
      @return true if all parameters are correct and the resulting expression
      can be evaluated without an exception      
   */
   public static boolean check(String value1, String operator, String value2)
   {
      int num2;
      try{
         Integer.parseInt(value1);
         num2 = Integer.parseInt(value2);
      } catch (NumberFormatException e){
         return false;
      }
      if (operator == "+" || operator == "-" || operator == "*") {
         return true;
      } else {
         if (operator == "/") {
            if (num2 == 0) {
               return false;
            } else {
               return true;
            }
         }else  {
            return false;
         }
      }
   }
}
