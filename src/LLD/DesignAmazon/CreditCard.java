package LLD.DesignAmazon;

import LLD.DesignAmazon.Exceptions.InvalidCVVException;
import LLD.DesignAmazon.Exceptions.InvalidCardNumberException;

import java.time.LocalDate;

public class CreditCard {
    long cardNumber;
    String nameOnCard;
    LocalDate cardExpiry;
    LocalDate validFrom;
    int cvv;

    public CreditCard(long cardNumber, String nameOnCard, LocalDate cardExpiry, LocalDate validFrom, int cvv) throws InvalidCardNumberException, InvalidCVVException {
        validateCardDetails(cardNumber, nameOnCard, cardExpiry, validFrom, cvv);
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cardExpiry = cardExpiry;
        this.validFrom = validFrom;
        this.cvv = cvv;
    }

    public void validateCardDetails(long cardNumber, String nameOnCard, LocalDate cardExpiry, LocalDate validFrom, int cvv) throws InvalidCardNumberException, InvalidCVVException {
        if(cardNumber != 16) {
            throw new InvalidCardNumberException("Card Number is not valid");
        }
        if(cvv != 3) {
            throw new InvalidCVVException("Invalid CVV");
        }
    }
}
