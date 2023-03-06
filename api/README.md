# Getting start
## Dependecies

Para a execução deste projeto serão necessárias as seguintes ferramentas/tecnologias:
* Java JDK versão 19;
* IDE de sua preferência;
* Apache Maven;
* Docker.

## Setup

Para instalar o Java JDK versão 19 em sistemas Linux siga as instruções deste artigo: [Java OpenJDK 19](https://openjdk.org/install/)<br/>
Para outros sistemas (OSX ou Windows) -- realize o download neste site: [Java OracleJDK 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)

Para instalar o Apache Maven em sistemas Linux siga as instruções deste artigo: [Apache Maven Linux](https://maven.apache.org/install.html)<br/>
Para instalar o Apache Maven em sistema Windows siga as instruções deste artigo: [Apache Maven Windows](https://dicasdejava.com.br/como-instalar-o-maven-no-windows/)<br/>
Para instalar o Apache Maven em sistema OSX siga as instruções deste artigo: [Apache Maven OSX](https://www.digitalocean.com/community/tutorials/install-maven-mac-os)<br/>

Para instalar o Docker acesse [Docker Engine install](https://docs.docker.com/engine/install/), escolha a versão que se encaixa no seu sistema e siga as instruções.

Após clonar o repositório em sua máquina, inicie o docker container de serviço cache com a seguinte linha de comando:
```sh
docker run -it \
    --name redis \
    -p 6379:6379 \
    redis:5.0.3
```
Importe o projeto em sua IDE e em seguida espere a aplicação ser construída para alterar o valor das chaves **user**/**password** 
no arquivo **src/main/resources/application.yaml** com valores de sua preferência.
Em seguida execute o comando a seguir na pasta raíz do projeto:
```sh
mvn clean install
```

Após isto pode-se executar a aplicação através de sua IDE ou caso opte por executar via CLI (Command Line [Linha de Comando]) utilize a linha abaixo no seu terminal:
```sh
mvn spring-boot:run
```

## Spring Security - Basic Authentication

Na primeira vez que tentar acessar algum dos endpoints através do navegador ou de um aplicativo para consultas será 
necessário configurar a Autenticação Básica (Basic Auth) com o nome de usuário e senha escolhidos por você e aplicados no arquivo **src/main/resources/application.yaml** 


## Endpoints

Para consultar os endpoints acesse após executar a aplicação - [Swagger](http://localhost:8080/swagger-ui.html).

