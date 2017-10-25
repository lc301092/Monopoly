/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author miriam
 */
public class StartField extends Field {

    StartField(String name, int number) {
        super(name, number);
    }
    
      @Override
    public void consequence(Player poorPlayer) {
          System.out.println(poorPlayer.getName() + " landed on the " + name);
    }

    @Override
    public int getNumber() {
        return number; 
    }
}
