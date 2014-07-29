
public class Gerente extends Funcionario implements IRecebeSalario {
	public double getBonificacao(){
		return this.salario * 1.4 + 1000;
	}

	@Override
	public void Salario() {
		// TODO Auto-generated method stub
		System.out.println("Salário é R$" + String.format("%.2f", this.salario));		
	}

	@Override
	public void SalarioVezes(int vezes) throws Exception {
		// TODO Auto-generated method stub
		if(vezes > 0 ){
			this.salario = this.salario * vezes;
		}else{
			throw new ExceptionDavi();
		}			
	}

}
