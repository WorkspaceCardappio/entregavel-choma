package br.com.cardappio.interfaces;

import java.math.BigDecimal;

public interface Pagamento {

    void processarPagamento(BigDecimal valor);
}
