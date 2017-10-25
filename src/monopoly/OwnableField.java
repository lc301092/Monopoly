
package monopoly;

/**
 *
 * @author erso
 */
public abstract class OwnableField extends Field{
    
    private int price;
    private Player owner;
    int rent; 
    
    protected OwnableField(String name, int number, int price, int rent)
    {
        super(name, number);
        this.price = price;
        this.rent = rent;     
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
