package calc;

import java.util.Scanner;

public class Entrada implements Runnable{
	
	private Operacao op;
	private int id;
	
	public Entrada(Operacao sentenca, int id){
		this.op = sentenca;
		this.id = id;
	}
	
	public void run(){
		Scanner in = new Scanner(System.in);
				
		while (true){
			/*
			 * Entrada de Dados para Calculadora
			 * */
			System.out.println("here");
			try{
				System.out.println("\n	Calculadora:");
				System.out.println("Digite o primeiro algarismo:");
				op.setA(in.nextInt());
				System.out.println("Digite a operação desejada:");
				op.setOp(in.next().charAt(0));
				System.out.println("Digite o segundo algarismo:");
				op.setB(in.nextInt());
				op.setCondicao(true);
			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}

			op.produzSentenca();
		}
	}

}
