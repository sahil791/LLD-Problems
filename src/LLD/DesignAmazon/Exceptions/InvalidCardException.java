package LLD.DesignAmazon.Exceptions;

public abstract class InvalidCardException extends Exception{
    public InvalidCardException(String msg) {
        super(msg);
    }
}
