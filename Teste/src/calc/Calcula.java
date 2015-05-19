package calc;

public class Calcula implements Runnable{

	/*
	 * Essa Thread é responsável por fazer a solicitação da operação e exibir o resultado.
	 * */
	
	private Operacao op, aux;
	
	public Calcula(Operacao sentenca){
		this.op = sentenca;
	}
	
	public void run(){
		
		while (true){
			
			/*
			 * Trecho que chamará a função do cálculo.
			 * */
			
			aux = op.getSentenca();
			int res; 
				
			if(aux.getOp() == '+'){
				res = aux.somar();
			} else if (aux.getOp() == '-'){
				res = aux.subtrair();			
			} else if(aux.getOp() == '*') {
				res = aux.multiplicar();			
			} else {
				res = aux.dividir();
			}
				
			/*
			 * Impressão do resultado.
			 * */
			System.out.printf("Resultado: %d\n", res);
		}
	
	}

}