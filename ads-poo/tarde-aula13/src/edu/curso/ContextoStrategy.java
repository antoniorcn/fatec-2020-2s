package edu.curso;

import edu.curso.strategy.Strategy;
import edu.curso.strategy.StrategyAlgoritmoA;
import edu.curso.strategy.StrategyAlgoritmoB;
import edu.curso.strategy.StrategyAlgoritmoC;

public class ContextoStrategy {
	
	private Strategy strategy;
	
	public void executar() { 
		strategy.algoritmo();
	}

	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public static void main(String[] args) {
		// TesteAlgoritmo ts = new TesteAlgoritmo();
		// ts.executar(0);
		// ts.executar(1);
		
		Strategy algA = new StrategyAlgoritmoA();
		Strategy algB = new StrategyAlgoritmoB();
		Strategy algC = new StrategyAlgoritmoC();
		
		ContextoStrategy ctx = new ContextoStrategy();
		
		ctx.setStrategy(algB);
		
		ctx.executar();
		
	}

}
