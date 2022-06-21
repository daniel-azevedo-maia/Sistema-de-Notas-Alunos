
public class Aluno {

	private String nome;
	private String sexo;
	private String cpf;
	private int matricula; // 5 dígitos no máximo!
	private byte serie;
	private String turno;
	private String turma; // A, B, C, D
	private Boletim boletim;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public byte getSerie() {
		return serie;
	}

	public void setSerie(byte serie) {
		this.serie = serie;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + ", matricula=" + matricula + ", serie="
				+ serie + ", turno=" + turno + ", turma=" + turma + ", boletim=" + boletim + "]";
	}

}
