package br.com.senai.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;
import br.com.senai.aluno.AlunoController;
import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class ProgramaPrincipal {
	
	private Scanner tec;

	public ProgramaPrincipal() {
		tec = new Scanner(System.in);

	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
	
	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();
		List<Curso> cursos = new ArrayList<Curso>();

		

		
		boolean sair = false;
		AlunoController alunoController = new AlunoController();
		CursoController cursoController = new CursoController();
		Menu menu = new Menu();
		
		
		do {
			
			menu.listarMenu(cursos, alunos);
			int opcao = menu.leOpcao();

			switch (opcao) {
			
			case 1:
				alunoController.menu(alunos, cursos);
				break;
				
			case 2:
				cursoController.menu(cursos, alunos);
				break;

			case 3:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!");
				break;

			}

		} while (!sair);

		System.out.println("SISTEMA FINALIZADO!!");
		
	}

}
