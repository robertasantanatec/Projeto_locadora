Projeto: Sistemas de Locadora de Filme
Estrutura:
src/locadora/model - classes: Filme, Locacao, Conta, Cliente
src/locadora/app - classe Principal (ponto de entrada)

Compilar:
from project root:
javac -d out src/locadora/model/*.java src/locadora/app/*.java
executar:
java -cp out locadora.app.Principal
