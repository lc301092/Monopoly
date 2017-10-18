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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
