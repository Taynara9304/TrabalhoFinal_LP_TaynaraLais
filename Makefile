all: build run

cadastro:
	@git config --global user.email "20233007175@estudantes.ifpr.edu.br"
	@git config --global user.name "LaisMayer"

build:
	@javac -d bin Main.java
	@javac -d bin aulas/*.java

run: build
	@java -cp bin Main

clear:
	@rm -r bin
