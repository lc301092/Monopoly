/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import static monopoly.Monopoly.fields;

/**
 *
 * @author Luca Casa
 */
public class Player {

    private int roundsOnField;
    private DiceCup cup;
    private String name;
    private FieldInterface currentField;
    private int money;
    private int equalEyesCount;
    private ArrayList<OwnableField> properties;

    public Player(DiceCup cup, String name, FieldInterface startField, int money) {
        this.cup = cup;
        this.name = name;
        currentField = startField;
        this.money = money;
        System.out.println("player " + name + " joined the game.");
        properties = new ArrayList<>();
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

            System.out.println(name + " has passed the round marker: " + roundsOnField + " times and gets an additional: " + Monopoly.START_MONEY + "$");
            money += MonopolyConstants.START_MONEY;
        }

        currentField = Monopoly.fields.get(curPos);
        System.out.println(name + " moves to " + Monopoly.fields.get(curPos).getName() + " at space: " + Monopoly.fields.get(curPos).getNumber());

        currentField.consequence(this);

        buyPhase();
        System.out.println(name + " now has " + money + "$");

        // Tjekker om det samme antal øjne bliver slået
        checkEqualEyes();

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

        System.out.println(name + " is in jail");
        currentField = Monopoly.fields.get(JAIL_POS);

    }

    void go2Jail(int GO_TO_JAIL_POS) {
        System.out.println(name + " landed on " + Monopoly.fields.get(GO_TO_JAIL_POS) + " and is going to jail");
        System.out.println(name + " GOES TO JAIL nooooo!");
    }

    private void buyPhase() {
        boolean isBuyAble = currentField instanceof OwnableField;
        if (isBuyAble) {

            OwnableField fieldToBuy = (OwnableField) currentField;
            if (fieldToBuy.getOwner() == null) {
                System.out.println(name + " has to buy " + fieldToBuy.getName() + " at the price of " + fieldToBuy.getPrice());

                int difference = money - fieldToBuy.getPrice();
                money = difference;
                System.out.println("after buying " + money);

                fieldToBuy.setOwner(this);
                System.out.println("adding " + fieldToBuy.getName() + " to " + fieldToBuy.getOwner().getName() + " propery list");

                properties.add(fieldToBuy);
            }
        }
    }

    public int getMoney() {
        return money;
    }

    public boolean hasMoney() {
        boolean answer = (money > 0);
        return answer;
    }

    public String getName() {
        return name;
    }

    public ArrayList<OwnableField> getList() {
        return properties;
    }

    void recieveMoney(int money) {
        this.money -= money;
        System.out.println(name + " got " + money + "$, lucky you");
        System.out.println("and now " + name + " has " + this.money);

    }

    void loseMoney(int money) {
        this.money -= money;
        System.out.println(name + " lost " + money + "$");
        System.out.println("and now " + name + " has " + this.money);
    }
}
