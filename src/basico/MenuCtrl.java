package basico;
import java.util.Scanner;
public class MenuCtrl {

	public void executar() {
		Integer opcao = 0;
		do {
			String menu = " MENU  \n";
			menu += " 0 - Sair \n";
			menu += " 1 - Cadastrar Aluno \n";
			menu += " 2 - Alterar Aluno\n";
			menu += " 3 - Excluir Aluno\n";
			menu += " 4 - Listar Todos \n";
			menu += " 5 - Buscar Por ID do Aluno\n";
			menu += " 6 - Cadastrar Curso \n";
			menu += " 7 - Alterar Curso\n";
			menu += " 8 - Excluir Curso\n";
			menu += " 9 - Listar Todos os Cursos\n";
			menu += " 10 - Buscar Por ID do Curso\n";
			System.out.println(menu);
			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();
			IAlunoCtrl alCtrl = new AlunoCtrl();
			TelaAlunoCtrl tAluno = new TelaAlunoCtrl(alCtrl);
			ICursoCtrl cuCtrl = new CursoCtrl();
			TelaCursoCtrl tCurso = new TelaCursoCtrl(cuCtrl);
			switch (opcao) {
			case 1:
				tAluno.cadastrar();
				break;
			case 2:
				tAluno.alterar();
				break;
			case 3:
				tAluno.deletar();
				break;
			case 4:
				tAluno.listar();
				break;
			case 5:
				tAluno.buscarPorId();
				break;
			case 6:
				tCurso.cadastrar();
				break;
			case 7:
				tCurso.alterar();
				break;
			case 8:
				tCurso.deletar();
				break;
			case 9:
				tCurso.listar();
				break;
			case 10:
				tCurso.buscarPorId();
				break;
			default:
				break;
			}
		}while ( opcao != 0);
	}
}
