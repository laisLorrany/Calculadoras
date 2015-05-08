package calc;

import java.util.Scanner;
import java.io.*;

public class EntradaDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = 0, b = 0;
		char op = ' ';
		String conteudo = null;
		
		while (true){
			try{
				System.out.println("Calculadora:");
				System.out.println("Digite o primeiro algarismo:");
				a = in.nextInt();
				System.out.println("Digite a operação desejada:");
				op = in.next().charAt(0);
				System.out.println("Digite o segundo algarismo:");
				b = in.nextInt();
			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}
			
			try {
				FileWriter arquivo = new FileWriter("C:\\Users\\Lorrany\\git\\teste\\Teste\\src\\calc\\entrada.txt");
				PrintWriter escritor = new PrintWriter (arquivo);
				escritor.printf("%d %c %d",a, op, b);
				escritor.close();
				arquivo.close();
			} catch (IOException ioe){
				System.out.println(ioe.getMessage());			
			}
			
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
			
			if (conteudo != null){
				String [] cont = conteudo.split(" ");
				int resp = Integer.parseInt(cont[0]);
				System.out.print(resp);
			}
		}
	}

}
