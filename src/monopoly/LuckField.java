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
public class LuckField extends Field {
    
    public LuckField(String name, int number) {
        super(name, number);
    }

    @Override
    public int getNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consequence(Player poorPlayer) {
        System.out.println(poorPlayer + " PICKS A CARD FROM LUCK PILE");
    }
}
