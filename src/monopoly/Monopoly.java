package monopoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly implements MonopolyConstants {

    public final static int FIELD_COUNT = 40;

    //Data from txt document
    private File fieldData;

    // statisk array
    public static List<FieldInterface> fields;

    // 2 spillere 
    private Player p1, p2;

    public void gameSetup() {
        // readFile er en Monopoly private metode. 
        //Den scanner dokumentet og creater et game board
        readFile();
        // create players
        p1 = new Player(new DiceCup(6), "Miriam", fields.get(0), START_MONEY);
        p2 = new Player(new DiceCup(6), "Luca", fields.get(0), START_MONEY);
        
    // start game sequence
        startGame();
    }

    public void startGame() {
        
        
        while (p1.hasMoney() && p2.hasMoney()) {
            System.out.println("");
            // spiller 1 skal slå og flytte sig
            p1.move();
            
            System.out.println("");
            // spiller 2 skal slå og flytte sig
            p2.move();
            // hvis spillet ikke er over, startes en ny runde.
        }
                    System.out.println("");
        System.out.println("game is over. ");
        System.out.println(p1.getName() + " has aquired " + p1.getList());
                    System.out.println("");
        System.out.println(p2.getName() + " has aquired " + p2.getList());
    }

    private List<FieldInterface> readFile() {
        
        fields = new ArrayList<>();
        fieldData = new File("MonopolyData.txt");
       
        // scanner is used to read data in the txt file
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
                // read next line 
                line = scan.nextLine();
//              remove the tab-space between data. return the separate string tokens in an array
                tokens = line.split("\t");
                
                // store/parse the different tokens in usable variables 
                fieldNumber = Integer.parseInt(tokens[0].trim());
                fieldName = tokens[1];
                fieldType = tokens[2];
            
                // Each field is instantiated depending on fieldType and is added in arrayList
                switch (fieldType) {
                    case "start":
                        Field start = new StartField(fieldName, fieldNumber);
                        fields.add(start);
                        break;
                    case "?":
                        Field lucky = new LuckField(fieldName, fieldNumber);
                        fields.add(lucky);
                        break;
                    case "tax":
                        Field tax = new TaxField(fieldName, fieldNumber);

                        fields.add(tax);
                        break;
                    case "ship":
                        fieldPrice = Integer.parseInt(tokens[3]);
                        fieldRent = Integer.parseInt(tokens[4]);
                        Field ship = new ShipField(fieldName, fieldNumber, fieldPrice, fieldRent);
                        fields.add(ship);
                        break;
                    case "brewery":
                        fieldPrice = Integer.parseInt(tokens[3]);
                        Field brewery = new BreweryField(fieldName, fieldNumber, fieldPrice, 3);

                        fields.add(brewery);
                        break;
                    case "go2jail":
                        Field goToJail = new GoToJailField(fieldName, fieldNumber);

                        fields.add(goToJail);
                        break;
                    case "jail":
                        Field jail = new OtherField(fieldName, fieldNumber);

                        fields.add(jail);
                        break;
                    case "parking":
                        Field parking = new OtherField(fieldName, fieldNumber);

                        fields.add(parking);
                        break;
                    default:
                        fieldPrice = Integer.parseInt(tokens[3]);
                        fieldRent = Integer.parseInt(tokens[4]);
                        OwnableField street = new StreetField(fieldName, fieldNumber, fieldPrice, fieldRent);
                        fields.add(street);
                        break;
                }
            }

            // catches til eventuelle execeptions
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ne) {
            System.err.println("NumberFormatException in " + fieldName
                    + "\n" + ne.getMessage());
        } 
        finally {
            System.out.println("Game setup complete");
            scan.close();
        }
        return fields;
    }

    public void testBoard() {
        System.out.println("initialize testing...");
        System.out.println("Board size is: " + (fields.size()));
        System.out.println("testing all the fields");
        for (int i = 0; i < fields.size(); i++) {
            System.out.println("Felt: " + fields.get(i).getName() + fields.get(i).getNumber());
        }
    }
}
