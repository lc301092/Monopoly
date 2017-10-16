package monopoly;

public class DiceCup {

    private Die d1;
    private Die d2;
    private int eyes1; // Husker sidste kast
    private int eyes2;

    public DiceCup(int size) {
        d1 = new Die(size);
        d2 = new Die(size);
    }

    // throw the dies
    public int throwCup() {
        eyes1 = d1.throwDie();
        eyes2 = d2.throwDie();
        return eyes1 + eyes2;
    }

    // Tjek for 2 ens
    public boolean isEqual() {
        return eyes1 == eyes2;
    }

    @Override
    public String toString() {
        return "DiceCup{" + "eyes1=  " + eyes1 + ", eyes2=  " + eyes2 + " equal? " + isEqual();
    }

}
