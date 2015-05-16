package calc;

import java.util.Scanner;
import java.io.*;

public class EntradaDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
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
			 
			escreveArquivo(a, b, op);
			resultado();
			limpaArquivo();
			
		}
	}
	
	public static void escreveArquivo(int a, int b, char op){
		
		/*
		 * Escreve os operandos, operadores e operação no arquivo entrada.txt
		 * */
				
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\entrada.txt");
			PrintWriter escritor = new PrintWriter (arquivo, false);
			escritor.printf("%d %c %d",a, op, b);
			escritor.close();
			arquivo.close();
		} catch (IOException ioe){
			System.out.println(ioe.getMessage());			
		}
	}
	
	public static void resultado(){
		/*
		 * Leitura do arquivo saida.txt para ver o resultado da operação escrita.
		 * */
		String conteudo = "";
		
		do {
			try {
				FileReader arquivo = new FileReader("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\saida.txt");
				BufferedReader leitor = new BufferedReader (arquivo);	
				while (leitor.ready()) {
					conteudo = leitor.readLine();
				}
				leitor.close();
				arquivo.close();	
			} catch (IOException ioe){
				System.out.println(ioe.getMessage());			
			}

		}while(conteudo == "");

		System.out.print("Resultado: " +conteudo + "\n");
	}
	
	public static void limpaArquivo(){
		try{			
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\saida.txt");
			PrintWriter escritor = new PrintWriter (arquivo, false);
			escritor.printf("");
			escritor.close();
			arquivo.close();	
			
		}catch(IOException ioe){
			System.out.println("Erro Limpa:" + ioe.getMessage());
		}
	}

}
