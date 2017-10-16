package monopoly;

/**
 *
 * @author erso
 */
public class GoToJailField implements FieldInterface {

    private String name;
    private int number;

    public GoToJailField(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void consequence(Player poorPlayer) {
        poorPlayer.setPos(MonopolyConstants.JAIL_POS);

    }

}
