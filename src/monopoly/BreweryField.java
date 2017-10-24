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
public class BreweryField extends OwnableField{

    public BreweryField(String name, int number, int price) {
        
        // 0 symboliserer rent SKAL ÆNDRES
        super(name, number, price, 0);
    }

    @Override
    public void consequence(Player poorPlayer) {
        System.out.println(poorPlayer + " landed on a Brewery field");
    }

    @Override
    public int getNumber() {
       return number; 
    }
    
}
