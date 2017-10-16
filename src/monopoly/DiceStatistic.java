/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Scanner;

/**
 *
 * @author erso
 */
public class DiceStatistic {
    
    private int[] intArray; // til opsamling af hvor mange gange der er slaaet 2, 3, ...osv.
    private DiceCup cup;

    public DiceStatistic(int dieSize) {
        intArray = new int[2*dieSize - 1]; 
        cup = new DiceCup(dieSize);
    }
    
    public void countStat(int numberOfThrows){
        int eyes;
        for(int i = 0; i < numberOfThrows; i++){
           eyes = cup.throwCup();
           intArray[eyes - 2]++;  // forskydning saa index 0 taeller 2'ere, index 1 taeller 3'ere osv.
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < intArray.length;i++){
            str = str + (i +2) +":\t" + intArray[i] + "\n";
        }
        return "DiceStatistic\n" + str;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dieSize;
        int noOfThrows;
        Scanner scan = new Scanner(System.in); // Se kap 2.6 for Scanner klassen
        
        System.out.println("Input size of your Dice:");
        dieSize = scan.nextInt();
        
        System.out.println("Input number of throws:");
        noOfThrows = scan.nextInt();


        DiceStatistic dStat = new DiceStatistic(dieSize);
        System.out.println("Før: " + dStat);
        
        dStat.countStat(noOfThrows);
        System.out.println("Efter: " + dStat);
    }
    
}
