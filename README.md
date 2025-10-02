# Sistema de Aluguel de Carros

Projeto desenvolvido para a disciplina de **Projetos de Software**.  
O sistema tem como objetivo apoiar a **gestão de aluguéis de automóveis**, permitindo que clientes realizem cadastro, efetuem, modifiquem e cancelem pedidos de aluguel. Já os agentes (empresas e bancos) podem avaliar e aprovar os pedidos, vinculando-os a contratos de crédito quando necessário. O sistema também registra informações sobre clientes, automóveis e contratos de forma estruturada.

## 👥 Integrantes
- Arthur Candian De Azevedo Moia
- Luis Henrique Fantini Almeida
- Rafael de Oliveira Caldeira Lopes

## 📊 Diagramas do Projeto

### Diagrama de Casos de Uso
Representa as principais interações entre os **usuários (clientes e agentes)** e o sistema, destacando as funcionalidades de cadastro, pedidos, etc.

![Diagrama de Casos de Uso](./docs/diagrama-de-casos-de-uso.png)

---

### Histórias do Usuário
Documento que descreve, como os **usuários interagem com o sistema** e quais objetivos buscam alcançar.

[📄 Histórias de Usuário](./docs/historias-de-usuario.pdf)

---

### Diagrama de Classes
Apresenta a **estrutura do sistema** em termos de classes, atributos e relacionamentos, servindo de base para a implementação.

![Diagrama de Classes](./docs/diagrama-de-classes.png)

---

### Diagrama de Pacotes (Visão Lógica)
Mostra a **organização lógica dos pacotes** no projeto, seguindo o padrão **MVC (Model-View-Controller)** adaptado ao contexto do sistema.

![Diagrama de Pacotes](./docs/diagrama-de-pacotes.png)

---

### Diagrama de Componentes (Visão Lógica)
Mostra a **divisão do sistema em partes independentes** que se comunicam entre si.  
No projeto, o frontend consome a API do backend (Spring Boot), que organiza as regras de negócio em camadas (Controller, Service e Repository) e persiste os dados no banco **MySQL**.

![Diagrama de Componentes](./docs/diagrama-de-componentes.png)

---

### Diagrama de Implantação (Visão Física)
Representa a **distribuição do sistema nos diferentes ambientes de execução**.  
Os usuários acessam o sistema por meio de um navegador web, que se conecta ao **servidor da aplicação Spring Boot**. Esse servidor, por sua vez, comunica-se com o **servidor MySQL** para armazenar e recuperar os dados.

![Diagrama de Implantação](./docs/diagrama-de-implantacao.png)

---

