package calc;

public class Calcula implements Runnable{

	/*
	 * Essa Thread � respons�vel por fazer a solicita��o da opera��o e exibir o resultado.
	 * */
	
	private Operacao op, aux;
	
	public Calcula(Operacao sentenca){
		this.op = sentenca;
	}
	
	public void run(){
		
		while (true){
			
			/*
			 * Trecho que chamar� a fun��o do c�lculo.
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
			 * Impress�o do resultado.
			 * */
			System.out.printf("Resultado: %d\n", res);
		}
	
	}

}