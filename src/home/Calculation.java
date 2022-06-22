package home;

import java.awt.*;

public class Calculation {

    private int age;
    private double height;
    private double weight;
    private double bmi = 0;
    private double leastWeight = 0;
    private double minLoose = 0;
    private double minGain = 0;
    private String suggestion = null;
    public Color color;

    Calculation(int age,double height,double weight){
        this.age = age;
        this.height = height * height;
        this.weight = weight;
    }

    public double calculate(){
        bmi = weight / height;
        return bmi;
    }

    public String getComment(){
        String comment = null;

        if(bmi <= 18.4){
            comment = "Underweight";
            color = new Color(255, 55, 55);
            leastWeight = height * 18.5;
            minGain = leastWeight - weight;
            minLoose = -1;
        }

        else if(bmi >= 18.5 && bmi <= 24.9){
            comment = "Normal";
            color = new Color(0, 120, 8);
            leastWeight = 0;
            minGain = 0;
            minLoose = 0;
        }

        else if(bmi >= 25.0 && bmi <= 29.9){
            comment = "Overweight";
            color = new Color(235, 242, 0);
            leastWeight = height * 24.9;
            minGain = -1;
            minLoose = weight - leastWeight;
        }

        else if(bmi >= 30.0 && bmi <= 34.9){
            comment = "Obesity Level 1";
            color = new Color(242, 0, 0);
            leastWeight = height * 24.9;
            minGain = -1;
            minLoose = weight - leastWeight;
        }

        else if(bmi >= 35.0 && bmi <= 39.9){
            comment = "Obesity Level 2";
            color = new Color(147, 0, 0);
            leastWeight = height * 24.9;
            minGain = -1;
            minLoose = weight - leastWeight;
        }

        else if(bmi >= 40.0){
            comment = "Extreme Obesity";
            color = new Color(89, 0, 0);
            leastWeight = height * 24.9;
            minGain = -1;
            minLoose = weight - leastWeight;
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

    public double getLeastWeight(){
        return leastWeight;
    }

    public String getSuggestion(){
        if(minLoose == -1){
            suggestion = "You have to gain at least " + minGain + "kg";
        }
        else if(minGain == -1){
            suggestion = "You have to loose at least " + minLoose + "kg";
        }
        else{
            suggestion = "Your weight and height is perfectly balanced";
        }

        return suggestion;
    }
}
