package utils;

public class Validator {
    public static boolean isValid(double x, double y, double r){
        return (x >= -5 && x <= 1 && y > -3 && y < 3 && r > 2 && r < 5 && r % 0.25 == 0.);
    }
}
