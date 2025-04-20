package br.com.cardappio.service;

import br.com.cardappio.enums.PaymentType;
import br.com.cardappio.interfaces.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PixService implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Pagamento com Pix");
    }

    @Override
    public PaymentType getType() {
        return PaymentType.PIX;
    }
}
