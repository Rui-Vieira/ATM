package acadamy.mindswap;

import acadamy.mindswap.Exceptions.*;
import acadamy.mindswap.atm.ATM;
import acadamy.mindswap.atm.Card;

import static acadamy.mindswap.Exceptions.NotEnoughFundsException.*;

public class Main {

    public static void main(String[] args) throws CardIsInException {

        ATM atm = new ATM();
        Card visa = new Card(0000,1000);




        try {
            atm.insertCard(visa);
            atm.insertPin(0000);
        }catch (ATMException e) {
            try {
                atm.insertPin(0000);
                atm.withdrew(100);
            } catch (NotEnoughPermissionException ex) {
                ex.printStackTrace();
            }catch (NotEnoughFundsException ex) {
                ex.printStackTrace();
            } catch (NoCardInsertedException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(e.getMessage());
        }finally {
            System.out.println("Looks fine!");
        }
    }

}
