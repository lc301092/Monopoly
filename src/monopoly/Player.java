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
    private OwnableField currentField;
    private int money;

    public Player(DiceCup cup, String name, OwnableField startField, int money) {
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
        System.out.println(name + " rolls " + roll);
        // return the new position
        curPos += roll;

        if (curPos >= Monopoly.FIELD_COUNT) {
            curPos = curPos % Monopoly.FIELD_COUNT;
            roundsOnField++;
            currentField = Monopoly.fields.get(curPos);
            System.out.println(name + " moves to " + Monopoly.fields.get(curPos).getName() + " at space: " + Monopoly.fields.get(curPos).getNumber());
            System.out.println(name + " has passed the round marker: " + roundsOnField + " times and gets an additional: " + Monopoly.START_MONEY + "$");
            money += MonopolyConstants.START_MONEY;
            System.out.println(name + " now has " + money + "$");

            // Tjekker om det samme antal øjne bliver slået
            if (cup.isEqual()) {
                System.out.println(name + "'s dies were equal, roll again:");
                move();
            }
        } else {

            currentField = Monopoly.fields.get(curPos);
            System.out.println(name + " moves to " + Monopoly.fields.get(curPos).getName() + " at space: " + Monopoly.fields.get(curPos).getNumber());

            // Tjekker om det samme antal øjne bliver slået
            if (cup.isEqual()) {
                System.out.println(name + "'s dies were equal, roll again:");

                move();
            }
        }

    }

    void setPos(int JAIL_POS) {
        // HER SKAL VÆRE NOGET KODE FOR AT RYGE I FÆNGSEL;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
