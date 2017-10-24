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
public class StreetField extends OwnableField {

    public StreetField(String name, int number, int price, int rent) {
        super(name, number, price, rent);
    }

    @Override
    public void consequence(Player poorPlayer) {
        Player owner = getOwner();
        if (owner != null) {
            if (owner == poorPlayer) {
                System.out.println("YOU ALREADY OWN THIS STREET");
                rent *= 2;
            } else {
                System.out.println("THIS STREET IS OWNED BY " + owner.getName() + " PAY THE RENT");
                poorPlayer.loseMoney(rent);
                owner.recieveMoney(rent);
            }
        } // owner is null so the street can be bought
        else {
            // pay the price

            // set the owner
            setOwner(poorPlayer);
        }

    }

    @Override
    public int getNumber() {
        return number;
    }
}
