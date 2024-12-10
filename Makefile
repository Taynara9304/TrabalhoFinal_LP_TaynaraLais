all: build run

cadastro:
	@git config --global user.email "taynaradasilva2001@gmail.com"
	@git config --global user.name "Taynara"

build:
	@javac -d bin Main.java
	@javac -d bin aulas/*.java

run: build
	@java -cp bin Main

clear:
	@rm -r bin
