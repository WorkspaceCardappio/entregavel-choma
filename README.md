# PROJETO - ARQUITETURA DE SOFTWARE

## Definição do produto

**Aplicativo mobile** que permite que o usuário acesse o cardápio digital do restaurante, realize pedidos e possibilite o fechamento e pagamento da conta de forma online.

**Aplicativo web** que permite que o responsável pelo estabelecimento gerencie as comandas abertas por mesa, realize a validação do pagamento feito de forma online e possibilita o fechamento da comanda aberta pelo usuário ou pelo garçom.

## Objetivo

- **Usuário**: facilitar o fechamento de contas pelo usuário, permitindo o controle dos pedidos realizados.
- **Estabelecimento**: permitir o gerenciamento das comandas abertas e controlar o fechamento das mesas.

## Público-alvo

Nosso público-alvo serão os restaurantes que já utilizam o cardápio digital e/ou gerenciamento de pedidos de forma online.

## Contexto de uso

Grupos que frequentam restaurantes e enfrentam problemas no fechamento/divisão da conta.

## Requisitos do sistema

### Requisitos funcionais:

#### Aplicativo mobile:
- **Visualização do cardápio digital**: o usuário deve poder visualizar o cardápio completo do restaurante, com categorias, descrições, preços e imagens dos itens.
- **Seleção de itens e montagem do pedido**: o usuário deve poder selecionar itens do cardápio, definir quantidades, adicionar ao carrinho e editar o pedido antes da finalização.
- **Cálculo do total da conta**: o sistema deve calcular automaticamente o valor total do pedido, incluindo eventuais despesas com entrada (couvert), taxa do garçom e descontos (cupons).
- **Processamento do pagamento online**: o usuário deve poder realizar o pagamento de forma segura através de métodos online (cartão de crédito, de débito, Pix, etc.).
- **Confirmação e notificação de pagamento**: após a conclusão do pagamento, o sistema deve enviar uma confirmação do pagamento para o usuário.
- **Histórico de pedidos**: o aplicativo deve permitir que o usuário visualize o histórico dos pedidos realizados e do valor parcial da conta em aberto.

#### Aplicativo Web:
- **Autenticação e controle de acesso**: o responsável pelo estabelecimento deve realizar login para acessar as funcionalidades administrativas do sistema.
- **Visualização e gerenciamento de comandas**: o sistema deve exibir as comandas abertas por mesa, permitindo ao administrador e aos garçons visualizar detalhes do pedido.
- **Fechamento de comanda**: o responsável e/ou o garçom devem poder fechar a comanda, registrando o encerramento e finalizando a conta.
- **Atualização do cardápio**: o sistema deve possibilitar a inclusão, alteração e remoção de itens no cardápio, permitindo a atualização de preços, descrição e imagens.

### Requisitos não funcionais:

- **Desempenho**: o sistema deve responder às interações dos usuários em até 2 segundos, mesmo quando houver alta demanda.
- **Segurança**: dados considerados sensíveis de acordo com a LGPD devem ser criptografados.
- **Escalabilidade**: a arquitetura de microsserviços deve permitir a escalabilidade horizontal para atender ao aumento de usuários e transações sem perda de desempenho.
- **Confiabilidade e Disponibilidade**: deve haver a implementação de mecanismos de tolerância a falhas e redundância de modo que o serviço não seja interrompido, e o sistema deve ter disponibilidade de 95%.
- **Usabilidade**: as interfaces devem ser intuitivas e responsivas.
- **Compatibilidade**: o aplicativo mobile deve funcionar corretamente em dispositivos com Android e iOS. Já a aplicação Web deve ser compatível com os principais navegadores (Firefox, Chrome, Edge).

## Restrições e condições

- Para o desenvolvimento do **aplicativo mobile** será utilizada a linguagem **Flutter**, tendo em vista que os integrantes do grupo possuem conhecimento prévio e já desenvolveram projetos nesta linguagem. Além disso, o Flutter é multiplataforma e possui uma flexibilidade de arquitetura.
- Para o desenvolvimento da **aplicação web**, será utilizada a linguagem **Java no backend**, por ser multiplataforma e robusta. O **frontend será desenvolvido em Angular**.
- O banco de dados utilizado será **PostgreSQL**, por ser um banco de dados relacional, robusto, open source, possuir uma comunidade ativa, estar em conformidade com padrões SQL e possibilitar suporte a dados não relacionais.
- A arquitetura utilizada será a de **microsserviços**.

## Tendências tecnológicas

Não serão aplicadas tendências tecnológicas.

## Riscos do projeto

- **Adoção da solução**: existe o risco de baixa adesão por parte de restaurantes e usuários, por resistência a novas tecnologias ou por não portarem meios de utilizarem a solução.
- **Mudanças no escopo**: alterações ou acréscimos de funcionalidades durante o desenvolvimento podem impactar os prazos e os custos do projeto.
- **Riscos tecnológicos**: a dependência de tecnologias específicas (**Flutter, Java, Angular e PostgreSQL**) pode se tornar um risco caso haja descontinuação, atualizações incompatíveis ou dificuldades na manutenção.
