package br.com.senai.curso;

import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;




public class CursoController {
	
		
	private Scanner tec;
		
	public CursoController() {
			tec = new Scanner(System.in);
			

	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Curso cadastrarCurso(List<Aluno> alunos) {
		
		if(alunos.isEmpty()) {
			System.out.println("Impossível realizar cadastro sem alunos cadastrados!");
			return null;
		}
	
		Curso curso = new Curso();

		
		System.out.println("---------------------CADASTRAR CURSO---------------------");

			System.out.print("Informe o nome do curso: ");
			tec.nextLine();
			curso.setNomeCurso(tec.nextLine().toUpperCase());
			
				
			return curso;
				
	}

	public List<Curso> listarCursos(List<Curso> cursos) {
		if(cursos.isEmpty()) {
			System.out.println("Impossível realizar operação, nenhum curso cadastrado!");
			return null;
		}
				
			System.out.println("---------------------CURSOS CADASTRADOS---------------------");

			System.out.printf("| %2s | %13s \n","ID", "Nome");

			for (int i = 0; i < cursos.size(); i++) {
				System.out.printf("| %2d | %13s \n", 
						i + 1,
						cursos.get(i).getNomeCurso());
			
			}

			return cursos;
			
	}
			
			
	public List<Curso> editarCursos(List<Curso> cursos) {
		Curso curso = new Curso();
		listarCursos(cursos);
				
		if(cursos.isEmpty()) {
				return null;
		}
				
				
			System.out.print("Informe o Id do curso para editar: ");
			int idCurso = tec.nextInt() - 1;
				
			System.out.println("1) NOME DO CURSO");

			System.out.print("Informe o campo para ser editado: ");
			int opcao = tec.nextInt();
				
			switch(opcao) {
				
			case 1: 
				System.out.println("---------------------EDITAR NOME DO CURSO---------------------");
				System.out.print("Informe o novo nome do curso: ");
				curso.setNomeCurso(tec.next().toUpperCase());

				cursos.set(idCurso, curso);
					
				break;
					
			default:
				System.out.println("Opção Inválida!");
					
			}
				
				return cursos; 
			}
			
			
	public void excluirCurso(List <Curso> cursos, List<Aluno> alunos) {
		listarCursos(cursos);
		if(cursos.isEmpty() || alunos.isEmpty()) {
			System.out.println("Impossível excluir o curso ppois já há alunos nele!");
			return;
		}
				
		System.out.println("---------------------EXCLUIR CURSO---------------------");
				
		System.out.print("Informe o ID do curso para excluir: ");
		int idCurso = tec.nextInt() - 1;
				
		if(cursos.size() <= idCurso) {
					
			System.out.println("Curso não cadastrado.");
			return;
		}
				
		cursos.remove(idCurso);
		
	}
			
	public void menu(List<Curso> cursos, List<Aluno> alunos) {
				
			boolean sair = false;
				
			do {
					
				
			System.out.println("\n--------------MENU--------------");
			System.out.println("1) CADASTRAR CURSO");
			System.out.println("2) LISTAR CURSOS CADASTRADOS");
			System.out.println("3) EDITAR CURSOS");
			System.out.println("4) EXCLUIR CURSOS");
			System.out.println("5) SAIR");
			System.out.println("---------------------------------");
				
				int opcao = leOpcao();
				
				switch(opcao) {
				
				case 1:
					
					cursos.add(cadastrarCurso(alunos));
					break;
					
				case 2: 
					
					listarCursos(cursos);
					break;
					
				case 3:
					editarCursos(cursos);
					break;
					
				case 4:
					excluirCurso(cursos, alunos);
					break;
					
				case 5:
					sair = true;
					break;

							
				default: 
					System.out.println("Opção inválida!!!");
					
				}
				
			}while(!sair);	
	}

}
