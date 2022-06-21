import java.util.Arrays;

public class Disciplina {

	private String nomeDisc;
	private double[] notas = new double[4];
	private double media_geral;
	private String situacao;

	public String getNomeDisc() {
		return nomeDisc;
	}

	public void setNomeDisc(String nomeDisc) {
		this.nomeDisc = nomeDisc;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double getMedia_geral() {
		return media_geral;
	}

	public void setMedia_geral(double media_geral) {
		this.media_geral = media_geral;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Disciplina [nomeDisc=" + nomeDisc + ", notas=" + Arrays.toString(notas) + ", media_geral=" + media_geral
				+ ", situacao=" + situacao + "]";
	}

}
