package calc;

public abstract class Operacao {
	
	float val1, val2, result;
	
	public Operacao (){		
		this(0,0,0);
	}

	public Operacao(float val1, float val2, float result) {
		// TODO Auto-generated constructor stub
		this.val1 = val1;
		this.val2 = val2;
		this.result = result;
	}

	public float getVal1() {
		return val1;
	}

	public void setVal1(float val1) {
		this.val1 = val1;
	}

	public float getVal2() {
		return val2;
	}

	public void setVal2(float val2) {
		this.val2 = val2;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}
	
	public abstract void calculo();

}
