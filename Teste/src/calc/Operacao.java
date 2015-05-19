package calc;

public class Operacao {
	
	/*
	 * Classe que compõe a operação e seus métodos.
	 * */
	
	private int a, b;
	private char op;	
	private boolean disponivel = false;
	
	
	public Operacao() {
		disponivel = true;
	}

	public int getA() {
		return a;
	}

	public void setA(int num1) {
		this.a = num1;
	}

	public int getB() {
		return b;
	}

	public void setB(int num2) {
		this.b = num2;
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
		this.op = op;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}

	public int somar (){
		return this.a + this.b;
	}
	
	public int subtrair (){
		return this.a - this.b;
	}
	
	public int multiplicar (){
		return this.a * this.b;
	}
	
	public int dividir (){
		return this.a / this.b;
	}
	
	public int calculo(){
		int res; 
		
		if(this.op == '+'){
			res = somar();
		} else if (this.op == '-'){
			res = subtrair();			
		} else if(this.op == '*') {
			res = multiplicar();			
		} else {
			res = dividir();
		}
		
		return res;
	}	
	
	public synchronized void setSentenca(int a, int b, char op) {

	    while (disponivel == false) {

	        try {
	            wait();
	        } catch (InterruptedException e) { 
	        	System.out.println(e.getMessage());
	        }
	    }
	    setA(a);
	    setB(b);
	    setOp(op);
	    disponivel = false;
	    notifyAll();
	}
	
	public synchronized Operacao getSentenca() {
	    
		while (this.disponivel == true) {
	        try {
	            wait();
	        } catch (InterruptedException e) {
	        	System.out.println(e.getMessage());
	        }
	    }

	    disponivel = true;
	    notifyAll();
	    
	    return this;
	}

	
}
