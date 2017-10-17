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
public class OtherField extends Field{
    private String name;
    private int number;
    // 

    protected OtherField(String name, int number)
    {
       super(number, name);
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getNumber()
    {
        return number;
    }
    

    @Override
    public void consequence(Player poorPlayer) {
            // has a special effect depending if it's eg. start field or luckfield 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 
