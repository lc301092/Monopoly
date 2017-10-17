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

    private int fieldNumber;
    private String fieldName;

    protected Field(int space, String name) {
        this.fieldNumber = space;
        this.fieldName = name;
    }

    // skal skrives om, når Player class og Monopoly class er programmeret
    public String toString() {
        return "Feltets plads i arrayer er index: " + fieldNumber + " og feltet hedder i spillet: " + fieldName;
    }

    @Override
    public int getNumber() {
        return this.fieldNumber;
    }

    @Override
    public String getName() {
        return this.fieldName;
    }
    
//   

}
