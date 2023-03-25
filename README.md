# CepFinder

Desafio da plataforma Digital Innovation One para o BootCamp Banco PAN Java Developer.
O projeto tem como objetivo a criação de uma API Rest que mostre os padrões de projeto como singleton, strategy e facade e, também, a utilização de uma API externa, viaCep, agregada com o client REST OpenFeing.

## Tecnologias

- **Spring Boot 3.0.5**
- **SGBD: H2**
- **ViaCep**
- **springdoc-openapi**
- **OpenFeign**

## Como usar

Para usar esta api, você precisa ter o Java e o Maven instalados na sua máquina. Depois, clone este repositório e execute o comando:

```bash
mvn spring-boot:run
```

Isso vai iniciar a aplicação na porta 8080. Para testar a api, você pode usar um cliente http como o Postman, o curl ou pelo Swagger. Por exemplo, para criar um cliente, você pode fazer:

```bash
http://localhost:8080/swagger-ui/index.htm
```

### POST

Em POST cliquem em **Try it Out** e coloque informações como o nome do cliente e o cep que deseja, assim o viaCep vai preencher o resto das informações.

algo como:

```json
{
  "name": "nome-teste",
  "address": {
    "cep": "20020100"
  }
}
```

Terá como resultado algo como:

```json
{
  "id": 1,
  "name": "nome-teste",
  "address": {
    "cep": "20020-100",
    "logradouro": "Avenida Nilo Peçanha",
    "complemento": "",
    "bairro": "Centro",
    "localidade": "Rio de Janeiro",
    "uf": "RJ",
    "ibge": "3304557",
    "gia": "",
    "ddd": "21",
    "siafi": "6001"
  }
}
```

### GET

Para consultar todos clique em **GET(/client)** seguindo de **Try it Out** que irá mostrar todos os clientes cadastrados.

### GET BY ID

Para consultar um cliente específico é só procurar por id. Clique em **GET(/client/{id})** seguido de **Try it Out** e insira o id do cliente que será buscado.

### PUT

Para atualizar um cliente clique em **PUT(/client/{id})** seguido de **Try it Out** e insira o id do cliente que será buscado.

No corpo da requisição coloque o id desejado e o que quer alterar. Por exemplo:

```json
{
  "id": 1,
  "name": "nome-teste",
  "address": {
    "cep": "20020-100"
  }
}
```

Terá como resultado:

```json
{
  "id": 1,
  "name": "nome-teste",
  "address": {
    "cep": "01002-020",
    "logradouro": "Viaduto do Chá",
    "complemento": "",
    "bairro": "Centro",
    "localidade": "São Paulo",
    "uf": "SP",
    "ibge": "3550308",
    "gia": "1004",
    "ddd": "11",
    "siafi": "7107"
  }
}
```

### DELETE

 Para deleter um cliente clique em **PUT(/client/{id})** seguido de **Try it Out** e insira o id do cliente que será deletado.

## Referências

Este projeto foi baseado nos seguintes recursos:

- [ViaCEP - Webservice CEP e IBGE gratuito](https://viacep.com.br/)
- [OpenFeign - Declarative REST Client for Java](https://github.com/OpenFeign/feign)
- [Spring Boot - Create stand-alone Spring applications](https://spring.io/projects/spring-boot)

## 📬 Contato

<a href="https://www.linkedin.com/in/renan-peixoto-rj/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

<a href = "mailto:renan2.peixoto@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>

Se você gostaria de trabalhar juntos em algum projeto ou tem alguma dúvida, não hesite em entrar em contato. Eu adoraria ouvir de você!
