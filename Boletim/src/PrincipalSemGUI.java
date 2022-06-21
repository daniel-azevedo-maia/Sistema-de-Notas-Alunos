import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrincipalSemGUI {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "SISTEMA BOLETIM");

		int cadastrarNovoAluno = 0;
		int cadastrarNovaDisciplina = 0;

		List<Aluno> listaAlunos = new ArrayList<Aluno>();

		while (cadastrarNovoAluno == 0) {

			Aluno aln = new Aluno();
			Boletim boletim = new Boletim();

			// Cadastrando os dados pessoais:
			JOptionPane.showMessageDialog(null, "DADOS CADASTRAIS: ");

			String nome = JOptionPane.showInputDialog("Nome completo (sem abreviações): ");
			String sexo = JOptionPane.showInputDialog("Informe o sexo [M, F]: ");
			String cpf = JOptionPane.showInputDialog("CPF:");
			int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula: "));
			byte serie = Byte.parseByte(JOptionPane.showInputDialog("Série (1, 2 3): "));
			String turno = JOptionPane.showInputDialog("Turno [M, T]: ");
			String turma = JOptionPane.showInputDialog("Turma [A, B, C, D]: ");

			JOptionPane.showMessageDialog(null, "DADOS ESCOLARES: ");

			// Cadastrando as disciplinas:
			while (cadastrarNovaDisciplina == 0) {

				Disciplina disc = new Disciplina();

				String nomeDisc = JOptionPane.showInputDialog("Nome da disciplina: ");

				double[] notas = new double[4];

				for (int i = 0; i < 4; i++) {
					notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Nota: " + (i + 1) + ": "));
				}

				disc.setNomeDisc(nomeDisc);
				disc.setNotas(notas);
				boletim.getDisciplinas().add(disc);

				cadastrarNovaDisciplina = JOptionPane.showConfirmDialog(null, "Você deseja cadastrar nova disciplina?");

			}

			// Setando os dados
			aln.setNome(nome);
			aln.setSexo(sexo);
			aln.setCpf(cpf);
			aln.setMatricula(matricula);
			aln.setSerie(serie);
			aln.setTurno(turno);
			aln.setTurma(turma);
			aln.setBoletim(boletim);

			listaAlunos.add(aln);
			cadastrarNovoAluno = JOptionPane.showConfirmDialog(null, "Você deseja cadastrar novo aluno?");
			cadastrarNovaDisciplina = 0;

			// Criando um arquivo
			try {
				String nomeArq = "Boletim de " + aln.getNome() + ".txt";
				File meuArquivo = new File(nomeArq);
				if (meuArquivo.createNewFile()) {
					System.out.println("Arquivo criado com sucesso!");
				} else {
					System.out.println("O arquivo já existe!");
				}
			} catch (IOException e) {
				System.out.println("Um erro ocorreu!");
				e.printStackTrace();
			}

		}

		// Exibição de tudo:
		for (int i = 0; i < listaAlunos.size(); i++) {

			// Escrevendo em um arquivo:

			try {
				
				String ArqEscrito = "Boletim de " + listaAlunos.get(i).getNome() + ".txt";
				FileWriter meuEscrito = new FileWriter(ArqEscrito);
				System.out.println("Escrito com sucesso!");

				meuEscrito.write("--- Dados do aluno ---\n");

				// Exibindo dados cadastrais:
				meuEscrito.write("\tNome: " + listaAlunos.get(i).getNome() + "\n");
				meuEscrito.write("\tSexo: " + listaAlunos.get(i).getSexo() + "\n");
				meuEscrito.write("\tCPF: " + listaAlunos.get(i).getCpf() + "\n");
				meuEscrito.write("\tMatrícula: " + listaAlunos.get(i).getMatricula() + "\n");
				meuEscrito.write("\tSérie: " + listaAlunos.get(i).getSerie() + "\n");
				meuEscrito.write("\tTurno: " + listaAlunos.get(i).getTurno() + "\n");
				meuEscrito.write("\tTurma: " + listaAlunos.get(i).getTurma() + "\n");
				meuEscrito.write("\n");
				meuEscrito.write("--- Boletim do aluno ---\n");
				meuEscrito.write("\nNOTAS:\n");

				// Exibindo disciplinas

				for (Disciplina d : listaAlunos.get(i).getBoletim().getDisciplinas()) {
					meuEscrito.write("\n\t" + d.getNomeDisc() + ": " + "\n");
					for (int k = 0; k < d.getNotas().length; k++) {
						meuEscrito.write("\t" + d.getNotas()[k]);
						meuEscrito.write("\n");
					}
				}

				meuEscrito.close();

			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao escrever no arquivo.");
				e.printStackTrace();
			}
		}

	}

}
