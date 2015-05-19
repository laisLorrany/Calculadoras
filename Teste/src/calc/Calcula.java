package calc;

import java.util.Scanner;
import java.io.*;

public class Calcula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GerenciaArquivo gArquivo = new GerenciaArquivo();
		int result = 0;
		String conteudo = "";
		
		/*
		 * Leitura do arquivo entrada.txt para identificar qual a sentença a ser realizada.
		 * */
		while(true){
			
			do{
				conteudo = gArquivo.leituraSentenca();
			}while(conteudo == "");
			gArquivo.limpaArquivo("entrada.txt");
			calculo(conteudo, gArquivo);
	
		}
	}
	
	public static void calculo(String conteudo, GerenciaArquivo gArquivo){

		try{		
			
			int a = 0, b = 0;
			Operacao operacao = new Operacao();
			char op = ' ';
			String [] cont;
			int result = 0;
			
			cont = conteudo.split(" ");
			a = Integer.parseInt(cont[0]);
			op = cont[1].charAt(0);
			b = Integer.parseInt(cont[2]);
			
			switch (op){
				case '+' :	result = operacao.Somar(a, b);
					break;
				case '-' :	result = operacao.Subtrair(a, b);
					break;
				case '*' :	result = operacao.Multiplicar(a, b);
					break;
				case '/' :	result = operacao.Dividir(a, b);
					break;
				default :	System.out.println("Operação incorreta.");
					break;
			}
			
			gArquivo.escreveResultado(result);
			
		} catch(Exception e){
			System.out.println("Erro Calculo:" + e.getMessage());
		}		
		
	}

}