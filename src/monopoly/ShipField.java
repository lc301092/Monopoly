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

    public ShipField(String name, int number, int price, int rent) {
        super(name, number, price, rent);
    }

    @Override
    public void consequence(Player poorPlayer) {
        System.out.println(poorPlayer.getName() + " landed on a shipfield");
    }

    @Override
    public int getNumber() {
        return number;
    }
}
