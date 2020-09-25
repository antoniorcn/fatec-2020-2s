package edu.curso;

public class Matematica<T extends Number> {
	
	public double somar(T a, T b) {
		return a.doubleValue() + b.doubleValue();
	}

}
