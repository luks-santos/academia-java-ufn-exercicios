package com.academia.biblioteca;
public class Livro {
	
	private String titulo;
	private String autor;
	private int nroPaginas;
	private int paginaAtual;
	
	public Livro(String titulo, String autor, int nroPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.nroPaginas = nroPaginas;
		this.paginaAtual = 1;
	}
	
	public void virarPagina() {
		if(paginaAtual < nroPaginas) paginaAtual++;
	}
	
	public void retrocederPagina() {
		if(paginaAtual > 1) paginaAtual--;
	}
	
	public void irParaPagina(int pagina) {
		if(pagina >= 1 && pagina <= nroPaginas) {
			paginaAtual = pagina;
		}
	}

	public String getInformacoes() {
		return "Livro Título: [" + titulo + "], Autor: [" + autor + "], Páginas [" + nroPaginas + "], Página Atual: ["
				+ paginaAtual + "]";
	}
}
