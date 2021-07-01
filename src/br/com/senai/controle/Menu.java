package br.com.senai.controle;

import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;
import br.com.senai.curso.Curso;

public class Menu {
	
Scanner tec = new Scanner(System.in);
	
	public void listarMenu(List<Curso> cursos, List<Aluno> alunos) {
		System.out.println("\n---------------- MENU ----------------");
		System.out.println("1) ALUNO");
		System.out.println("2) CURSO");
		System.out.println("3) SAIR");
		System.out.println("----------------------------------------");
	}
	
	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
}


