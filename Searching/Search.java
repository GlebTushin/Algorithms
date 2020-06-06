
import java.util.ArrayList;

public class Search {
    public static int SearhBinnary(ArrayList<Integer> array, int a, int b, int s) throws Exception {
        while (b > a + 1){
            int c = a + (b - a)/2;
            if(array.get(c) > s){
                b = c;
            }
            else if(array.get(c) < s){
                a = c;
            }
            else{
                return c;
            }
        }
        throw new Exception("Элемент не найден.");

    }
}