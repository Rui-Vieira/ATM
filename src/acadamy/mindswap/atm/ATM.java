package acadamy.mindswap.atm;

import acadamy.mindswap.Exceptions.CardIsInException;
import acadamy.mindswap.Exceptions.NoCardInsertedException;
import acadamy.mindswap.Exceptions.NotEnoughFundsException;
import acadamy.mindswap.Exceptions.NotEnoughPermissionException;

public class ATM {
    Card card;
    boolean isCardValidated;



    public void insertCard(Card card) throws CardIsInException {
        this.card = card;
        System.out.println("Card inserted");
    }

    public void insertPin(int pin) throws NoCardInsertedException,NotEnoughPermissionException {
        isCardValidated();
        if(card.getPin() != pin) {
            throw new NotEnoughPermissionException("Incorrect pin");
        }
        isCardValidated = true;
    }



    public void withdrew (int amount)  throws NotEnoughPermissionException, NotEnoughFundsException{

        try {
            isCardValidated();
        } catch (NoCardInsertedException e) {
            throw new RuntimeException(e);
        }

        if(! isCardValidated) {
            throw new NotEnoughPermissionException("Please insert pin");
        }
        if(card.getBalance() < amount) {
            throw new NotEnoughPermissionException("ss");
        }
        card.setBalance(card.getBalance()-amount);
        System.out.println("Withdrawn" + amount+ "of" + card.getBalance());
    }

    private void isCardValidated() throws NoCardInsertedException {
        if (card == null) {
        throw new NoCardInsertedException("new!");
        }
    }
}
