package br.com.cardappio.domain;

import br.com.cardappio.interfaces.Pagamento;

import java.math.BigDecimal;

public class CartaoDebito implements Pagamento {

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println(String.format("Valor de %s pago no %s", valor, "Cartão de Débito"));
    }

}
