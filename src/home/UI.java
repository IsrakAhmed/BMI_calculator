package home;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame mainFrame;
    JPanel mainPanel;
    JLabel header,header2,age;
    JTextField ageT;
    UI(){
        mainFrame = new JFrame("BMI Calculator");
        mainFrame();
    }
    void mainFrame(){
        mainFrame.setSize(500,720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setSize(500,720);
        mainPanel.setBackground(Color.cyan);

        header = new JLabel("Body Mass Index");
        header.setBounds(145,50,200,60);
        header.setFont(new Font("Serif", Font.BOLD, 20));

        header2 = new JLabel("Calculator");
        header2.setBounds(200,80,200,60);
        header2.setFont(new Font("Serif", Font.BOLD, 15));

        age = new JLabel("Age");
        age.setBounds(200,80,200,60);
        age.setFont(new Font("Serif", Font.BOLD, 15));

        mainFrame.add(header); mainFrame.add(header2);
        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
