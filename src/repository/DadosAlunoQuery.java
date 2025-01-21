package repository;

public class DadosAlunoQuery {

	private String nome;
	private String disciplina;
	private String nota1;
	private String nota2;
	private String nota3;
	private String nota4;
	private String media;
	private String situacao;

	public DadosAlunoQuery() {

	}

	public DadosAlunoQuery(String nome, String disciplina, String nota1, String nota2, String nota3, String nota4,
			String media, String situacao) {

		this.nome = nome;
		this.disciplina = disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.media = media;
		this.situacao = situacao;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getNota1() {
		return nota1;
	}

	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}

	public String getNota2() {
		return nota2;
	}

	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}

	public String getNota3() {
		return nota3;
	}

	public void setNota3(String nota3) {
		this.nota3 = nota3;
	}

	public String getNota4() {
		return nota4;
	}

	public void setNota4(String nota4) {
		this.nota4 = nota4;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
