/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author Luca Casa
 */
public class Player {

    private int roundsOnField;
    private DiceCup cup;
    private String name;
    private Field currentField;
    private int money;
    private int equalEyesCount;

    public Player(DiceCup cup, String name, Field startField, int money) {
        this.cup = cup;
        this.name = name;
        currentField = startField;
        this.money = money;
        System.out.println("player " + name + " joined the game.");
    }

    public void move() {
        // current position
        int curPos = currentField.getNumber();
        // the active player throws the cup
        int roll = cup.throwCup();
       // System.out.println(name + " rolls " + roll);
        // return the new position
        curPos += roll;
       
        // Måske et if statement, der tjekker om spilleren er på go2Jail fields
        
        
        if (curPos >= Monopoly.FIELD_COUNT) {
            // spilleren forbipasserer startfeltet
            curPos = curPos % Monopoly.FIELD_COUNT;
            roundsOnField++;
            currentField = Monopoly.fields.get(curPos);
            System.out.println(name + " moves to " + Monopoly.fields.get(curPos).getName() + " at space: " + Monopoly.fields.get(curPos).getNumber());
            System.out.println(name + " has passed the round marker: " + roundsOnField + " times and gets an additional: " + Monopoly.START_MONEY + "$");
            money += MonopolyConstants.START_MONEY;
            System.out.println(name + " now has " + money + "$");

            // Tjekker om det samme antal øjne bliver slået
            checkEqualEyes();
        } 
        
        else {

            currentField = Monopoly.fields.get(curPos);
            System.out.println(name + " moves to " + Monopoly.fields.get(curPos).getName() + " at space: " + Monopoly.fields.get(curPos).getNumber());

            // Tjekker om det samme antal øjne bliver slået
            checkEqualEyes();
        }

    }

    private void checkEqualEyes() {

        // Tjekker om det samme antal øjne bliver slået
        if (cup.isEqual()) {

            equalEyesCount++;
            System.out.println(name + "'s dies were equal, roll again:");
            System.out.println(name + "'s EQUAL DICE COUNT: " + equalEyesCount);

            if (equalEyesCount >= 3) {
               
                // gå i fængsel position 
                setPos(MonopolyConstants.JAIL_POS); 
            }
            move();
        }
        equalEyesCount = 0;
    }

    void setPos(int JAIL_POS) {
        System.out.println( name + " is in jail");
        currentField = Monopoly.fields.get(JAIL_POS);
                
        
    }
    void go2Jail(int GO_TO_JAIL_POS){
        System.out.println(name + " landed on "+ Monopoly.fields.get(GO_TO_JAIL_POS) +" and is going to jail");
        
    }
}

