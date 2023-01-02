# Sobre
Repositório com exemplo de tracing utilizando produtor e consumidores implementados utilizando Quarkus e Camel comunicando-se utilizando ActiveMQ.

# Projetos

* produtor
  * A cada 5s envia uma mensagem para `fila1`
* consumidor-produtor-1
  * Lê as mensagens da `fila1` e envia uma mensagem para `fila2`
* consumidor-2
  * Lê as mensagens da `fila2`

# Pré-requisitos

* JDK 11+
* Quarkus CLI
* Docker

# Init Env

* Init AMQ e Jaeger: ```docker compose up```
* Artemis Console: ``` http://localhost:8161/console/ ```
* Jaeger: ```http://localhost:16686/search```  

# Init apps
* Execute: ```quarkus dev``` nos projetos `produtor`, `consumidor-produtor-1` e `consumidor-2`


# Exemplo de visualização no Jaeger

