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
    public ShipField(String name, int number, int price) {
        super(name, number, price);
    }

    @Override
    public void consequence(Player poorPlayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumber() {
        return number;
    }

}
