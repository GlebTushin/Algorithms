import java.util.Arrays;
public class simplsort {
    public static void Bublle(int[][] array,int n){
        for (int k=0;k<n;k++) {
            for (int i = 0; i < (n); i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (array[k][j] > array[k][j + 1]) {
                        int temp = array[k][j];
                        array[k][j] = array[k][j + 1];
                        array[k][j + 1] = temp;
                    }
                }
            }
        }
    }
}
