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
public class ShipField extends OwnableField {

    // der skal laves sådan at ShipField ved hvor mange af de andre shipfields som ejes af samme player.
    //private ShipField[] ownCount;
    public ShipField(String name, int number, int price, int rent) {
        super(name, number, price, rent);
    }

    @Override
    public void consequence(Player poorPlayer) {
        System.out.println(poorPlayer + " landed on a shipfield");
    }

    @Override
    public int getNumber() {
        return number;
    }

}
