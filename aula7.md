# Strategy - Pagar

Este projeto implementa o padrão de design **Strategy** para resolver o problema de diferentes tipos de pagamento que um usuário pode escolher ao realizar o pagamento de sua conta. Abaixo, explicamos as classes, interfaces e enumerações utilizadas na solução.

## Estrutura do Projeto

### **1. `PaymentMethod.interface`**
### **2. `PixService.class`**
### **3. `CreditCardService.class`**
### **4. `DebitCardService.class`**
### **5. `PaymentType.enum`**
### **6. `PaymentStrategy.class`**

## Como Funciona

1. A classe `PaymentStrategy` injeta todos os serviços que implementam PaymentMethod em um Set<`PaymentMethod`>.
2. Cada classe que implementa o `PaymentMethod` deve implementar o método void pay() e PaymentType getType().
3. Na classe `PaymentStrategy` tem um método `PaymentMethod` getByType(PaymentType type) que retorna o método de pagamento correto.
4. Caso seja um tipo inválido é lançado uma exception.
   
---

## Exemplo de Uso

final PaymentMethod method = paymentStrategy.getByType(PaymentType.CREDIT_CARD);
method.pay();
