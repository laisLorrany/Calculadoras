package calc;

public class Operacao {
	
	private int a, b;
	private char op;	
	private boolean condicao = false;
	
	
	public Operacao() {
		this.a = 0;
		this.b = 0;
		this.op = ' ';
	}

	public Operacao(int num1, int num2, char op) {
		this.a = num1;
		this.b = num2;
		this.op = op;
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
	
	public boolean isCondicao() {
		return condicao;
	}

	public void setCondicao(boolean condicao) {
		this.condicao = condicao;
	}
	
	public void verificaCondicao(){
		if ((this.getA() == 0) && (this.getA() == 0) && (this.getOp() == ' ')){
			setCondicao(false);
		} else {
			setCondicao(true);
		}
	}

	public int somar (){
		System.out.println("+");
		return this.a + this.b;
	}
	
	public int subtrair (){
		System.out.println("-");
		return this.a - this.b;
	}
	
	public int multiplicar (){
		System.out.println("*");
		return this.a * this.b;
	}
	
	public int dividir (){
		System.out.println("/");
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
	
	public synchronized void consomeSentenca() {
		System.out.println("consome1");
	    while (this.condicao == false) {
    		System.out.println("consome2");
	        try {
	            //wait for Producer to put value
	    		System.out.println("consome3");
	            wait();
	    		System.out.println("consome4");
	        } catch (InterruptedException e) { 
	        	System.out.println(e.getMessage());
	        }
	    }
	    System.out.println("Resultado: " + calculo());
	    this.condicao = false;
	    //notify Producer that value has been retrieved
	    notifyAll();
	}
	
	public synchronized void produzSentenca() {
		System.out.println("produz1");
	    while (this.condicao == true) {
	        try {
	            //wait for Consumer to get value
	    		System.out.println("produz2");
	    		notifyAll();
	    		System.out.println("produz3");
	            wait();
	        } catch (InterruptedException e) {
	        	System.out.println(e.getMessage());
	        }
	    }

		System.out.println("produz4");
	    this.condicao = true;
	    //notify Consumer that value has been set
	    notifyAll();
		System.out.println("produz5");
	    
	}

	
}
