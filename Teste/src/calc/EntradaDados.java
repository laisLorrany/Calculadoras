

import java.util.Scanner;

public class EntradaDados {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		GerenciaArquivo gArquivo = new GerenciaArquivo();
		int a = 0, b = 0;
		char op = ' ';
		
		while (true){
			/*
			 * Entrada de Dados para Calculadora
			 * */
			try{
				System.out.println("\n	Calculadora:");
				System.out.println("Digite o primeiro algarismo:");
				a = in.nextInt();
				System.out.println("Digite a operação desejada:");
				op = in.next().charAt(0);
				System.out.println("Digite o segundo algarismo:");
				b = in.nextInt();
			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}
			 
			gArquivo.escreveOperacao(a, b, op, "");
			gArquivo.leituraResultado("");
			gArquivo.limpaArquivo(0);
			
		}
	}
	
}

