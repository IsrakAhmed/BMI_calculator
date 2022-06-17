package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class UI {

    JFrame mainFrame,resultFrame;
    JPanel mainPanel,unitsPanel;
    JLabel header,header2,age,gender,height,ft,inch_l,weight,pound_l,result;
    JTextField ageT,feet,inch,pounds,resultT;
    JRadioButton genMale,genFemale;
    ButtonGroup bg;
    JButton usUnits,metricUnits,calculate,clear,back,commentB;
    Color color;

    UI(){
        mainFrame = new JFrame("BMI Calculator");
        resultFrame = new JFrame("BMI Calculator");
        back = new JButton("Back");
        mainFrame();
    }

    boolean usState = true;
    boolean metricState = false;

    void mainFrame(){
        mainFrame.setSize(500,680);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setSize(500,680);
        mainPanel.setBackground(Color.cyan);

        header = new JLabel("Body Mass Index");
        header.setBounds(170,45,200,60);
        header.setFont(new Font("Serif", Font.BOLD, 20));

        header2 = new JLabel("Calculator");
        header2.setBounds(205,75,200,60);
        header2.setFont(new Font("Serif", Font.BOLD, 15));

        age = new JLabel("Age");
        age.setBounds(180,135,200,60);
        age.setFont(new Font("Serif", Font.BOLD, 17));

        ageT = new JTextField();
        ageT.setBounds(220,155,70,25);

        gender = new JLabel("Gender");
        gender.setBounds(115,185,200,60);
        gender.setFont(new Font("Serif", Font.BOLD, 17));

        genMale = new JRadioButton("Male");
        genMale.setBounds(205,203,80,25);
        genMale.setFont(new Font("Serif", Font.BOLD, 15));
        genMale.setBackground(Color.cyan);


        genFemale = new JRadioButton("Female");
        genFemale.setBounds(282,203,100,25);
        genFemale.setFont(new Font("Serif", Font.BOLD, 15));
        genFemale.setBackground(Color.cyan);

        bg = new ButtonGroup();
        bg.add(genMale); bg.add(genFemale);

        unitsPanel = new JPanel();
        unitsPanel.setBounds(90,265,300,210);
        unitsPanel.setBackground(Color.white);

        usUnits = new JButton("US Units");
        usUnits.setBounds(90,265,150,35);
        usUnits.setBackground(Color.white);
        usUnits.setForeground(Color.black);
        usUnits.addActionListener(this::clicked_UsUnits);

        metricUnits = new JButton("Metric Units");
        metricUnits.setBounds(240,265,150,35);
        metricUnits.setBackground(Color.darkGray);
        metricUnits.setForeground(Color.white);
        metricUnits.addActionListener(this::clicked_MetricUnits);

        height = new JLabel("Height");
        height.setBounds(110,315,200,60);
        height.setFont(new Font("Serif", Font.BOLD, 14));

        ft = new JLabel("ft");
        ft.setBounds(260,315,200,60);
        ft.setFont(new Font("Serif", Font.PLAIN, 12));
        feet = new JTextField();
        feet.setBounds(170,333,90,25);


        inch_l = new JLabel("in");
        inch_l.setBounds(365,315,200,60);
        inch_l.setFont(new Font("Serif", Font.PLAIN, 12));
        inch = new JTextField();
        inch.setBounds(270,333,90,25);


        weight = new JLabel("Weight");
        weight.setBounds(110,385,200,60);
        weight.setFont(new Font("Serif", Font.BOLD, 14));

        pounds = new JTextField();
        pounds.setBounds(170,405,190,25);
        pound_l = new JLabel("lb");
        pound_l.setBounds(365,385,200,60);
        pound_l.setFont(new Font("Serif", Font.PLAIN, 12));

        calculate = new JButton("Calculate");
        calculate.setBounds(158,505,150,35);
        calculate.setBackground(Color.darkGray);
        calculate.setForeground(Color.white);
        calculate.addActionListener(this::clicked_Calculate);


        clear = new JButton("Clear");
        clear.setBounds(158,555,150,35);
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.white);
        clear.addActionListener(this::clicked_Clear);



        mainFrame.add(header); mainFrame.add(header2);
        mainFrame.add(age); mainFrame.add(ageT);
        mainFrame.add(gender);mainFrame.add(genMale);
        mainFrame.add(genFemale); mainFrame.add(usUnits);
        mainFrame.add(metricUnits); mainFrame.add(height);
        mainFrame.add(ft); mainFrame.add(inch_l);
        mainFrame.add(feet); mainFrame.add(inch);
        mainFrame.add(weight); mainFrame.add(pounds);
        mainFrame.add(pound_l); mainFrame.add(calculate);
        mainFrame.add(clear);



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
        feet.setBounds(170,338,90,25);
        inch.setBounds(270,338,90,25);
        ft.setText("ft");
        inch_l.setText("in");
        pound_l.setText("lb");
        usState = true;
        metricState = false;

    }

    void clicked_MetricUnits(ActionEvent e){
        usUnits.setBackground(Color.darkGray);
        usUnits.setForeground(Color.white);
        metricUnits.setBackground(Color.white);
        metricUnits.setForeground(Color.black);
        feet.setBounds(170,338,190,25);
        inch.setBounds(0,0,0,0);
        ft.setText("");
        inch_l.setText("cm");
        pound_l.setText("kg");
        usState = false;
        metricState = true;
    }

    void clicked_Calculate(ActionEvent e){

        try{
            int ageM = parseInt(ageT.getText());
            double height1 = parseDouble(feet.getText());
            double weightM = parseDouble(pounds.getText());
            double heightM = 1;

            if(genMale.isSelected() || genFemale.isSelected()){
                if(usState){
                    double height2 = parseDouble(inch.getText());
                    heightM = (height1 * 12) + height2;
                    weightM = weightM * 703.0;
                }

                else if(metricState){
                    heightM = height1 / 100;
                }

                Calculation calculation = new Calculation(ageM,heightM,weightM);

                double bmi = calculation.calculate();
                String commentM = calculation.getComment();
                this.color = calculation.getColorName();

                resultFrame(bmi,commentM);
            }
            else{
                throw new RuntimeException("No gender");
            }

        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(mainFrame,"Invalid Form");
            exception.printStackTrace();
        }
    }

    void clicked_Clear(ActionEvent e){
        ageT.setText("");
        bg.clearSelection();
        feet.setText("");
        inch.setText("");
        pounds.setText("");
    }

    void resultFrame(double bmi,String commentM){

        resultFrame.setSize(500,680);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setLayout(null);

        result = new JLabel("BMI");
        result.setBounds(167,145,200,60);
        result.setFont(new Font("Serif", Font.BOLD, 20));

        DecimalFormat df = new DecimalFormat("#.##");

        resultT = new JTextField(""+df.format(bmi));
        resultT.setBounds(243,163,65,25);
        resultT.setFont(new Font("Serif", Font.BOLD, 20));
        resultT.setEditable(false);

        commentB = new JButton();
        commentB.setText(commentM);
        commentB.setBounds(162,250,150,35);
        commentB.setBackground(color);
        commentB.setRolloverEnabled(false);
        commentB.setBorderPainted(false);

        if((color.equals(new Color(235, 242, 0)))){
            commentB.setForeground(new Color(0, 0, 0));
        }
        else{
            commentB.setForeground(new Color(255, 255, 255));
        }

        back.setBounds(162,410,150,35);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.addActionListener(this::clicked_Back);

        resultFrame.add(back); resultFrame.add(commentB);
        resultFrame.add(result); resultFrame.add(resultT);

        resultFrame.add(mainPanel);

        resultFrame.setVisible(true);
        mainFrame.setVisible(false);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void clicked_Back(ActionEvent e){
        if(metricState){
            clicked_MetricUnits(e);
        }
        else if(usState){
            clicked_UsUnits(e);
        }

        mainFrame.add(mainPanel);
        resultFrame.remove(resultT);
        resultFrame.remove(commentB);
        resultFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

}
