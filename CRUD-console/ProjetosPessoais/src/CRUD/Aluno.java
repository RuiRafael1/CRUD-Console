package CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
	Scanner sc = new Scanner(System.in);

	private long telefone;
	private int posicao;
	private long matricula;
	private String nome;
	private boolean matriculado;

	public Aluno(int posicao, long matricula, String nome, long telefone) {
		this.telefone = telefone;
		this.posicao = posicao;
		this.matricula = matricula;
		this.nome = nome;
		this.matriculado = true;
	}

	public void MatricularDesmatricular(int id) {
		if (id == matricula) {
			if (matriculado) {
				matriculado = false;
				System.out.println("O aluno '" + nome + "' foi dematriculado. ");
			} else {
				matriculado = true;
				System.out.println("O aluno '" + nome + "' foi matriculado. ");
			}
		}
	}

	public boolean AtributoRepetido(long atributo) {
		if (atributo == telefone || atributo == matricula) {
			System.out.println();
			System.out.println("Este valor não pode ser repetido.");
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public Boolean JaTemAluno(int i) {
		if (i == posicao) {
			return true;
		} else {
			return false;
		}
	}

	public int DeletarAluno(int id, ArrayList<Aluno> turma, Aluno aluno) {
		if (id == matricula) {
			System.out.println("Você tem certeza que deseja excluir o " + nome + "? sim/não");
			String resp = sc.next();

			resp.toLowerCase();

			if (resp.equals("sim")) {
				System.out.println();
				System.out.println("Aluno '" + nome + "' removido(a) da turma.");

				if (turma.size() != 0) {

					turma.remove(aluno);
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					return 1;
				} else {
					return 0;
				}

			} else {
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				System.out.println();
				System.out.println("Ação cancelada");
				System.out.println();
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				return 0;
			}

		} else {
			return 0;
		}
	}

	public void EditarAluno(int escolha, int id) {
		if (id == matricula) {
			switch (escolha) {
			case 1:
				if (id == matricula) {
					System.out.println("Corrija o nome do '" + nome + "'");
					System.out.print(">>");
					nome = sc.next();
					System.out.println();
					System.out.println("Nome alterado com sucesso!");
					break;
				}
				break;
			case 2:
				if (id == matricula) {
					System.out.println("Corrija o telelone do '" + nome + "'");
					System.out.print(">>");
					long aux2 = sc.nextLong();

					if (aux2 > 0 && aux2 < 99999_9999) {
						telefone = aux2;
						System.out.println();
						System.out.println("telefone alterado com sucesso!");

					} else {
						System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
						System.out.println();
						System.out.println("O telefone precisa ser válido.");
					}
				}
				break;
			case 3:
				if (id == matricula) {
					System.out.println("Corrija a matricula do '" + nome + "'");
					System.out.print(">>");
					matricula = sc.nextInt();
					System.out.println();
					System.out.println("Matricula alterada com sucesso!");
					break;
				}
				break;
			}
		}
	}

	public void DeletarTurma(ArrayList<Aluno> turma, int contadorDeAlunos, int tamanho, int tamanhoMax) {
		System.out.println("Você tem certeza que deseja excluir todos os alunos da turma? sim/não");
		String resp = sc.next();

		resp.toLowerCase();

		if (resp.equals("sim")) {
			System.out.println();
			System.out.println("Todos os alunos foram removidos da turma.");
			turma.removeAll(turma);
			contadorDeAlunos = 0;
			tamanho = tamanhoMax;
			System.out.println();
			System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");			
		} else {
			System.out.println();
			System.out.println("Ação cancelada");
			System.out.println();
			System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
		}
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	@Override
	
	public String toString() {
		return posicao + "° | Nome: " + nome + "| Telefone: " + telefone + " | Matricula: " + matricula
				+ " | Matriculado: " + matriculado;
	}

}