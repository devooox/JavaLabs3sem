class CutString{
    public static String cutNums(String str){
        StringBuilder editString = new StringBuilder(str);
        int i = 0;
        while(i < editString.length()) {
            if (editString.charAt(i) == '.') {
                if ((i+2)<editString.length() && Character.isDigit(editString.charAt(i+1)) && Character.isDigit(editString.charAt(i+2))){
                    i += 3;
                    while ((i < editString.length()) && (Character.isDigit(editString.charAt(i)))) {
                        editString.deleteCharAt(i);
                    }
                    --i;
                }
            }
            ++i;
        }
        return editString.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new MyException("You need to enter one string");
            }
            System.out.println(args[0]);
            String result = CutString.cutNums(args[0]);
            System.out.println(result);
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}