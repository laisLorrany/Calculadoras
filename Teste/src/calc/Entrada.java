package calc;

import java.util.Scanner;

public class Entrada implements Runnable{
	
	/*
	 * Essa Thread � respons�vel por fazer a leitura dos operandos e operadores e chamar o m�todo para calcular.
	 * */
	
	private Operacao op;
	
	public Entrada(Operacao sentenca){
		this.op = sentenca;
	}
	
	public void run(){
		Scanner in = new Scanner(System.in);
		int a = 0, b = 0;
		char c = ' ';
				
		while (true){
			
			try{
				a = (in.nextInt());
				c = (in.next().charAt(0));
				b = (in.nextInt());
			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}

			op.setSentenca(a, b, c);
		}
	}

}
