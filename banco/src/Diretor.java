
public class Diretor extends Gerente {

	@Override
	public double getBonificacao() {
		// TODO Auto-generated method stub
		return super.getBonificacao() + 2;
		//return this.salario * 3;
	}
	

}
