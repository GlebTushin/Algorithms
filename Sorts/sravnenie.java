import java.util.Scanner;
import java.util.Arrays;

public class sravnenie {
    public static void main(String[] args) {
        Scanner Vvod = new Scanner(System.in);
        System.out.println("Введите размер массива" );
        int n=Vvod.nextInt();
        int[][] arrayt1=new int[n][n];
        int[][] arrayt2=new int[n][n];
        int[][] arrayt3=new int[n][n];
        for (int i=0;i<n;i++){
        for (int j=0;j<n;j++){
            arrayt1[i][j]=0+(int)(Math.random()*10);
            arrayt2[i][j]=arrayt1[i][j];
            arrayt3[i][j]=arrayt1[i][j];
        }}
        long start1=System.currentTimeMillis();
        qsort.qsort1(n,arrayt1);
        long finish1=System.currentTimeMillis();
        simplsort.Bublle(arrayt2,n);
        long finish2=System.currentTimeMillis();
        long finish3=System.currentTimeMillis();
        long time1=finish1-start1;
        long time2=finish2-finish1;

        System.out.println("Сортировка Хоара "+time1);
        for (int i = 0; i < arrayt1.length; i++) {
            for (int j=0;j<n;j++){
            System.out.print(arrayt1[i][j] + " ");}
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Сортировка обменами "+time2);
        for (int i = 0; i < arrayt2.length; i++) {
            for(int j=0;j<n;j++){
            System.out.print(arrayt2[i][j] + " ");}

        System.out.println("");}
    }
}
