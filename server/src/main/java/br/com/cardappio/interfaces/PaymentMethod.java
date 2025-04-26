package br.com.cardappio.interfaces;

import br.com.cardappio.enums.PaymentType;

public interface PaymentMethod {

    void pay();

    PaymentType getType();

}
