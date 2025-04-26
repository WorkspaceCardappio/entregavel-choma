package br.com.cardappio.service;

import br.com.cardappio.enums.PaymentType;
import br.com.cardappio.interfaces.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PaymentStrategy {

    private final Set<PaymentMethod> paymentMethods;

    public PaymentMethod getByType(final PaymentType paymentType) throws Exception {

        return paymentMethods.stream()
                .filter(method -> paymentType.equals(method.getType()))
                .findFirst()
                .orElseThrow(() -> new Exception("Tipo de pagamento inválido"));
    }
}
