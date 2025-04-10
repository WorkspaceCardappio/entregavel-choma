package br.com.cardappio.enums;

import br.com.cardappio.domain.CartaoCredito;
import br.com.cardappio.domain.CartaoDebito;
import br.com.cardappio.domain.Pix;
import br.com.cardappio.interfaces.Pagamento;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPagamento {
    PIX(new Pix()),
    CARTAO_CREDITO(new CartaoCredito()),
    CARTAO_DEBITO(new CartaoDebito());

    private final Pagamento pagamento;
}
