# Projeto Integrado 3º Semestre FATEC-ZL 2021-1

#### Integrantes do grupo:
- Ana Beatriz Barbosa Alves R.A.: 1110482113012
- Arthur Viveiros R.A.: 1110482012024
- Cesar Augusto Dos Santos Vizentini R.A.: 1110481913010
- Lucas Rufino Maiellaro R.A.: 1110482012003

#### Disciplinas:
- Engenharia de Software II - Profª Cristina Corrêa De Oliveira
- Estruturas de Dados - Profº Fábio Pereira da Silva

## Buffet de festas infantis da Rafaela 

![Logotipo](https://i.imgur.com/UZn4nSh.png)

#### Problemática
Rafaela possui vários temas de festas infantis para aluguel. Ela precisa controlar os aluguéis e para isso quer uma aplicação que permita cadastrar: o nome e o telefone do cliente, o endereço completo da festa, o tema escolhido, a data da festa, a hora de início e término da festa. Além disso, para alguns clientes antigos, Rafaela oferece descontos. Sendo assim, é preciso saber o valor realmente cobrado num determinado aluguel.

#### Funcionalidades:
- [x] CRUD Cliente 
- [x] CRUD Tema 
- [x] CRUD Festa
- [x] Receita de um período

#### Getting started
##### Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [Java SE: Necessário para executar o projeto Java](https://www.oracle.com/br/java/technologies/javase-downloads.html)
- [Eclipse IDE: Para desenvolvimento do projeto](https://www.eclipse.org/downloads/)

##### Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/cesarVizentini/Projeto-ED.git
```

##### Configuração

Para executar o projeto, é necessário utilizar o Eclipse, para que o mesmo identifique as dependências necessárias para a execução. Uma vez importado o projeto, será criado um arquivo *.classpath* que irá informar qual a classe principal para a execução. Nesse projeto, estamos utilizando o jcalendar para poder trabalhar com calendários, porém, caso aconteça um erro ao rodar a aplicação pela primeira vez, será necessário adicionar 4 libraries no *.classpath*. 
Para fazer isso é só seguir esses passos:
1. Clicar com o botão direito do mouse no projeto 
![Botão Direito no projeto](https://i.imgur.com/McZtNhT.png)
2. Clicar em Build Path e Configure Build Path 
![Clicar em Build Path e Configure Build Path](https://i.imgur.com/1EuAArO.png)
3. Clicar em Libraries 
![Clicar em Libraries](https://i.imgur.com/GF7R0AB.png)
4. Clicar em Classpath e add external jars 
![Clicar em Classpath e add external jars](https://i.imgur.com/4q5lKCv.png)
5. Localizar as 4 dependências na pasta /lib/ 
![Localizar as 4 libraries na pasta /lib/](https://i.imgur.com/D0cldnj.png)
6. Selecionar as libs e clicar em abrir
![Selecionar as libs e clicar em abrir](https://i.imgur.com/4RNwdaI.png)
7. Clicar em apply and close
![Clicar em apply and close](https://i.imgur.com/07jPUnw.png)
8. Rodar o projeto novamente
![Rodar o projeto novamente](https://i.imgur.com/qERNxQi.png)

Esperamos que gostem do nosso projeto :smile: