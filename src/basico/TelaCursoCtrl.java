package basico;

import java.util.List;

public class TelaCursoCtrl extends Tela {

	private Curso curso;
	private ICursoCtrl cursoCtrl;
	
	public TelaCursoCtrl(ICursoCtrl cursoCtrl) {
		this.cursoCtrl = cursoCtrl;
		abrirScan();
	}
	
	
	public void cadastrar() {
		curso = new Curso();
		print("Digite o nome");
		curso.setNome(scan.nextLine());
		try {
			cursoCtrl.inserir(curso);
			print("Cadastrado com sucesso");
		}catch (Exception e) {
			print(e.getLocalizedMessage());
		}
	}
	
	public void alterar() {
		print("Digite o código para Alterar o Curso");
		Integer codigo = lerInt();
		try {
			curso = cursoCtrl.getPorId(codigo);
			if (curso == null) {
				print("Não foi encontrado o aluno!");
			}else {
				print("Digite o nome: ("+ curso.getNome()+")");
				curso.setNome(scan.nextLine());
				cursoCtrl.alterar(curso);
				print("Alterado com sucesso!");
			}
		} catch (Exception e) {
			print("Deu falha no alterar o aluno");
			e.printStackTrace();
		}
	}
	
	public void deletar() {
		try {
			print("Digite o código do Curso");
			Integer codigo = lerInt();
			curso = cursoCtrl.getPorId(codigo);
			if (curso == null) {
				print("Não foi encontrado o curso!");
			}else {
				cursoCtrl.deletar(curso);
				print("Curso deletado com sucesso!");
			}
		}catch (Exception e) {
			print("Falha ao deletar o curso");
			e.printStackTrace();
		}
	}
	
	public void imprimir(Curso curso) {
		print("Código");
		print(curso.getId().toString());
		print("Nome:");
		print(curso.getNome());
		print("");
	}
	
	public void listar() {
		try {
			List<Curso> cursos = cursoCtrl.todos();
			for (Curso curso : cursos) {
				imprimir(curso);
			}
		} catch (Exception e) {
			print("Falha ao listar os cursos");
			e.printStackTrace();
		}
	}
	
	public void buscarPorId() {
		try {
			print("Digite o Código");
			Integer codigo = lerInt();
			Curso curso= cursoCtrl.getPorId(codigo);
			if (curso != null) {
				imprimir(curso);
			}else {
				print("Curso não encontrado!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
