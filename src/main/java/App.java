import javax.swing.*;
import java.awt.*;

class App{
    public static void main(String[] args){
        menu();
    }
    private static void menu(){
        JFrame frame = new JFrame();
        frame.setTitle("Score Board Home");
        frame.setSize(1200,750);

        JButton allTime,refAllTime,scAllTime,topMonth,refMonth,scMonth,
                topWeek,refWeek,scWeek,topDay,refDay,scDay,blank;

        allTime = new JButton("All Time Top");
        refAllTime = new JButton("All Time Top Ref");
        scAllTime = new JButton("All Time Top Scorekeeper");
        topMonth = new JButton("Top of the Month");
        refMonth = new JButton("Top Ref of the Month");
        scMonth = new JButton("Top Scorekeeper of the Month");
        topWeek = new JButton("Top of the Week");
        refWeek = new JButton("Top Ref of the Week");
        scWeek = new JButton("Top Scorekeeper of the Week");
        topDay = new JButton("Top of the Day");
        refDay = new JButton("Top Ref of the Day");
        scDay = new JButton("Top Scorekeeper of the Day");
        blank = new JButton();

        allTime.setBounds(50,25,200,50);
        frame.add(allTime);
        refAllTime.setBounds(500,25,200,50);
        frame.add(refAllTime);
        scAllTime.setBounds(950,25,200,50);
        frame.add(scAllTime);
        topMonth.setBounds(50,231,200,50);
        frame.add(topMonth);
        topWeek.setBounds(50,448,200,50);
        frame.add(topWeek);
        topDay.setBounds(50,650,200,50);
        frame.add(topDay);

        frame.add(blank);



        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
}