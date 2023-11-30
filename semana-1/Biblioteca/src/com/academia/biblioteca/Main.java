package com.academia.biblioteca;

public class Main {

	public static void main(String[] args) {
		Livro livro1 = new Livro("Blade Runner", "Philip K. Dick", 210);
		Livro livro2 = new Livro("O Retorno do Rei", "J. R. R. Tolkien", 1955);
		
		System.out.println(livro1.getInformacoes());
		System.out.println(livro2.getInformacoes() + "\n");

		livro1.irParaPagina(211);
		System.out.println(livro1.getInformacoes());
		livro1.irParaPagina(0);
		System.out.println(livro1.getInformacoes());
		livro1.irParaPagina(210);
		System.out.println(livro1.getInformacoes());
		livro1.virarPagina();
		System.out.println(livro1.getInformacoes());
		livro1.retrocederPagina();
		System.out.println(livro1.getInformacoes() + "\n");
	}
}
