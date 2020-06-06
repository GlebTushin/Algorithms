import java.util.ArrayList;
import java.util.Scanner;
public class SearchingArr {
    public static void main(String[] args){

    Scanner vvod= new Scanner(System.in);
    int num=vvod.nextInt();
        ArrayList<Integer> arrayt1=new ArrayList<>();
        for (int j=0;j<num;j++){
            arrayt1.add((int)(Math.random()*1000));
    }


        Sort.QSort(arrayt1,0,num-1);
        System.out.print(arrayt1);
        long start1=System.currentTimeMillis();
        int elem=vvod.nextInt();
        int i=0;
        for (int el:arrayt1
             ) { if (el==elem){
                 System.out.println(i);
             break;}
             i=i+1;
        }
        long finish1=System.currentTimeMillis();
       try {System.out.println( Search.SearhBinnary(arrayt1,0,num-1,elem));}
        catch (Exception e) {
           System.out.println("Элемент не найден");
       }
        long finish2=System.currentTimeMillis();
        long time1=finish1-start1;
        long time2=finish2-finish1;
        System.out.print(time1+" "+time2);
    }
}
