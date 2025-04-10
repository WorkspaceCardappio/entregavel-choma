package br.com.cardappio.domain;

import br.com.cardappio.interfaces.Pagamento;

import java.math.BigDecimal;

public class Pix implements Pagamento {

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println(String.format("Valor de %s pago no %s", valor, Pix.class));
    }
}
