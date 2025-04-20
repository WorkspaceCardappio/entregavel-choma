package br.com.cardappio.service;

import br.com.cardappio.enums.PaymentType;
import br.com.cardappio.interfaces.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class DebitCardService implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Pagamento com Cartão de débito");
    }

    @Override
    public PaymentType getType() {
        return PaymentType.DEBIT_CARD;
    }
}
