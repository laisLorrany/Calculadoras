package calc;

import java.util.Scanner;
import java.io.*;

public class Calcula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 0, b = 0, result = 0;
		char op = ' ';
		String conteudo = "";
		String [] cont;
		Operacao operacao = new Operacao();
		
		while(true){
			
			try {
				FileReader arquivo = new FileReader("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\entrada.txt");
				BufferedReader leitor = new BufferedReader (arquivo);			
				while (leitor.ready()) {
					conteudo += leitor.readLine();
				}
				leitor.close();
				arquivo.close();	
				
			} catch (IOException ioe){
				System.out.println("Erro:" + ioe.getMessage());
			}
			
			try{
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
			} catch(Exception e){
				System.out.println("Erro:" + e.getMessage());
			}
			
			try{			
				FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\saida.txt");
				PrintWriter escritor = new PrintWriter (arquivo);
				escritor.printf("%d",result);
				escritor.close();
				arquivo.close();	
				
			}catch(IOException ioe){
				System.out.println("Erro:" + ioe.getMessage());
			}
		
		}
	}

}
