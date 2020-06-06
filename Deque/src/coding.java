import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class coding {
        public static void main (String[] args){
            Deques decoder=new Deques(1000);
            int i=0;
            String Line="";
            try { FileReader reader = new FileReader("message.txt");
                BufferedReader scan=new BufferedReader(reader);
                while (scan.read()!= -1){
                decoder.addLast(String.valueOf((char)scan.read()));
                i=i+1;}
                reader.close();
                decoder.addLast(decoder.pollFirst());

                for (int j=0;j<i;j++){
                decoder.addLast(decoder.pollFirst());
                Line=Line+decoder.getFirst();                }


            }
            catch(IOException e){
                System.out.println("Error in reading");

            }
            System.out.println( Line);
        }



        }