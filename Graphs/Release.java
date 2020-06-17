
   import javax.swing.*;
import java.awt.*;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
   import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

    public class Release extends JFrame {
        public static final int INF = 999999999;
        ArrayList<Point> point;
        ArrayList<Integer> grafPath= new ArrayList<Integer>();
        long elapsedTime;
        int minPath;
        int size;
        int n;
        int[][] oldD;



        Release(int size, String path) throws IOException {
            intil(path);
            long start = System.currentTimeMillis();
           JTextField text = new JTextField(16);
           JLabel label=new JLabel();
           JButton button=new JButton("Найти путь");
           button.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String s[]=text.getText().split(",");
                   BellmanFord bell=new BellmanFord(n);
                   bell.BellmanFordEvaluation(Integer.parseInt(s[0]),oldD);
                   label.setText(String.valueOf(bell.getDistances()[Integer.parseInt(s[1])]));

               }
           });
           JPanel pane =new JPanel();
           pane.setSize(300,300);
           pane.add(button,BorderLayout.NORTH);
           pane.add(text,BorderLayout.SOUTH);
           pane.add(label);
           pane.setVisible(true);
           this.add(pane);
            long end = System.currentTimeMillis();
            elapsedTime = end - start;
            this.size = size;
            setTitle("johnson");
            setSize(size,size);

            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }


        @Override
        public void paint(Graphics g) {
            int R = size / 2 - size / 5; //радиус
            int X = size / 2, Y = size / 2;//координаты центра
            point = new ArrayList<Point>();
            g.setFont(new Font("TimesRoman", Font.PLAIN, 18));

            double angle = 360.0 / n;
            for (int i = 0; i < n; i++) {
                int x = (int) (X + R * Math.cos(Math.toRadians(angle * i)));
                int y = (int) (Y + R * Math.sin(Math.toRadians(angle * i)));
                point.add(new Point(x, y));
            }

            for (int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    if(i != j && oldD[i][j] != INF) {
                        int x1 = point.get(i).x;
                        int y1 = point.get(i).y;
                        int x2 = point.get(j).x;
                        int y2 = point.get(j).y;
                        g.setColor(Color.BLACK);
                        g.drawLine(x1, y1, x2, y2);
                        g.setColor(Color.RED);
                        g.drawString(String.valueOf(oldD[i][j]), (x1 + x2) / 2, (y1 + y2) / 2);
                    }
                }
            }




            int l = 0;
            for (Point p : point) {
                g.setColor(Color.WHITE);
                g.fillOval(p.x - 25, p.y - 25, 50, 50);
                g.setColor(Color.BLACK);
                g.drawOval(p.x - 25, p.y - 25, 50, 50);
                g.setColor(Color.RED);
                g.drawString(String.valueOf(l), p.x - 5, p.y + 5);
                l++;
            }
        }
        private void intil(String string) throws IOException {
            Path path = Paths.get(string);
            List<String> contents = Files.readAllLines(path);
            n = contents.size();

            oldD = new int[n][n];

            for(int i = 0; i < n; i++){
                String[] row = contents.get(i).split(" ");
                for(int j = 0; j < n; j++){
                    if (i == j){
                        oldD[i][j] = 0;
                    }
                    else{
                        oldD[i][j] = Integer.parseInt(row[j]);
                    }
                }
            }
        }



    }