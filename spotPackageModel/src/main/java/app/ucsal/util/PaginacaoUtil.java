package app.ucsal.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PaginacaoUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> listaPagina;
	
	private Integer numeroRegistroPorPagina;
	
	private Integer numeroRegistroTotal;
	
	private Integer apartirDoRegistro;
	
	private Integer numeroPagina;
	
	private Integer paginaAtual;
	
	public PaginacaoUtil() {
		
	}

	public PaginacaoUtil(Integer numeroRegistro, Integer numeroRegistroPorPagina) {		
		
		this.numeroRegistroTotal = numeroRegistro;
		
		this.numeroRegistroPorPagina = numeroRegistroPorPagina;
		
		this.numeroPagina = this.numeroRegistroTotal / this.numeroRegistroPorPagina;
		
		//Caso o resto da divisão seja maior que um, se adiciona mais um
		if (this.numeroRegistroTotal % this.numeroRegistroPorPagina > 0
				&& (this.numeroPagina * this.numeroRegistroPorPagina) < this.numeroRegistroTotal){
			this.numeroPagina++;
		} 
		
		this.listaPagina = new ArrayList<Integer>();
		
		int paginas = this.numeroPagina > 10 ? 10 : this.numeroPagina;
		
		for (int i = 1; i <= paginas; i++){
			this.listaPagina.add(i);
		}		
				
		this.apartirDoRegistro = 1;
				
		this.paginaAtual = 1;
		
	}
	
	public void retrocederPagina(){
		
		if (this.paginaAtual > 1){
			this.paginaAtual--; 
			if (this.numeroPagina > 10 && this.paginaAtual >= 1){
				
				int inicio = this.listaPagina.get(0);
				int fim = this.listaPagina.get(this.listaPagina.size() - 1);
				
				if (inicio >= 2){
					this.listaPagina.clear();
					
					for (int i = inicio - 1; i <= fim - 1; i++){
						this.listaPagina.add(i);
					}
				}
			}
			
		}
		
	}
	
	public void paginar(){
			
		if (this.numeroPagina > 10){
			
			int inicio = this.listaPagina.get(0);
			int fim = this.listaPagina.get(this.listaPagina.size() - 1);
						
			if (inicio == this.paginaAtual 
					&& inicio > 1){
				
				this.listaPagina.clear();
				
				for (int i = inicio - 1; i <= fim - 1; i++){
					this.listaPagina.add(i);
				}
			} else if (fim == this.paginaAtual 
					&& fim < this.numeroPagina){
				
				this.listaPagina.clear();
				
				for (int i = inicio + 1; i <= fim + 1; i++){
					this.listaPagina.add(i);
				}
			}
		}
		
		
	}
	
	public void avancarPagina(){
		
		if (this.paginaAtual < this.numeroPagina){
			
			this.paginaAtual++; 
			
			if (this.numeroPagina > 10 && this.paginaAtual < this.numeroPagina){
				
				int inicio = this.listaPagina.get(0);
				int fim = this.listaPagina.get(this.listaPagina.size() - 1);
				
				if (fim < this.numeroPagina){
					this.listaPagina.clear();
					
					for (int i = inicio + 1; i <= fim + 1; i++){
						this.listaPagina.add(i);
					}
				}
				
			} 
		}
	}
	
	public List<Integer> getListaPagina() {
		return listaPagina;
	}

	public void setListaPagina(List<Integer> listaPagina) {
		this.listaPagina = listaPagina;
	}
		
	public Integer getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(Integer paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public Integer getNumeroRegistroPorPagina() {
		return numeroRegistroPorPagina;
	}

	public void setNumeroRegistroPorPagina(Integer numeroRegistroPorPagina) {
		this.numeroRegistroPorPagina = numeroRegistroPorPagina;
	}

	public Integer getNumeroRegistroTotal() {
		return numeroRegistroTotal;
	}

	public void setNumeroRegistroTotal(Integer numeroRegistroTotal) {
		this.numeroRegistroTotal = numeroRegistroTotal;
	}

	public Integer getApartirDoRegistro() {
		
		if (this.paginaAtual > 1){
						
			this.apartirDoRegistro = (this.paginaAtual * this.numeroRegistroPorPagina) - this.numeroRegistroPorPagina;
						
		} else {
			
			this.apartirDoRegistro = 0;
			
		}
		
		return apartirDoRegistro;
		
	}

	public void setApartirDoRegistro(Integer apartirDoRegistro) {
		this.apartirDoRegistro = apartirDoRegistro;
	}

	public Integer getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
}

