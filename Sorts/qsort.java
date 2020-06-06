import java.util.Arrays;
public class qsort { public static void qsort1(int n,int[][] array ){
    for (int k=0;k<n;k++){
        quickSort(array,0,n-1,k);
    }

}
    public static void quickSort(int[][] array, int low, int high,int k) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
            int middle = low + (high - low) / 2;
            double opora = array[k][middle];
            int i = low, j = high;
            while (i <= j) {
                while (array[k][i] < opora)
                    i++;
                while (array[k][j] > opora)
                    j--;
                if (i <= j) {
                    int temp = array[k][i];
                    array[k][i] = array[k][j];
                    array[k][j] = temp;
                    i++;
                    j--;
                }
            }
            if (low < j)
                quickSort(array, low, j,k);
            if (high > i)
                quickSort(array, i, high,k);

        }
    }





