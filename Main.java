package com.company;

import java.util.Scanner;


class Complex {
    private double x1 = 0;
    private double x2 = 0;
    private double i1 = 0;
    private double i2 = 0;
    private static Complex complex = new Complex();


    public String complexSum() {
        double first = x1 + x2;
        double second = i1 + i2;
        if (second == 0) {
            return first + " + " + "i";
        }
        else if(first == 0){
            return second + "i";
        }
        else{
            return first + " + " + second + "i";
        }
    }

    public String complexSub() {
        double first = x1 - x2;
        double second = i1 - i2;
        if(second > 0){
            return first + " + " + "i";
        }
        if(second < 0){
            return first + " - " + second * -1 + "i";
        }
        if (second == 0 | x2 == 0) {
            return first + " - " + "i";
        }
        else if(first == 0){
            return second + "i";
        }
        else{
            return first + " - " + second + "i";
        }
    }


    public String complexMulti(){
        double first = x1 * x2 - i1 * i2;
        double second = i1 * x2 + x1 * i2;
        if(second == 1){
            return first + " + "+ "i";
        }
        else{
            return first + " + " + second + "i";
        }
    }

    public String complexDiv(){
        double first = ((x1 * x2 + i1 * i2)) / (Math.pow(x2, 2) + Math.pow(i2, 2));
        double second = ((i1 * x2 - x1 * i2)) / (Math.pow(x2, 2) + Math.pow(i2, 2));
        return first + " + " + second + "i";
    }


    public static Complex getInstance() {
        return complex;
    }

    public void setParameters(double x1, double x2, double i1, double i2) {
        this.x1 = x1;
        this.x2 = x2;
        this.i1 = i1;
        this.i2 = i2;
    }
}


    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите первую действительную часть: ");
            double x1 = in.nextDouble();
            System.out.print("Введите первую мнимую единицу: ");
            double i1 = in.nextDouble();
            System.out.print("Введите вторую действительную часть: ");
            double x2 = in.nextDouble();
            System.out.print("Введите вторую мнимую единицу: ");
            double i2 = in.nextDouble();
            Complex comp = Complex.getInstance();
            comp.setParameters(x1, x2, i1, i2);
            System.out.printf("Сумма = %s\n", comp.complexSum());
            System.out.printf("Разность = %s\n", comp.complexSub());
            System.out.printf("Произведение = %s\n", comp.complexMulti());
            System.out.printf("Частное = %s\n",comp.complexDiv());
        }
    }