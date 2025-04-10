# Factory Method - Sistema de Pagamento

Este projeto implementa o padrão de design **Factory Method** para resolver o problema de diferentes tipos de pagamento que um usuário pode escolher ao realizar o pagamento de sua conta. Abaixo, explicamos as classes, interfaces e enumerações utilizadas na solução.

## Estrutura do Projeto

### **1. `Pagamento.interface`**
### **2. `Pix.class`**
### **3. `CartaoDebito.class`**
### **4. `CartaoCredito.class`**
### **5. `TipoPagamento.enum`**
### **6. `PagamentoFactory.class`**

## Como Funciona

1. A `PagamentoFactory` recebe a escolha e, através do **Factory Method**, cria a instância correspondente à classe de pagamento escolhida.
2. A classe de pagamento realiza o processamento necessário de acordo com o tipo escolhido (por exemplo, a lógica de pagamento via Pix ou via cartão de crédito).
   
---

## Exemplo de Uso

TipoPagamento tipoPagamento = TipoPagamento.PIX;
Pagamento pagamento = PagamentoFactory.criarPagamento(tipoPagamento);
pagamento.processarPagamento();
