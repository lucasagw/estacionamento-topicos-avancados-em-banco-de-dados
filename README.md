# SISTEMA PARA CONTROLE DE VAGAS DE UM ESTACIONAMENTO

O software deverá controlar o funcionamento de um estacionamento. 

O estacionamento tem uma quantidade limitada de vagas. A entrada e a saída de veículos do estacionamento devem ser controladas de forma a não permitir que a lotação do estacionamento seja ultrapassada. 

O estacionamento aceita tanto clientes horistas quanto clientes mensalistas. Os clientes horistas, são aqueles clientes cujo custo do estacionamento varia de acordo com o tempo de permanência do veículo no estacionamento. Este custo é calculado e pago no momento da saída do veículo do estacionamento. A entrada dos clientes horistas no estacionamento está condicionada à disponibilidade de uma vaga.

Já os clientes mensalistas, pagam um valor fixo mensal pelo uso do estacionamento. O pagamento mensal garante ao cliente a disponibilidade de uma vaga a ser ocupada por ele. Para esses clientes, o sistema deve permitir que seus dados pessoais e do veículo sejam mantidos. Quando o contrato mensal vence, o cliente deve renovar o contrato para continuar mantendo o direito de usar o estacionamento. Caso o contrato não seja renovado, o cliente passa a ser tratado como horista. 

Os valores de uso mensal e horário do estacionamento são registrados em uma tabela de preços que pode variar ao longo do tempo.

## Diagrams 

### Data Base

<img src="https://i.ibb.co/7jHVTmw/DER-estacionamento-2.png" alt="DER-estacionamento-2" border="0">

<img src="https://i.ibb.co/hdjHZh5/DER-estacionamento-dbeaver.png" alt="DER-estacionamento-dbeaver" border="0">

### JPA e Hibernate

JPA significa Java Persistence API. É uma especificação de uma "API Java para gerenciamento de persistência e mapeamento objeto/relacional em ambientes Java EE e Java SE".

JPA é apenas uma especificação, não há implementação. Pense no JPA como um conjunto de diretrizes que devem ser seguidas na implementação.

Hibernate é uma das implementações que segue essas diretrizes. Um dos benefícios de se utilizar JPA é a possibilidade de trocar de implementação, pois todas usam a mesma interface. Existem outras implementações além do Hibernate, como EclipseLink e TopLink.

Basicamente, o JPA une um conjunto de regras que permite que qualquer um possa implementar esta API, permitindo que possa usar esta implementação em qualquer projeto que utilize as interfaces JPA, garantindo assim uma certa compatibilidade entre diferentes implementações.

É aqui que entra o Hibernate. O Hibernate é uma implementação da especificação JPA.

Em teoria, se não estiver usando nenhum recurso exclusivo de alguma implementação (o que é relativamente comum), é possível trocar uma implementação por outra no seu projeto de forma transparente. Por exemplo, um mapeamento comum de entidade envolve anotações como @Column, @Table, @Id, etc, e todos eles fazem parte do pacote javax.persistence, comum a qualquer implementação JPA. Assim, uma troca do Hibernate pelo OpenJPA (por exemplo) ocorreria de forma transparente para a aplicação.

## 🛠 Getting started

Windows:

You can clone the repository through CMD (Command Prompt) just by typing:

```sh
git clone https://github.com/lucasagw/estacionamento-topicos-avancados-em-banco-de-dados.git
```
Download PostgreSQL 9.5.25: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

Instalação e configuração do PostgreSQL: http://www.bosontreinamentos.com.br/postgresql-banco-dados/instalacao-do-postgresql-no-microsoft-windows/

Download Postman: https://www.postman.com/downloads/

---

## Colaborators
	

[<img src="https://avatars.githubusercontent.com/u/62854228?v=4" width="200px; "/><br><sub><b>Carlos Lopes</b></sub>](https://github.com/carlosdevv/) |  [<img src="https://avatars.githubusercontent.com/u/15247079?v=4" width="200px;"/><br><sub><b>Jamile Conceição</b></sub>](https://github.com/jamile08) | 	
:---: | ---

[<img src="https://avatars.githubusercontent.com/u/79553621?s=96&v=4" width="200px;"/><br><sub><b>Lucas Augusto</b></sub>](https://github.com/lucasagw) | 	 [<img src="https://avatars.githubusercontent.com/u/55607722?v=4" width="200px;"/><br><sub><b>Luiz Viana</b></sub>](https://github.com/LuizVian4/) |
:---: | ---
[<img src="https://avatars.githubusercontent.com/u/54107073?v=4" width="200px;"/><br><sub><b>Marcony Souza</b></sub>](https://github.com/marconySouza) | 	 [<img src="https://avatars.githubusercontent.com/u/554178?v=4" width="200px;"/><br><sub><b>Mario Jorge</b></sub>](https://github.com/mariojp) |
