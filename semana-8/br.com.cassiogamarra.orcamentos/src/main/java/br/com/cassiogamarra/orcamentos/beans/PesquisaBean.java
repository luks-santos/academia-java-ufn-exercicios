package br.com.cassiogamarra.orcamentos.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cassiogamarra.orcamentos.entities.Orcamento;
import br.com.cassiogamarra.orcamentos.repositories.OrcamentoRepository;

@ManagedBean
@RequestScoped
public class PesquisaBean {
	private String mensagem;
	private String entrada;
	
	OrcamentoRepository orcamentoRepository = new OrcamentoRepository();
	
	@PostConstruct
	public void init() {
		orcamentoRepository.setup();
	}
	
	public void processarFormulario() {
		Orcamento orcamento = orcamentoRepository.buscarPorCliente(entrada);
		String sobremesa = orcamento.getIndSobremesa() ? "(com sobremesa)" : "(sem sobremesa)";
		mensagem = "O orçamento do cliente "+orcamento.getNomeCliente()
		+" com "+orcamento.getNumConvidados()+" convidados "+sobremesa+" ficou: "
		+ "Valor dos convidados: R$"+orcamento.getVlConvidados()
		+ "Taxa de sobremesa: R$"+orcamento.getTxSobremesa()
		+ "Número de garçons: "+orcamento.getQtdGarcons()
		+ "Taxa dos garçons: R$"+orcamento.getTxGarcons()
		+ "Valor total: R$" + orcamento.getVlTotal();
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getEntrada() {
		return entrada;
	}
	
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
}
