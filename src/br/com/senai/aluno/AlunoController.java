package br.com.senai.aluno;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class AlunoController {
	
	private Scanner tec;
	private CursoController cursoController;
	
	public AlunoController() {
		tec = new Scanner(System.in);
		CursoController cursoController = new CursoController();
		
	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Aluno cadastrarAluno(List<Curso> cursos) {
		Aluno aluno = new Aluno();
		Curso curso = new Curso();
		
		System.out.println("---------------------CADASTRAR ALUNO---------------------");
	

		cursoController.listarCursos(cursos);

		System.out.print("Informe o ID do curso desejado: ");
		int idCurso = tec.nextInt() - 1;
		curso.setNomeCurso(tec.next());
		
		cursos.set(idCurso, curso);
		

		System.out.print("Informe o nome: ");
		tec.nextLine();
		aluno.setNomeAluno(tec.nextLine().toUpperCase());
		
		System.out.print("Informe o ano de nascimento: ");
		aluno.setAnoDeNascimento(tec.nextInt());
		Calendar calendar = Calendar.getInstance();
		
		aluno.setIdadeAluno(calendar.get(Calendar.YEAR) - aluno.getAnoDeNascimento());
		
		System.out.print("Informe o pa�s: ");
		tec.nextLine();
		aluno.setPais(tec.nextLine().toUpperCase());
		
		System.out.print("Informe o estado: ");
		aluno.setEstado(tec.nextLine().toUpperCase().toString());
		
		System.out.print("Informe a cidade: ");
		aluno.setCidade(tec.nextLine().toUpperCase());

			
		return aluno;
			
	}

		public List<Aluno> listarAlunos(List<Aluno> alunos) {
			if(alunos.isEmpty()) {
				System.out.println("Imposs�vel realizar opera��o, nenhum aluno cadastrado!");
				return null;
			}
			
			System.out.println("---------------------ALUNOS CADASTRADOS---------------------");

			System.out.printf("| %2s | %13s | %4s | %5s |  %5s | %5s | %16s |\n","ID", "Nome", "Ano", "Idade", "Pa�s", "Estado", "Cidade");

			for (int i = 0; i < alunos.size(); i++) {
				System.out.printf("| %2d | %13s | %4d | %5d | %5s | %5s | %16s | \n", 
						i + 1,
						alunos.get(i).getNomeAluno(),
						alunos.get(i).getAnoDeNascimento(), 
						alunos.get(i).getIdadeAluno(),
						alunos.get(i).getPais(),
						alunos.get(i).getEstado(),
						alunos.get(i).getCidade());
						
			}

			return alunos;
		
		}
		
		
		public List<Aluno> editarAlunos(List<Aluno> alunos) {
			
			Aluno aluno = new Aluno();
			listarAlunos(alunos);
			
			if(alunos.isEmpty()) {
				return null;
			}
			
			
			System.out.print("Informe o Id do aluno para editar: ");
			int idAluno = tec.nextInt() - 1;
			
			System.out.println("1) NOME DO ALUNO");
			System.out.println("2) ANO DE NASCIMENTO");
			System.out.println("3) PA�S");
			System.out.println("4) ESTADO");
			System.out.println("5) CIDADE");

			System.out.print("Informe o campo para ser editado: ");
			int opcao = tec.nextInt();
			
			switch(opcao) {
			
			case 1: 
				System.out.println("---------------------EDITAR NOME DA PESSOA---------------------");
				System.out.println("Informe o novo nome do aluno: ");
				aluno.setNomeAluno(tec.next().toUpperCase());
				
				aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());

				alunos.set(idAluno, aluno);
				
				break;
				
			case 2:
				System.out.println("---------------------EDITAR ANO DE NASCIMENTO---------------------");
				
				System.out.print("Informe o novo ano de nascimento: ");
				aluno.setAnoDeNascimento(tec.nextInt());
				
				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				Calendar calendar = Calendar.getInstance();
				aluno.setIdadeAluno(calendar.get(Calendar.YEAR) - aluno.getAnoDeNascimento());
				
				alunos.set(idAluno, aluno);
				
				break;
				
			case 3:
				System.out.println("---------------------EDITAR PA�S---------------------");

				
				System.out.print("Informe o novo pa�s: ");
				aluno.setPais(tec.next());
				
				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
				aluno.setEstado(alunos.get(idAluno).getEstado());
				aluno.setCidade(alunos.get(idAluno).getCidade());
				
				alunos.set(idAluno, aluno);
				
				break;
				
			case 4:

				
				System.out.println("---------------------EDITAR O ESTADO---------------------");
				
				System.out.println("Informe o novo estado: ");
				aluno.setEstado(tec.next());
				
				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setCidade(alunos.get(idAluno).getCidade());

				
				alunos.set(idAluno, aluno);
				
				break;
				
			case 5:
				
				System.out.println("---------------------EDITAR CIDADE---------------------");
				System.out.println("Informe o novo nome da cidade: ");
				aluno.setCidade(tec.next());
				
				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setEstado(alunos.get(idAluno).getEstado());

				alunos.set(idAluno, aluno);
				
				break;
				
				
						
			default:
				System.out.println("Op��o Inv�lida!");
			}
			
			return alunos; 
		}
		
		
		public void excluirAluno(List <Aluno> alunos) {
			listarAlunos(alunos);
			if(alunos.isEmpty()) {
				return;
			}
			
			System.out.println("---------------------EXCLUIR ALUNO---------------------");
			
			System.out.print("Informe o ID do aluno para excluir: ");
			int idAluno = tec.nextInt() - 1;
			
			if(alunos.size() <= idAluno) {
				
				System.out.println("Aluno n�o cadastrado.");
				return;
			}
			
			alunos.remove(idAluno);
		}
		
		public void menu(List<Aluno> alunos, List<Curso> cursos) {
			
			boolean sair = false;
			
			do {
				
			
			System.out.println("\n--------------MENU--------------");
			System.out.println("1) CADASTRAR ALUNO");
			System.out.println("2) LISTAR ALUNOS CADASTRADOS");
			System.out.println("3) EDITAR ALUNOS");
			System.out.println("4) EXCLUIR ALUNOS");
			System.out.println("5) SAIR");
			System.out.println("---------------------------------");
			
			int opcao = leOpcao();
			
			switch(opcao) {
			
			case 1:
				
				alunos.add(cadastrarAluno(cursos));
				break;
				
			case 2: 
				
				listarAlunos(alunos);
				break;
				
			case 3:
				editarAlunos(alunos);
				break;
				
			case 4:
				excluirAluno(alunos);
				break;
			case 5:
				sair = true;
				break;

						
			default: 
				System.out.println("Op��o inv�lida!!!");
				
			}
			
		}while(!sair);	
		
	}
}
