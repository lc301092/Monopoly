
package monopoly;

/**
 *
 * @author erso
 */
public abstract class OwnableField extends Field{
    // This field is never assigned:
    private String name;
    
    private int number;
    private int price;
    private Player owner;

    protected OwnableField(String name, int number, int price)
    {
        // Parameter passed to constructor is passed to base class.
        super(number, name);
        this.price = price;
        // Solution:
        // this.name = name;
        
        // Is this.name redundant? Is this.name semantically equal to Field.fieldName?
        // In that case, drop this.name and fallback to Field.fieldName!
        
    }

    

    @Override
    public String getName(){
        // TODO Refers instance field of OwnableField!
        return name;
    }

    @Override
    public int getNumber()
    {
        return number;
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
