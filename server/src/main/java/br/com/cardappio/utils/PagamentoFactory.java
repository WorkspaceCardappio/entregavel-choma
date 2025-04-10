package br.com.cardappio.utils;

import br.com.cardappio.domain.Pix;
import br.com.cardappio.enums.TipoPagamento;
import br.com.cardappio.interfaces.Pagamento;

import java.util.Optional;

public class PagamentoFactory {

    public static Pagamento createPagamento(TipoPagamento tipoPagamento) {

        return tipoPagamento.getPagamento();
    }
}
