
public class Principal {
	public static void main(String[] args) {
		int opcao;
		boolean verifica = false;
		float bruto, ir, inss, fgts;
		Folha folha = null;
		do {
			System.out.println("1 - Ler dados: ");
			System.out.println("2 - Calcular salario");
			System.out.println("3 - Sair");
			opcao = Console.readInt("Informe a opcao desejada: \n");
			switch (opcao) {
			case 1:
				folha = new Folha();
				folha.setNomeFuncionario(Console.readString("informe o nome do funcionario: "));
				folha.setMes(Console.readInt("Informe o mes: "));
				folha.setAno(Console.readInt("Informe o ano: "));
				folha.setNumHorasTrabalhadas(Console.readInt("Informe o numero de horas trabalhadas: "));
				folha.setValorHora(Console.readFloat("Valor da hora: \n"));
				verifica = true;
				break;
			case 2:
				if (verifica == true) {
					System.out.println("\n\n");
					System.out.println("Nome: " + folha.getNomeFuncionario());
					System.out.println("Mes: " +folha.getMes());
					System.out.println("Ano: " + folha.getAno());
					System.out.println("Horas trabalhadas: " + folha.getNumHorasTrabalhadas());
					System.out.println("Valor hora: " + folha.getValorHora());
					bruto = folha.calculaSalarioBruto();
					System.out.println("Salario bruto: " + bruto);
					ir = folha.calculaIR(bruto);
					System.out.println("Imposto de renda: " + ir);
					inss = folha.calculaINSS(bruto);
					System.out.println("INSS: " + inss);
					fgts = folha.calculaFGTS(bruto);
					System.out.println("FGTS: " + fgts);
					System.out.println("Salario liquido: " + folha.calculaSalarioLiquido(bruto, ir, inss));
					break;
				} else {
					System.out.println("\n");
					System.out.println("Para calcular o salario e necessario ter informado os dados anteriormente!");
				}
			}
		} while (opcao != 3);
	}
}
