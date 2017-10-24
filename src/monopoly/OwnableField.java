
package monopoly;

/**
 *
 * @author erso
 */
public abstract class OwnableField extends Field{
    // This field is never assigned:
    // NOTE: name field semantically "shadows" Field.fieldName.
    private int price;
    private Player owner;
    private int rent; 

    protected OwnableField(String name, int number, int price, int rent)
    {
        // Parameter passed to constructor is passed to base class.
        super(name, number);
        this.price = price;
        this.rent = rent; 
        
        // Solution:
        // this.name = name;
        
        // Is this.name redundant? Is this.name semantically equal to Field.fieldName?
        // In that case, actual solution: drop this.name and fallback to Field.fieldName!
        
    }

    

   
    public int getPrice()
    {
        return price;
    }

    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

}
