package acadamy.mindswap.Exceptions;

public class NotEnoughFundsException extends ATMException{


    public NotEnoughFundsException() {
        super("Not enough balance to do this operation!");
    }
}
