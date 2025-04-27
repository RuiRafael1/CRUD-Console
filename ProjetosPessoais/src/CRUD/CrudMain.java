package CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int aux = 1;
		int tamanho = 0;
		int contadorDeAlunos = 0;

		ArrayList<Aluno> turma = new ArrayList<Aluno>();

		System.out.println("     --> PROFESSOR ON-LINE <--");
		do {
			try {
				System.out.println();
				System.out.println("Digite o tamanho da turma");
				System.out.print(">>");
				tamanho = sc.nextInt();
				if (tamanho <= 0) {
					System.out.println();
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
			try {
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
					if (contadorDeAlunos > tamanhoMax || tamanho == 0) {
						System.out.println();
						System.out.println("A sala está cheia.");
						System.out.println();
						System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
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
						System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
						break;
					}

					

					for (int i = 1; i <= tamanhoMax; i++) {
						boolean JaTemAluno = false;
						boolean AtributoRepetido = false;
						long matricula = 0;
						long telefone = 0;
						for (Aluno aluno : turma) {
							if (aluno.JaTemAluno(i)) {
								JaTemAluno = true;
								break;
							} else {
								JaTemAluno = false;
							}
						}

						if (!JaTemAluno && contadorDeAlunos < quantidadeDeAlunos) {
							System.out.println("Digite o nome do " + i + "° aluno:");
							System.out.print(">>");
							String nome = sc.next();
							System.out.println();
							do {
								System.out.println("Digite o telefone do(a) " + nome);
								System.out.print(">>");
								telefone = sc.nextLong();
								System.out.println();
								for (Aluno aluno : turma) {
									if (aluno.AtributoRepetido(telefone)) {
										AtributoRepetido = true;
										break;
									} else {
										AtributoRepetido = false;
									}
								}
							} while (AtributoRepetido);
							
							do {
								System.out.println("Digite a matricula do(a) " + nome);
								System.out.print(">>");
								matricula = sc.nextLong();
								System.out.println();
								for (Aluno aluno : turma) {
									if (aluno.AtributoRepetido(matricula)) {
										AtributoRepetido = true;
										break;
									} else {
										AtributoRepetido = false;
									}
								}
							} while (AtributoRepetido);

							Aluno aluno = new Aluno(i, matricula, nome, telefone);
							turma.add(aluno);
							contadorDeAlunos++;
						}

					}System.out.println(tamanho);
					System.out.println(contadorDeAlunos);
					
					tamanho -= quantidadeDeAlunos;
					contadorDeAlunos = 0;
					System.out.println();
					System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				case 2: // mostrar
					if (TurmaVazia(turma) == true) {
						break;
					}
					MostrarTurma(turma);

					System.out.println();
					System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				case 3:// matricular/desmatricular
					if (TurmaVazia(turma) == true) {
						break;
					}
					System.out.println("Buscar aluno por MATRICULA");
					MostrarTurma(turma);
					System.out.print(">>");
					int id = sc.nextInt();

					for (Aluno aluno : turma) {
						aluno.MatricularDesmatricular(id);
					}
					System.out.println();
					System.out.print("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;

				case 4:// deletar aluno
					if (TurmaVazia(turma) == true) {
						break;
					}
					System.out.println("Buscar aluno por MATRICULA");
					MostrarTurma(turma);
					System.out.print(">>");
					id = sc.nextInt();

					for (Aluno aluno : turma) {
						if (aluno.DeletarAluno(id, turma, aluno) == 1) {
							tamanho++;
							break;
						}
					}
					break;
				case 5:
					if (TurmaVazia(turma) == true) {
						break;
					}

					for (Aluno aluno : turma) {
						aluno.DeletarTurma(turma, contadorDeAlunos, tamanho, tamanhoMax);
						contadorDeAlunos = 0;
						tamanho = tamanhoMax;
						break;
					}
					break;
				case 6:
					if (TurmaVazia(turma) == true) {
						break;
					}

					System.out.println("Alterar aluno por MATRICULA");
					MostrarTurma(turma);
					System.out.print(">>");
					id = sc.nextInt();

					System.out.println("");
					System.out.println("O que deseja alterar no aluno?");
					System.out.println("[1] - Nome");
					System.out.println("[2] - telefone");
					System.out.println("[3] - Matrícula");
					System.out.print(">>");
					int respo = sc.nextInt();
					System.out.println();

					switch (respo) {
					case 1:
						for (Aluno aluno : turma) {
							aluno.EditarAluno(respo, id);
						}
						break;
					case 2:
						for (Aluno aluno : turma) {
							aluno.EditarAluno(respo, id);
						}
						break;
					case 3:
						for (Aluno aluno : turma) {
							aluno.EditarAluno(respo, id);
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
					break;
				case 7:
					System.out.println("Obrigado por usar nosso programa!");
					break;
				default:
					System.out.println();
					System.out.println("Ação não encontrada.");
					System.out.println();
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					break;
				}
			} catch (Exception e) {
				System.out.println();
				System.err.println("Ocorreu um erro inesperado.");
				sc.next();
			}
		} while (escolha != 7);
		sc.close();
	}

	// métodos fora do main.
	private static boolean TurmaVazia(ArrayList<Aluno> turma) {
		if (turma.size() == 0) {
			System.out.println();
			System.out.println("A turma está sem alunos.");
			System.out.println();
			System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
			return true;
		} else {
			return false;
		}
	}

	private static void MostrarTurma(ArrayList<Aluno> turma) {
		for (Aluno aluno : turma) {
			System.out.println(aluno);
		}
	}

}