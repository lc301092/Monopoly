package monopoly;

/**
 *
 * @author erso
 */
public class GoToJailField extends Field {

    public GoToJailField(String name, int number) {
        super(name, number);
    }

    @Override
    public void consequence(Player poorPlayer) {
        poorPlayer.setPos(MonopolyConstants.JAIL_POS);
    }

    @Override
    public int getNumber() {
        return number; 
    }

}
