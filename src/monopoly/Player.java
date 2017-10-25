/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;

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
        // current position before roll 
        int curPos = currentField.getNumber();
        // the player throws the cup
        int roll = cup.throwCup();
        System.out.println(name + " rolls " + roll);

        // add roll to value of curPos
        curPos += roll;

        // test if the position is over gameboards length 
        if (curPos >= Monopoly.FIELD_COUNT) {

            curPos = curPos % Monopoly.FIELD_COUNT;
            roundsOnField++;

            System.out.println(name + " has passed the round marker: " + roundsOnField + " times and gets an additional: " + Monopoly.START_MONEY + "$");
            money += MonopolyConstants.START_MONEY;
        }
        // place the player on the new field
        currentField = Monopoly.fields.get(curPos);
        System.out.println(name + " moves to " + Monopoly.fields.get(curPos).getName() + " at space: " + Monopoly.fields.get(curPos).getNumber());

        // resolve consequence for the new field
        currentField.consequence(this);

        // if the private member; owner, of the field is null the player must buy it. no choice. please 
        buyPhase();

        // Tjekker om det samme antal øjne bliver slået
        checkEqualEyes();

    }

    private void checkEqualEyes() {

        // Tjekker om det samme antal øjne bliver slået
        if (cup.isEqual()) {

            equalEyesCount++;
            System.out.println(name + "'s dies were equal, roll again:");
            System.out.println(name + "'s EQUAL DICE COUNT: " + equalEyesCount);
            System.out.println("");

            // if the player rerolls 3 times the position is set to jail
            if (equalEyesCount > 2) {
                setPos(MonopolyConstants.JAIL_POS);
            } else {
                move();
            }
        }
        equalEyesCount = 0;
    }

    void setPos(int newPos) {
        System.out.println(name + " moved to jail");
        currentField = Monopoly.fields.get(newPos);
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
        this.money += money;
        System.out.println(name + " got " + money + "$, lucky you");
        System.out.println("and now " + name + " has " + this.money + "$");
    }

    void loseMoney(int money) {
        this.money -= money;
        System.out.println(name + " lost " + money + "$");
        System.out.println("and now " + name + " has " + this.money + "$");
    }
}
