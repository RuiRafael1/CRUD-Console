package CRUD;

public class Aluno {
	int posicao;
	int matricula;
	String nome;
	boolean matriculado;

	public Aluno(int posicao, int matricula, String nome) {
		this.posicao = posicao;
		this.matricula = matricula;
		this.nome = nome;
		this.matriculado = true;
	}

	@Override
	public String toString() {
		return posicao + "° | Nome: " + nome + " | Matricula: " + matricula + " | Matriculado: " + matriculado;
	}

}