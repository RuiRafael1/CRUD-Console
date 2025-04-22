package CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aux = 1;
		int tamanho = 0;
		int contador = 1;
		Aluno aluno1 = null;
		ArrayList<Aluno> turma = new ArrayList<Aluno>();
		System.out.println("     --> PROFESSOR ON-LINE <--");
		do {
			try {
				System.out.println();
				System.out.println("Digite o tamanho da turma");
				System.out.print(">>");
				tamanho = sc.nextInt();
				if (tamanho <= 0) {
					System.out.println("");
					System.err.println("O valor precisa ser um número positivo.");
				} else {
					aux = 0;
				}

			} catch (Exception e) {
				System.out.println();
				System.err.println("O valor precisa ser um número de até nove digitos.");

				sc.next();

			}
		} while (aux != 0);

		final int tamanhoMax = tamanho;				
		int escolha = 0;

		System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
		do {
			// try {
			System.out.println();
			System.out.println("Escolha uma das seguintes ações:");
			System.out.println("[1] - Adicionar aluno(s) à turma");
			System.out.println("[2] - Mostrar a turma");
			System.out.println("[3] - Matricular/Desmatricular aluno");
			System.out.println("[4] - Tirar aluno(a) da turma ");
			System.out.println("[5] - Tirar todos os alunos da turma");
			System.out.println("[6] - Editar aluno");
			System.out.println("[7] - Sair");
			System.out.print(">>");
			escolha = sc.nextInt();

			System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");

			switch (escolha) {
			case 1:// add
				if (contador > tamanhoMax || tamanho == 0) {
					System.out.println();
					System.out.println("A sala está cheia.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}
				System.out.println("Você quer adicionar quantos alunos de uma vez só? (máx. " + tamanho + ")");
				int quantidadeDeAlunos = sc.nextInt();
				System.out.println("");
				if (quantidadeDeAlunos > tamanhoMax || quantidadeDeAlunos > tamanho) {
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					System.out.println();
					System.out.println("A quantidade de alunos precisa caber dentro da turma.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}

				// tamanho = tamanhoMax;
				tamanho -= quantidadeDeAlunos;

				for (int i = 0; i < quantidadeDeAlunos; i++) {
					System.out.println(contador);
					if (contador <= tamanhoMax && quantidadeDeAlunos <= tamanhoMax) {						

						System.out.println("Digite o nome do " + contador + "° aluno:");
						System.out.print(">>");
						String nome = sc.next();

						System.out.println("Digite a matricula do(a) " + nome);
						System.out.print(">>");
						int matricula = sc.nextInt();

						aluno1 = new Aluno(contador, matricula, nome);
						turma.add(aluno1);
						contador++;
					}

				}

				System.out.println();
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				break;
			case 2: // mostrar
				if (turma.size() == 0) {
					System.out.println();
					System.out.println("A turma está sem alunos.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}
				System.out.println();
				for (Aluno aluno : turma) {
					System.out.println(aluno);
				}

				System.out.println();
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				break;
			case 3:// matricular/desmatricular
				if (turma.size() == 0) {
					System.out.println();
					System.out.println("A turma está sem alunos.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}
				System.out.println("Buscar aluno por MATRICULA");

				for (Aluno aluno : turma) {
					System.out.println(aluno);
				}

				System.out.print(">>");
				int id = sc.nextInt();

				for (Aluno aluno : turma) {
					if (id == aluno.matricula) {
						if (aluno.matriculado == true) {
							aluno.matriculado = false;
							System.out.println("O aluno '" + aluno.nome + "' foi dematriculado. ");
							break;
						}

						if (!aluno.matriculado) {
							if (aluno.matriculado == false) {
								aluno.matriculado = true;
								System.out.println("O aluno '" + aluno.nome + "' foi matriculado. ");
							}
						}

					}
				}
				System.out.println();
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				break;

			case 4:// deletar aluno
				if (turma.size() == 0) {
					System.out.println();
					System.out.println("A turma está sem alunos.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}

				System.out.println("Buscar aluno por MATRICULA");
				for (Aluno aluno : turma) {
					System.out.println(aluno);
				}
				System.out.print(">>");
				id = sc.nextInt();

				for (Aluno aluno : turma) {
					if (id == aluno.matricula) {
						System.out.println("Você tem certeza que deseja excluir o " + aluno.nome + "? sim/não");
						String resp = sc.next();

						resp.toLowerCase();

						if (resp.equals("sim")) {
							System.out.println();
							System.out.println("Aluno '" + aluno.nome + "' removido(a) da turma.");

							if (turma.size() != 0) {

								

								turma.remove(aluno);
								// contador = aluno.posicao;
								tamanho++;
								break;
							}

							System.out.println();
							System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");

							break;
						} else {
							System.out.println();
							System.out.println("Ação cancelada");
							System.out.println();
							System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
						}

					}
				}
				break;
			case 5:
				if (turma.size() == 0) {
					System.out.println();
					System.out.println("A turma está sem alunos.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}
				System.out.println("Você tem certeza que deseja excluir todos os alunos da turma? sim/não");
				String resp = sc.next();

				resp.toLowerCase();

				if (resp.equals("sim")) {
					System.out.println();
					System.out.println("Todos os alunos foram removidos da turma.");
					turma.removeAll(turma);
					contador = 1;
					tamanho = tamanhoMax;
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");

					break;
				} else {
					System.out.println();
					System.out.println("Ação cancelada");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				}
				break;

			case 6:
				if (turma.size() == 0) {
					System.out.println();
					System.out.println("A turma está sem alunos.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}

				System.out.println("Alterar aluno por MATRICULA");
				for (Aluno aluno : turma) {
					System.out.println(aluno);
				}
				System.out.print(">>");
				id = sc.nextInt();

				System.out.println("");
				System.out.println("O que deseja alterar no aluno?");
				System.out.println("[1] - Nome");
				System.out.println("[2] - Posição");
				System.out.println("[3] - Matrícula");
				System.out.print(">>");
				int respo = sc.nextInt();
				System.out.println();

				switch (respo) {
				case 1:
					for (Aluno aluno : turma) {
						if (id == aluno.matricula) {
							System.out.println("Corrija o nome do '" + aluno.nome + "'");
							System.out.print(">>");
							aluno.nome = sc.next();
							System.out.println();
							System.out.println("Nome alterado com sucesso!");
						}
					}
					break;
				case 2:
					for (Aluno aluno : turma) {
						if (id == aluno.matricula) {
							System.out.println("Corrija a posição do '" + aluno.nome + "'");
							System.out.print(">>");
							int aux2 = sc.nextInt();

							if (aux2 <= tamanhoMax && aux2 > 0) {
								aluno.posicao = aux2;
								System.out.println();
								System.out.println("Posição alterada com sucesso!");
							} else {
								System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
								System.out.println();
								System.out.println("A posição precisa caber na sala.");
							}

						}
					}
					break;
				case 3:
					for (Aluno aluno : turma) {
						if (id == aluno.matricula) {
							System.out.println("Corrija a matricula do '" + aluno.nome + "'");
							System.out.print(">>");
							aluno.matricula = sc.nextInt();
							System.out.println();
							System.out.println("Matricula alterada com sucesso!");
						}
					}
					break;
				default:
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					System.out.println();
					System.out.println("Opção inválida.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}
			default:
				System.out.println();
				System.out.println("Ação não encontrada.");
				System.out.println();
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				break;
			}
//			} catch (Exception e) {
//				System.out.println();
//				System.err.println("Ocorreu um erro inesperado.");
//				sc.next();
//			}
		} while (escolha != 7);
		sc.close();
	}
}