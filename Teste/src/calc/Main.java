package calc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operacao op = new Operacao();
		Entrada ent = new Entrada(op, 1);
		Calcula calc = new Calcula(op, 1);
		
		Thread t1 = new Thread(ent);
	    Thread t2 = new Thread(calc);

		System.out.println("t1");
		t1.start();
		System.out.println("t2");
		t2.start();
	
	}

}
