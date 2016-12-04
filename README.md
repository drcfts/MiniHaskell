# MiniHaskell
###Projeto 2
##Técnicas de Programação 1 ministrada pelo professor Rodrigo Bonifácio
###2/2016
#####Alunos 

Davi Rabbouni de Carvalho Freitas - 15/0033010

Henrique Brant de Moraes Palmeirão Alvarenga - 15/0011644

Marcos Vinícius Prescendo Tonin - 14/0153233

- [X] Primeira parte  

a) Novos tipos de expressão:(OK)

* subtração;(OK)

* divisão; (OK)

* and;(OK)

* or;(OK)

* not e;(OK) 

* operadores relacionais: ==, >, <, >=, <=.(OK)

b) Verificação de tipos  (Ok)

- lembrar que as funções devem ter os argumentos formais tipados (ok)

c) Testes unitarios: 90% de cobertura (ok)
#### Nota
Verificar Indentificador e 	AplicacaoFuncao (ok)

###### Forma de envio:
Enviar arquivo ZIP contendo o codigo fonte + testes unitários + arquivo README indicando a equipe. 
#### FIM da primeira parte ______________________________________________________________________
### Segunda parte 
- [ ] Segunda parte 

## TODO
a) Implementação do interpretador (3pts): 

* Programa que interpreta programas em MiniHaskell

#### exemplo

> loadFile("codigo.mhs") 

Esse comando carrega em memoria todas as declarações de funcoes descritas no arquivo codigo.mhs. Apos isso, deve ser possivel avaliar as expressões pelo prompt. 

> eval("1+1")

2

> eval("soma(2, 3)")

5

b) Implementar o suporte a listas na linguagem. Verificar o rascunho da solução no diagrama DesenhoLista. 

c) Implementar novas transformaciones de programas usando visitors. (OK, visitor,PrettyPrinter,Refactoring,Metrica implementados ... faltando apenas para as coisas Listas)

d) 90% de teste de cobertura

Voce, tem o direito de me convencer qua a sua implementação merece um SS na disciplina. 
t