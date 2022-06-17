package home;

import java.awt.*;

public class Calculation {

    private int age;
    private double height;
    private double weight;
    private double bmi = 0;
    public Color color;

    Calculation(int age,double height,double weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public double calculate(){
        bmi = weight / (height * height);
        return bmi;
    }

    public String getComment(){
        String comment = null;

        if(bmi <= 18.4){
            comment = "Underweight";
            color = new Color(255, 55, 55);
        }

        else if(bmi >= 18.5 && bmi <= 24.9){
            comment = "Normal";
            color = new Color(0, 120, 8);
        }

        else if(bmi >= 25.0 && bmi <= 29.9){
            comment = "Overweight";
            color = new Color(235, 242, 0);
        }

        else if(bmi >= 30.0 && bmi <= 34.9){
            comment = "Obesity Level 1";
            color = new Color(242, 0, 0);
        }

        else if(bmi >= 35.0 && bmi <= 39.9){
            comment = "Obesity Level 2";
            color = new Color(147, 0, 0);
        }

        else if(bmi >= 40.0){
            comment = "Extreme Obesity";
            color = new Color(89, 0, 0);
        }

        else{
            comment = "No Comments";
            color = new Color(255, 229, 229);
        }

        return comment;
    }

    public Color getColorName(){
        return color;
    }
}
