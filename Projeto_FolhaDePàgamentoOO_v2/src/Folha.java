
public class Folha {
	private String nomeFuncionario;
	private int mes;
	private int ano;
	private int numHorasTrabalhadas;
	private float valorHora;
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setNumHorasTrabalhadas(int numHorasTrabalhadas) {
		this.numHorasTrabalhadas = numHorasTrabalhadas;
	}
	
	public int getNumHorasTrabalhadas() {
		return numHorasTrabalhadas;
	}
	
	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}
	
	public float getValorHora() {
		return valorHora;
	}
	
	public float calculaSalarioBruto() {
		return valorHora * numHorasTrabalhadas;
	}
	
	public float calculaIR(float bruto) {
		if (bruto <= 1372.81) 
			return 0;
		else 
		if (bruto <= 2743.25) 
			return (float) ((bruto * .15) - 205.92);
		else 
			return (float) ((bruto * .275) - 548.82);
	}
	
	public float calculaINSS(float bruto) {
		if (bruto <= 868.29) 
			return (float) (bruto * 0.08);
		else 
		if (bruto < 1447.14) 
			return (float) (bruto * 0.09);
		else 
		if (bruto < 2894.28) 
			return (float) (bruto * 0.11);
		else 
			return (float) 318.37;	
	}
	
	public float calculaFGTS(float bruto) {
		return (float) (bruto * 0.08);
	}
	
	public float calculaSalarioLiquido(float bruto, float IR, float INSS) {
		return bruto - IR - INSS;
	}
}