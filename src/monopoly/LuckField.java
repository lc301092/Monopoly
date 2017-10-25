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
public class LuckField extends Field {

    private Random generator;

    public LuckField(String name, int number) {
        super(name, number);
        this.generator = new Random();
    }

    public int randomNumber() {
        return generator.nextInt(3) + 1;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void consequence(Player poorPlayer) {
        System.out.println(poorPlayer.getName() + " PICKS A CARD FROM LUCK PILE");
        int R = randomNumber();
        if (R <= 2) {
            poorPlayer.recieveMoney(MonopolyConstants.LUCK_MONEY);
        } else if (R == 3) {
            poorPlayer.loseMoney(MonopolyConstants.LUCK_MONEY);
        }
    }
}
