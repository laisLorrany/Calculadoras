package calc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operacao op = new Operacao();
		Entrada ent = new Entrada(op);
		Calcula calc = new Calcula(op);
		
		Thread t1 = new Thread(ent);
	    Thread t2 = new Thread(calc);

		t1.start();
		t2.start();
	
	}

}
