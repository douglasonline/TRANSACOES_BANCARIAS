# Transações bancárias

# Sobre o projeto

 Esse projeto Spring Boot realiza Transações bancárias e ele contém um Front end que lista os dados e permite realizar pesquisas em cima desses dados     

# Tecnologias utilizadas
## Back end
- Java
- Maven 
- Spring Boot
- Swagger

## Front end
- Node.js
- React.js


## Banco de Dados Utilizado
- PostgreSQL

# Como executar o projeto

## Back end
Pré-requisitos: Java, PostgreSQL

```bash
# Clonar repositório

# Abra o projeto Back end que está na pasta BACKEND_TRANSACOES_BANCARIAS

```
- Primeiro deve-se configurar o Banco de Dados PostgreSQL na classe BackendTransacoesBancariasApplication passando o usuário (username) e a senha (password) conforme mostra na imagem abaixo:

![Configurar Banco De Dados Primeiro Requisito](https://github.com/douglasonline/Imagens/blob/master/Configurar_Banco_De_Dados_Primeiro_Requisito.png) 

- Depois deve-se configurar o Banco de Dados PostgreSQL no application.properties passando o usuário (username) e a senha (password) conforme mostra na imagem abaixo:

![Configurando Banco De Dados Segundo Requisito](https://github.com/douglasonline/Imagens/blob/master/Configurando_Banco_De_Dados_Segundo_Requisito.png)


```bash

# Após essas configurações do Banco de Dados pode-se executar o projeto que o Database e as tabelas serão criados automaticamentes 

```

## Front end
Pré-requisitos: Node.js  

```bash
# Clonar repositório

# Primeiro deve-se executar o projeto Back end que está na pasta BACKEND_TRANSACOES_BANCARIAS

# Entre na pasta do projeto FRONTEND_TRANSACOES_BANCARIAS pelo Terminal e execute o comando npm install

# Após executar o comando npm install basta executar a aplicação com o comando npm start

```
 
# Como acessar o Swagger do Back end 
## Para acessar o Swagger do Back end que está na pasta BACKEND_TRANSACOES_BANCARIAS 

- Coloque no navegador o endereço: http://localhost:8080/swagger-ui/index.html#/

## Com o Swagger podemos ver as requisições que podemos realizar 

![Requisicoes Parte1](https://github.com/douglasonline/Imagens/blob/master/Requisicoes_Parte1.png) 

![Requisicoes Parte2](https://github.com/douglasonline/Imagens/blob/master/Requisicoes_Parte2.png) 
  

## Como consumir o projeto

- O primeiro passo e colocar dados no nosso Banco de Dados

Para colocar os dados no nosso Banco de Dados estou utilizando o Postman 

- Temos que começar criando uma conta 

![Criar Conta](https://github.com/douglasonline/Imagens/blob/master/Criar_Conta.png)

- Após criar uma conta devemos criar Transferência para essa conta ou Depósito

Quando vamos fazer uma Transferência temos que passar o conta_id que seria o id da conta que criamos anteriormente 

![Transferencia](https://github.com/douglasonline/Imagens/blob/master/Transferencia.png)

Quando vamos fazer um Depósito temos que passar o conta_id que seria o id da conta que criamos anteriormente

![Deposito](https://github.com/douglasonline/Imagens/blob/master/Deposito.png)

- No projeto Front end podemos ver os dados listados    

![Front End Tela Principal](https://github.com/douglasonline/Imagens/blob/master/Front_End_Tela_Principal.png)

- E podemos realizar pesquisas   

![Pesquisas](https://github.com/douglasonline/Imagens/blob/master/Pesquisas.png)

# Autor

Douglas

https://www.linkedin.com/in/douglas-j-b2194a232/

