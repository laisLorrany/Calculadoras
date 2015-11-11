

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;

public class GerenciaArquivo {
	
	static String entrada;
	private static String saida;
	
	public void criarArquivo(){
		
		int id = Integer.parseInt(ManagementFactory.getRuntimeMXBean()
			 .getName().split("@")[0]);

		File dir = new File("Entrada" + String.format("%d", id));

		dir.mkdir();
	
		this.entrada = dir.getName() + "\\entrada.txt";
		this.setSaida(dir.getName() + "\\saida.txt");
		
	}
	
	public void leituraResultado(String id){
		/*
		 * Leitura do arquivo saida.txt para ver o resultado da operação escrita.
		 * */
		String conteudo = "";
		
		do {
			try {
				FileReader arquivo = new FileReader(getSaida());
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
	
	public void escreveOperacao(int a, int b, char op, String id){
		
		/*
		 * Escreve os operandos, operadores e operação no arquivo entrada.txt
		 * */
				
		try {
			FileWriter arquivo = new FileWriter(entrada);
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
			
			FileReader arquivo = new FileReader(entrada);
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
			FileWriter arquivo = new FileWriter(getSaida());
			PrintWriter escritor = new PrintWriter (arquivo);
			escritor.printf("%d",result);
			escritor.close();
			arquivo.close();	
			
		}catch(IOException ioe){
			System.out.println("Erro Escreve:" + ioe.getMessage());
		}
	}
	
	public static void limpaArquivo(int op){
		try{			
			if(op == 1){
				FileWriter arquivo = new FileWriter(entrada);
				PrintWriter escritor = new PrintWriter (entrada);
				escritor.printf("");
				escritor.close();
				arquivo.close();	
			} else {
				FileWriter arquivo = new FileWriter(saida);
				PrintWriter escritor = new PrintWriter (saida);
				escritor.printf("");
				escritor.close();
				arquivo.close();	
			}
			
		}catch(IOException ioe){
			System.out.println("Erro Limpa:" + ioe.getMessage());
		}
	}

	public static String getSaida() {
		return saida;
	}

	public static void setSaida(String saida) {
		GerenciaArquivo.saida = saida;
	}
	
}
