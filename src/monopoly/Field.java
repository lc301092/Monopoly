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
public abstract class Field implements FieldInterface {

    private String name;
    protected int number;

    protected Field(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // skal skrives om, når Player class og Monopoly class er programmeret
    @Override
    public String toString() {
        return " feltet hedder i spillet: " + name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    
    
//   

}
