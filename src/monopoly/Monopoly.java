package monopoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly implements MonopolyConstants {

    public final static int FIELD_COUNT = 40;
    private final static int ROUND_MAX = 10;
    private int roundCounter;

    //scanner
    private File fieldData;

    // statisk array
    public static List<Field> fields;

    // 2 spillere 
    private Player p1, p2;

    public void gameStart() {
        // readFile er Monopoly private metode. 
        //Den scanner dokumentet og creater et game board
        readFile();

        // testBoard();
        // create players
        p1 = new Player(new DiceCup(6), "Miriam", fields.get(0), START_MONEY);
        p2 = new Player(new DiceCup(6), "Luca", fields.get(0), START_MONEY);
        // start game sequence
        newRound();
    }

    public void newRound() {
        roundCounter++;
        if (roundCounter > ROUND_MAX) {
            System.out.println("Game is over now");
        } else {
            System.out.println("Round " + roundCounter);
            // spiller 1 skal slå og flytte sig
            p1.move();
            // spiller 2 skal slå og flytte sig
            p2.move();
            // hvis spillet ikke er over, startes en ny runde.
            newRound();
        }
    }

    private List<Field> readFile() {
        fields = new ArrayList<>();
        // scanner is used to read data in the txt file
        fieldData = new File("MonopolyData.txt");
        Scanner scan = null;
        // variables to hold the data from the eventually returned String tokens
        String line;
        String[] tokens;

        int fieldNumber;
        String fieldName = "";
        String fieldType = "";
        int fieldPrice;
        int fieldRent;
        //document is  scanned  
        try {
            // instantiate scanner
            scan = new Scanner(fieldData, "UTF-8");
            // scanning continues until there is no more lines of data in document 
            while (scan.hasNextLine()) {
                // read next line and remove the tab-space between data
                line = scan.nextLine();
                tokens = line.split("\t");
                // store/parse the different tokens in usable variables 
                fieldNumber = Integer.parseInt(tokens[0].trim());
                fieldName = tokens[1];
                fieldType = tokens[2];
                /* // de næste 2 er udkommenteret fordi fx start feltet ingen pris har 
                // hvilket giver fejl når man prøver at få data derfra.
                fieldPrice = Integer.parseInt(tokens[3]);
                fieldRent = Integer.parseInt(tokens[4]);
                 */

                // ud for hver case skal:
                // 1. feltet instantieres
                // 2. pushes ind i arrayet som er spilbrættet
                switch (fieldType) {
                    case "start":
                        System.out.println("Felt: " + fieldNumber + " new otherField startfelt");
                        // NY CLASS StartField SKAL LAVES.
                        Field start = new OtherField(fieldName, fieldNumber);
                        fields.add(start);
                        break;
                    case "?":
                        System.out.println("Felt: " + fieldNumber + " new otherField lykkefelt");
                        Field lucky = new LuckField(fieldName, fieldNumber);
                        fields.add(lucky);
                        break;
                    case "tax":
                        System.out.println("Felt: " + fieldNumber + " new otherField skattefelt");
                        Field tax = new StreetField(fieldName, fieldNumber, 10000);
                        fields.add(tax);
                        break;
                    case "ship":
                        System.out.println("Felt: " + fieldNumber + " new shipfield");
                        fieldPrice = Integer.parseInt(tokens[3]);
                        Field ship = new ShipField(fieldName, fieldNumber, fieldPrice);
                        fields.add(ship);
                        break;
                    case "brewery":
                        System.out.println("Felt: " + fieldNumber + " new breweryfield");
                        Field brewery = new StreetField(fieldName, fieldNumber, 10000);
                        fields.add(brewery);
                        break;
                    case "go2jail":
                        System.out.println("Felt: " + fieldNumber + " new otherfiled gotojailfield");
                        Field goToJail = new StreetField(fieldName, fieldNumber, 10000);
                        fields.add(goToJail);
                        break;
                    case "jail":
                        System.out.println("Felt: " + fieldNumber + " new otherfield jailfield");
                        Field jail = new StreetField(fieldName, fieldNumber, 10000);
                        fields.add(jail);
                        break;
                    case "parking":
                        System.out.println("Felt: " + fieldNumber + " new otherfield parkeringsplads");
                        Field parking = new StreetField(fieldName, fieldNumber, 10000);
                        fields.add(parking);
                        break;
                    default:
                        System.out.println("Felt: " + fieldNumber + " " + fieldName + "'s længde er " + tokens.length);
//                    if(tokens.length > 4){
                        fieldPrice = Integer.parseInt(tokens[3]);
                        OwnableField street = new StreetField(fieldName, fieldNumber, fieldPrice);
                        fields.add(street);
//                    }
                        break;
                }
            }
            // catches til eventuelle execeptions
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ne) {
            System.err.println("NumberFormatException in " + fieldName
                    + "\n" + ne.getMessage());
        } // scan skal stoppes igen, så den ikke bliver ved
        finally {
            System.out.println("Game setup complete");

            scan.close();
        }
        // fields is the array that is used as gameboard
        return fields;

    }

    public void testBoard() {
        System.out.println("initialize testing...");
        System.out.println("Board size is: " + (fields.size()));
        System.out.println("Board array: " + (fields));
        System.out.println("testing all the fields");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println("field " + i + " is " + fields.get(i).getName());
        }
    }
}
