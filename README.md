# Sistema de Cadastro de Funcionários

Aplicação desktop desenvolvida em **Java Swing** para realizar o cadastro e a consulta de funcionários. O sistema também possui autenticação de usuários, permitindo criar uma conta e acessar a área de gerenciamento após realizar o login.

---

## Tecnologias Utilizadas

- **NetBeans**: Ambiente de desenvolvimento do projeto.
- **Java 21** — Linguagem de programação.
- **Java Swing**: Para criação das telas e funcionalidades.
- **JDBC**: Conexão e comunicação com o banco de dados.
- **PostgreSQL**: Banco de dados relacional para persistência dos dados.
- **Docker**: Conteinerização do banco de dados PostgreSQL
- **Figma**: Prototipação das telas.

---

## Funcionalidades

### Autenticação de usuários
- Cadastro de usuários com nome, e-mail e senha.
- Login utilizando e-mail e senha.
- Verificação das credenciais cadastradas.
- Armazenamento da senha em formato de hash SHA-256.

### Gerenciamento de funcionários
- Cadastro de funcionários com:
  - Nome completo;
  - Data de admissão;
  - Salário;
  - Situação (ativo ou inativo).
- Validação dos campos obrigatórios.
- Validação do formato da data (`dd/MM/aaaa`).
- Validação do valor do salário.
- Listagem dos funcionários cadastrados em uma tabela, ordenada pelo nome.

---

## Organização do projeto

O código está organizado em pacotes com responsabilidades separadas:

```text
src/
├── resources/             # Imagens utilizadas nas telas
└── sistema/
    ├── controller/        # Regras de fluxo entre telas e acesso aos dados
    ├── model/             # Classes que representam os dados
    │   └── dao/           # Acesso ao banco de dados
    ├── util/              # Utilitários, como a geração de hash de senha
    └── view/              # Interfaces gráficas (Java Swing)
```

---

## Pré-requisitos

Antes de executar a aplicação, tenha instalado:

- JDK 21;
- Docker Compose;
- Apache NetBeans (ou uma IDE compatível com projetos Java Ant);
- Driver JDBC do PostgreSQL;
- Biblioteca Absolute Layout utilizada pelas interfaces do projeto.

---

## Como executar

1. Clone o repositório: 
```bash
git clone https://github.com/marceloflp/sistema-cadastro-funcionarios.git
```

2. Acesse a pasta do projeto (de preferência pelo Apache NetBeans)

3. Execute o Docker Compose com o banco de dados
```bash
docker compose up -d
```
4. Acesse a pasta `src/sistema` e execute a classe Main (ou aperte F6)

---

## Observações

- O projeto é uma aplicação desktop; não é necessário executar um servidor web.
- A listagem apresenta os funcionários cadastrados, mas a versão atual não disponibiliza operações de edição ou exclusão de funcionários pela interface.
- As credenciais do banco estão definidas diretamente na classe `Conexao`, podendo ser alterada desde que as mesmas informações estejam no `docker-compose.yml`.
- A criptografia da senha é feita utilizando SHA-256

