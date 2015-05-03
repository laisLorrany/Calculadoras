package calc;

import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Operacao op = null;
		int opcao = 5;		
		
		do{

			try {
				System.out.println("Calculadora:");
				System.out.println("Operações: \nsomar (1) \nsubtrair (2) \nmultiplicar (3) \ndividir (4) \nsair(5)");			
				opcao = in.nextInt();
				if ((opcao < 5 ) && (opcao > 0)){			
					switch (opcao){
						case 1 :	op = new Soma();
							break;
						case 2 :	op = new Subtracao();
							break;
						case 3 :	op = new Multiplicacao();
							break;
						case 4 :	op = new Divisao();
							break;
						default :	System.out.println("Operação incorreta.");
					}		
					System.out.println("Digite o primeiro algarismo:");
					op.setVal1(in.nextFloat());
					System.out.println("Digite o segundo algarismo:");
					op.setVal2(in.nextFloat());
					op.calculo();
					System.out.printf("O resultado é: %.3f", op.getResult());
					
					Calendar c = Calendar.getInstance();
					Date data = c.getTime();
					DateFormat formataData = DateFormat.getDateInstance();
					String date = (formataData.format(data));
					DateFormat formataHora = DateFormat.getTimeInstance();
					String hora = (formataHora.format(data));
					System.out.println(hora);
					
					//escrita no arquivo
					FileWriter arquivo = new FileWriter("C:\\registro.txt",true);
					PrintWriter escritor = new PrintWriter (arquivo, true);
					escritor.println("Operando 1: " + op.getVal1() + ", Operando 2: " + op.getVal2() +
							", Resultado:" + op.getResult() + ", Data: " + date + ", hora: " + hora);
					escritor.close();
					arquivo.close();
					}
			}catch(IOException ioe){
				System.out.println("Erro:" + ioe.getMessage());
			}
			catch(Exception e){
				System.out.println("Erro:" + e.getMessage());
			}
			
		}while (opcao != 5);
		
		in.close();
	
	}

}
