package home;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UI {

    JFrame mainFrame;
    JPanel mainPanel,unitsPanel;
    JLabel header,header2,age,gender,height,ft,inch_l,weight,pound_l;
    JTextField ageT,feet,inch,pounds;
    JRadioButton genMale,genFemale;
    ButtonGroup bg;

    JButton usUnits,metricUnits,clear;
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
        age.setBounds(170,140,200,60);
        age.setFont(new Font("Serif", Font.BOLD, 17));

        ageT = new JTextField();
        ageT.setBounds(210,160,70,25);

        gender = new JLabel("Gender");
        gender.setBounds(100,190,200,60);
        gender.setFont(new Font("Serif", Font.BOLD, 17));

        genMale = new JRadioButton("Male");
        genMale.setBounds(190,208,80,25);
        genMale.setFont(new Font("Serif", Font.BOLD, 15));
        genMale.setBackground(Color.cyan);


        genFemale = new JRadioButton("Female");
        genFemale.setBounds(267,208,100,25);
        genFemale.setFont(new Font("Serif", Font.BOLD, 15));
        genFemale.setBackground(Color.cyan);

        bg = new ButtonGroup();
        bg.add(genMale); bg.add(genFemale);

        unitsPanel = new JPanel();
        unitsPanel.setBounds(100,270,300,300);
        unitsPanel.setBackground(Color.white);

        usUnits = new JButton("US Units");
        usUnits.setBounds(100,270,150,35);
        usUnits.setBackground(Color.white);
        usUnits.setForeground(Color.black);
        usUnits.addActionListener(this::clicked_UsUnits);

        metricUnits = new JButton("Metric Units");
        metricUnits.setBounds(250,270,150,35);
        metricUnits.setBackground(Color.darkGray);
        metricUnits.setForeground(Color.white);
        metricUnits.addActionListener(this::clicked_MetricUnits);

        height = new JLabel("Height");
        height.setBounds(120,320,200,60);
        height.setFont(new Font("Serif", Font.BOLD, 14));

        ft = new JLabel("ft");
        ft.setBounds(270,320,200,60);
        ft.setFont(new Font("Serif", Font.PLAIN, 12));
        feet = new JTextField();
        feet.setBounds(180,338,90,25);


        inch_l = new JLabel("in");
        inch_l.setBounds(375,320,200,60);
        inch_l.setFont(new Font("Serif", Font.PLAIN, 12));
        inch = new JTextField();
        inch.setBounds(285,338,90,25);


        weight = new JLabel("Weight");
        weight.setBounds(120,390,200,60);
        weight.setFont(new Font("Serif", Font.BOLD, 14));

        pounds = new JTextField();
        pounds.setBounds(180,410,190,25);
        pound_l = new JLabel("lb");
        pound_l.setBounds(375,390,200,60);
        pound_l.setFont(new Font("Serif", Font.PLAIN, 12));



        mainFrame.add(header); mainFrame.add(header2);
        mainFrame.add(age); mainFrame.add(ageT);
        mainFrame.add(gender);mainFrame.add(genMale);
        mainFrame.add(genFemale); mainFrame.add(usUnits);
        mainFrame.add(metricUnits); mainFrame.add(height);
        mainFrame.add(ft); mainFrame.add(inch_l);
        mainFrame.add(feet); mainFrame.add(inch);
        mainFrame.add(weight); mainFrame.add(pounds);
        mainFrame.add(pound_l);



        mainFrame.add(unitsPanel);
        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void clicked_UsUnits(ActionEvent e){
        usUnits.setBackground(Color.white);
        usUnits.setForeground(Color.black);
        metricUnits.setBackground(Color.darkGray);
        metricUnits.setForeground(Color.white);

    }

    void clicked_MetricUnits(ActionEvent e){
        usUnits.setBackground(Color.darkGray);
        usUnits.setForeground(Color.white);
        metricUnits.setBackground(Color.white);
        metricUnits.setForeground(Color.black);
    }

}
