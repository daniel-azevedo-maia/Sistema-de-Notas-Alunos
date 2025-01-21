package domain;

import java.text.DecimalFormat;
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
		mediaFinal();
	}

	public double getMedia_geral() {
		return media_geral;
	}

	public String getSituacao() {
		return situacao;
	}

	public void mediaFinal() {
		double media = 0;
		for (int i = 0; i < this.notas.length; i++) {
			media += notas[i];
		}

		media /= 4;

		DecimalFormat df = new DecimalFormat("0.0");
		String novoValor = df.format(media);
		media = Double.parseDouble(novoValor);

		if (media >= 7) {
			this.media_geral = media;
			this.situacao = "Aprovado";
		} else {
			this.media_geral = media;
			this.situacao = "Reprovado";
		}

	}

	@Override
	public String toString() {
		return "Disciplina [nomeDisc=" + nomeDisc + ", notas=" + Arrays.toString(notas) + ", media_geral=" + media_geral
				+ ", situacao=" + situacao + "]";
	}

}
