package folhaDePagamentoOO_v3;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	static List<Folha> folhas = new ArrayList<Folha>();
	public static void main(String[] args) {
		int opcao;
		float bruto, ir, inss, fgts, salarioLiquido, total;
		Folha folha = null;
		do {
			System.out.println("****MENU****");
			System.out.println("1 - Cadastro da folha");
			System.out.println("2 - Consultar folha");
			System.out.println("3 - Listar folha");
			System.out.println("4 - Sair");
			opcao = Console.readInt("Informe a opcao desejedada: ");
			linha();
			switch (opcao) {
			case 1: 
				folha = new Folha();
				System.out.println("****CADASTRO DE FOLHA****");
				folha.setNomeFuncionario(Console.readString("Infome o nome do funcionario: "));
				folha.setAno(Console.readInt("Infome o ano: "));
				folha.setMes(Console.readInt("Infome o mes: "));
				if (buscarFolha(folha) == null) {
					folha.setNumHorasTrabalhadas(Console.readInt("Informe o numero de horas trabalhadas: "));
					folha.setValorHora(Console.readFloat("Informe o valor da hora: "));
					incluirFolha(folha);
					linha();
				} else {
					System.out.println("Folha ja cadastrada!!");
					linha();
					}
				break;
			case 2:
				System.out.println("****CONSULTAR FOLHA****");
				folha = new Folha();
				folha.setNomeFuncionario(Console.readString("Infome o nome do funcionario que deseja consultar: "));
				folha.setAno(Console.readInt("Infome o ano: "));
				folha.setMes(Console.readInt("Infome o mes: "));
				linha();
				folha = buscarFolha(folha);
				if (folha != null) {
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
					salarioLiquido = folha.calculaSalarioLiquido(bruto, ir, inss);
					System.out.println("Salario liquido: " + salarioLiquido);
					linha();
				} else {
					System.out.println("Para consultar a folha e necessario ter informado os dados anteriormente!");
					linha();
				}
				break;
			case 3:
				List<Folha> resultadoBusca = new ArrayList<Folha>();
				folha = new Folha();
				folha.setAno(Console.readInt("informe o ano: "));
				folha.setMes(Console.readInt("Informe o mes: "));
				total = 0;
				resultadoBusca = listarFolhasMesAno(folha);
				for(Folha itemFolha: resultadoBusca) {
					System.out.println("Nome do Funcionario: " + itemFolha.getNomeFuncionario());
					bruto = itemFolha.calculaSalarioBruto();
					ir = itemFolha.calculaIR(bruto);
					inss = itemFolha.calculaINSS(bruto);
					salarioLiquido = itemFolha.calculaSalarioLiquido(bruto, ir, inss);
					System.out.println("Salario liquido: " + salarioLiquido);
					linha();
					total += salarioLiquido;
				}
				System.out.println("Total: " + total);
				linha();
			}	
		} while (opcao != 4);
	}
	
	private static void linha() {
		System.out.println("--------------------------------------------");
	}
	
	private static void incluirFolha(Folha folha) {
		folhas.add(folha);
	}
	
	private static Folha buscarFolha(Folha folha) {
		for(Folha itemFolha: folhas) {
			if(itemFolha.getNomeFuncionario().equals(folha.getNomeFuncionario()) && itemFolha.getAno() == folha.getAno() && itemFolha.getMes() == folha.getMes()) {
				return itemFolha;
			}
		}
		return null;
	}
	
	private static ArrayList<Folha> listarFolhasMesAno(Folha folha ){
		List<Folha> folhasMesAno = new ArrayList<Folha>(); 
			for(Folha itemFolha: folhas) {
				if(itemFolha.getMes() == folha.getMes() && itemFolha.getAno() == folha.getAno()) {
					folhasMesAno.add(itemFolha);
				}
			} 
			return (ArrayList<Folha>) folhasMesAno;
	}
}