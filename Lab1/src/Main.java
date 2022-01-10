
public class Main {

    public static double sum(double x, double eps) {

        double current =  (x * x) * Math.pow((double) 4/3, 6) / 6;
        double result =  current;
        System.out.println(1 + " " + current + " " + result);

        int k = 2;
        while (true) {
            current *= (-1) * Math.pow( 4 , 4) / ((2 * k ) * (2 * k + 1) * Math.pow(3, 4));
            if (Math.abs(current) < eps) {
                break;
            }
            result += current;
            System.out.println(k + " " + current + " " + result);
            ++k;
        }
        return result;
    }


    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new MyException("Wrong amount of elements (need 2)");
            }
            double x = Double.parseDouble(args[0]);
            double eps = Double.parseDouble(args[1]);
            System.out.println("Summation = " + sum(x, eps));
        } catch (NumberFormatException e) {
            System.out.println("Convertation error");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}