package home;

public class Calculation {

    private int age;
    private double height;
    private double weight;
    private double bmi = 0;

    Calculation(int age,double height,double weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public double calculate(){
        return bmi;
    }
}
