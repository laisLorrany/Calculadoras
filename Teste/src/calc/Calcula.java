package calc;

import java.util.Scanner;
import java.io.*;

public class Calcula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = 0;
		String conteudo = "";
		
		/*
		 * Leitura do arquivo entrada.txt para identificar qual a sentença a ser realizada.
		 * */
		while(true){
			
			conteudo = leituraSentenca();
			calculo(conteudo);
	
		}
	}
	
	public static String leituraSentenca (){
		
		String conteudo = "";
		
		do{
			try {
				
				FileReader arquivo = new FileReader("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\entrada.txt");
				BufferedReader leitor = new BufferedReader (arquivo);			
				while (leitor.ready()) {
					conteudo += leitor.readLine();
				}
				leitor.close();
				arquivo.close();	
				
			} catch (IOException ioe){
				System.out.println("Erro :" + ioe.getMessage());
			}
		}while(conteudo == "");
		
		limpaArquivo();
		return conteudo;
	}
	
	public static void calculo(String conteudo){

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
			
			escreve(result);
			
		} catch(Exception e){
			System.out.println("Erro Calculo:" + e.getMessage());
		}
		
		
	}
	
	public static void escreve(int result) {
		
		try{			
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\saida.txt");
			PrintWriter escritor = new PrintWriter (arquivo);
			escritor.printf("%d",result);
			escritor.close();
			arquivo.close();	
			
		}catch(IOException ioe){
			System.out.println("Erro Escreve:" + ioe.getMessage());
		}
	}
	
	public static void limpaArquivo(){
		try{			
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\entrada.txt");
			PrintWriter escritor = new PrintWriter (arquivo);
			escritor.printf("");
			escritor.close();
			arquivo.close();	
			
		}catch(IOException ioe){
			System.out.println("Erro Limpa:" + ioe.getMessage());
		}
	}

}
