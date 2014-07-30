import banco.*;


public class Principal {
	public static void main(String[] args) {
		System.out.println("Inicio");
		try{
		info();
		}catch(Exception erro){
			System.out.println("Erro --- "+ erro.getMessage() + " Classe:"+ erro.getClass());
		}
		
		Diretor d = new Diretor();
		d.salario = 1000;
		
		Gerente g = new Gerente();
		g.salario = 1000;
		
		ControleDeBonificacoes c = new ControleDeBonificacoes();
		c.registra(g);
		System.out.println(c.getTotalDeBonificacoes());

		c.registra(d);
		System.out.println(c.getTotalDeBonificacoes());
		
		try{
			
		}catch(Exception e){
			System.out.println("Erro -> " + e.getMessage());
		}
		
		
		try{
			System.out.println("--------------- # # # # ---------");			
			g.Salario();
			g.SalarioVezes(2);
			g.Salario();
			g.SalarioVezes(0);
			g.Salario();
			
			
		}catch(Exception erro){
			System.out.println("\n!ERRO => "  + erro.getMessage());			
		}
		
	}

	private static void info() throws Exception {
		
		Conta conta = new Conta();
		conta.deposita(100.0);
		int x = 2;
		int y = 2;
		double w = y / x;		 
//		System.out.println(Teste.Nome);
		
		System.out.println("valor W => " + w);
		System.out.println("Saldo:"+conta.getSaldo());
		throw new Exception("Teste Erro Davi");
	}
	

}
