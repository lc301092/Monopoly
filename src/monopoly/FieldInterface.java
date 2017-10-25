
package monopoly;

/**
 *
 * @author erso
 */


public interface FieldInterface
{
    // Disse metoder er underforstået 'public abstract static': 
    String getName();
    int getNumber();
    void consequence(Player poorPlayer);
}
