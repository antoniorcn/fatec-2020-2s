package edu.curso;

public class Monitor {
	    public String marca;
	    public Double polegadas;
	    public String resolucao;
	    public Boolean estaLigado;
	    public Boolean ehUsado;
	    
	    public void ligar() {
	        this.estaLigado = true;
	    }

	    public void desligar() {
	        this.estaLigado = false;
	    }

	    public void mudarResolucao(String resolucao) {
	        this.resolucao = resolucao;
	    }
	    
	    public String mostrarDadosMonitor() { 
	    	return String.format("Monitor:  %s,  Resolução: %s,  Está Ligado: %s",
	    			marca, resolucao, estaLigado);
	    }
}
