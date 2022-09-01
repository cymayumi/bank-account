# bank-account

A API Rest foi elaborada utilizando Java 11, Spring Boot e banco de dados H2.<br>
Alguns testes unitários foram feitos com JUnit e Mockito.<br><br>

***Abrir Conta***<br>
POST: http://localhost:8080/cliente
<br>
Exemplo de request body:<br>
{
    "nome": "Cynthia",
    "cpf": "16256589211"
}
<br><br>

***Depositar***<br>
POST: http://localhost:8080/conta/depositar
<br>
Exemplo de request body:<br>
{
    "numero": 1,
    "deposito": 2000.00
}
<br><br>

***Transferir***<br>
http://localhost:8080/conta/transferir
<br>
Exemplo de request body:<br>
{
    "numeroDe": 1,
    "numeroPara": 2,
    "valor": 1000.00
}
<br><br>
