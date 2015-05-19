package calc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerenciaArquivo {
	
	public void escreveLog(int a, int b, char op, int res, String date){
		
		try {
			String descricao = "Operação: " + a + " "+ op + " "+ b +" = " + res +"  "
					+ "Data e Hora: " + date;
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
					+ "\\calc\\log.txt");
			PrintWriter escritor = new PrintWriter (arquivo, true);
			escritor.printf("%s", descricao);
			escritor.close();
			arquivo.close();
		} catch (IOException ioe){
			System.out.println(ioe.getMessage());			
		}
		
	}
	
	public int leituraResultado(){
		/*
		 * Leitura do arquivo saida.txt para ver o resultado da operação escrita.
		 * */
		String conteudo = "";
		
		do {
			try {
				FileReader arquivo = new FileReader("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
						+ "\\calc\\saida.txt");
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

		return Integer.parseInt(conteudo);
	}
	
	public void escreveOperacao(int a, int b, char op){
		
		/*
		 * Escreve os operandos, operadores e operação no arquivo entrada.txt
		 * */
				
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
					+ "\\calc\\entrada.txt");
			PrintWriter escritor = new PrintWriter (arquivo, false);
			escritor.printf("%d %c %d",a, op, b);
			escritor.close();
			arquivo.close();
		} catch (IOException ioe){
			System.out.println(ioe.getMessage());			
		}
	}
		
	public static String leituraSentenca (){

		String conteudo = "";
		
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
		
		return conteudo;
	}
	
	public static void escreveResultado(int result) {
		
		try{			
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
					+ "\\calc\\saida.txt");
			PrintWriter escritor = new PrintWriter (arquivo);
			escritor.printf("%d",result);
			escritor.close();
			arquivo.close();	
			
		}catch(IOException ioe){
			System.out.println("Erro Escreve:" + ioe.getMessage());
		}
	}
	
	public static void limpaArquivo(String arq){
		try{			
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\" + arq);
			PrintWriter escritor = new PrintWriter (arquivo);
			escritor.printf("");
			escritor.close();
			arquivo.close();	
			
		}catch(IOException ioe){
			System.out.println("Erro Limpa:" + ioe.getMessage());
		}
	}
	
}
