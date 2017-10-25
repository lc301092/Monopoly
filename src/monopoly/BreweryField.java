/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Random;

/**
 *
 * @author Luca Casa
 */
public class BreweryField extends OwnableField {

        private Random generator;

    public BreweryField(String name, int number, int price, int rent) {

        super(name, number, price, rent);
        this.generator = new Random();
    }
   
public int randomNumber() {
        return generator.nextInt(12) + 1;
    }
    @Override
    public void consequence(Player poorPlayer) {
        Player owner = getOwner();
        if (owner != null) {
            if (owner == poorPlayer) {
                System.out.println("YOU ALREADY OWN THIS BREWERY");
            } else {
                int oldRent = rent;
                rent *= randomNumber();
                System.out.println("THIS BREWERY IS OWNED BY " + owner.getName() + " PAY THE RENT");
                poorPlayer.loseMoney(rent);
                owner.recieveMoney(rent);
                rent = oldRent;
            }
        } 
        System.out.println(poorPlayer.getName() + " landed on a Brewery field");
    }

    @Override
    public int getNumber() {
        return number;
    }

}
