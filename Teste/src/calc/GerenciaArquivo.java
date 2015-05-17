package calc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerenciaArquivo {
	
	public void leituraResultado(String id){
		/*
		 * Leitura do arquivo saida.txt para ver o resultado da operação escrita.
		 * */
		String conteudo = "";
		
		do {
			try {
				FileReader arquivo = new FileReader("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
						+ "\\calc\\resultados\\saida" + id + ".txt");
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
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
					+ "\\calc\\clientes\\entrada" + id + ".txt");
			PrintWriter escritor = new PrintWriter (arquivo, false);
			escritor.printf("%d %c %d",a, op, b);
			escritor.close();
			arquivo.close();
		} catch (IOException ioe){
			System.out.println(ioe.getMessage());			
		}
	}
	
	public String[] consultaSentenca(){
		
		String [] ar = new String [2];
		
		String conteudo = "";
		
		do{
			conteudo = leituraSentenca("entrada.txt");
			if (conteudo == "" ){
				conteudo = leituraSentenca("entrada2.txt");
				if (conteudo == "" ){
					conteudo = leituraSentenca("entrada3.txt");
					if (conteudo == "" ){
						conteudo = leituraSentenca("entrada4.txt");
						if (conteudo == "" ){
							conteudo = leituraSentenca("entrada5.txt");
							if(conteudo != ""){
								ar[1] = "5";
							}
						} else {
							ar[1] = "4";
						}
					}else {
						ar[1] = "3";
					}
				}else {
					ar[1] = "2";
				}
				
			}else {
				ar[1] = "";
			}
			
		}while(conteudo == "");
		
		ar[0] = conteudo;
		return ar;
	}
	
	public static String leituraSentenca (String arq){

		String conteudo = "";
		
		try {
			
			FileReader arquivo = new FileReader("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
					+ "\\calc\\clientes\\" + arq);
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
	
	public static void escreveResultado(int result, String id) {
		
		try{			
			FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src"
					+ "\\calc\\resultados\\saida" + id + ".txt");
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
