import java.util.ArrayList;
import java.util.List;

public class Boletim {
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private String situacaoGeral;

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getSituacaoGeral() {
		return situacaoGeral;
	}

	public void setSituacaoGeral(String situacaoGeral) {
		this.situacaoGeral = situacaoGeral;
	}

	@Override
	public String toString() {
		return "Boletim [disciplinas=" + disciplinas + ", situacaoGeral=" + situacaoGeral + "]";
	}

}
