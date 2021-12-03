package basico;

import java.util.List;

public class TelaAlunoCtrl extends Tela {

	private Aluno aluno;
	private IAlunoCtrl alunoCtrl;
	
	public TelaAlunoCtrl(IAlunoCtrl alunoCtrl) {
		this.alunoCtrl = alunoCtrl;
		abrirScan();
	}
	
	
	public void cadastrar() {
		aluno = new Aluno();
		print("Digite o nome");
		aluno.setNome(scan.nextLine());
		
		print("Digite a Altura");
		aluno.setAltura(lerDouble());
		
		print("Digite o seu Peso");
		aluno.setPeso(lerDouble());
		
		print("Digite a Idade");
		aluno.setIdade(lerInt());
		
		print("Digite a matricula");
		aluno.setMatricula(scan.nextLine());
		
		print("Digite o números de horas");
		aluno.setHorasComplementares(lerDouble());
		try {
			alunoCtrl.inserir(aluno);
			print("Cadastrado com sucesso");
		}catch (Exception e) {
			print(e.getLocalizedMessage());
		}
	}
	
	public void alterar() {
		print("Digite o código para Alterar o Aluno");
		Integer codigo = lerInt();
		try {
			aluno = alunoCtrl.getPorId(codigo);
			if (aluno == null) {
				print("Não foi encontrado o aluno!");
			}else {
				print("Digite o nome: ("+ aluno.getNome()+")");
				aluno.setNome(scan.nextLine());
				
				print("Digite o peso:("+aluno.getPeso()+")");
				aluno.setPeso(lerDouble());
				
				print("Digite a Altura:("+aluno.getAltura()+")");
				aluno.setAltura(lerDouble());
				
				print("Digite a Idade:("+aluno.getIdade()+")");
				aluno.setIdade(lerInt());
				
				alunoCtrl.alterar(aluno);
				print("Alterado com sucesso!");
			}
		} catch (Exception e) {
			print("Deu falha no alterar o aluno");
			e.printStackTrace();
		}
	}
	
	public void deletar() {
		try {
			print("Digite o código do Aluno");
			Integer codigo = lerInt();
			aluno = alunoCtrl.getPorId(codigo);
			if (aluno == null) {
				print("Não foi encontrado o aluno!");
			}else {
				alunoCtrl.deletar(aluno);
				print("Aluno deletado com sucesso!");
			}
		}catch (Exception e) {
			print("Falha ao deletar o aluno");
			e.printStackTrace();
		}
	}
	
	public void imprimir(Aluno aluno) {
		print("Código");
		print(aluno.getId().toString());
		print("Nome:");
		print(aluno.getNome());
		print("");
		print("Altura:");
		print(aluno.getAltura().toString());
		print("");
		print("Idade:");
		print(aluno.getIdade().toString());
		print("");
		print("Peso:");
		print(aluno.getPeso().toString());
		print("");
		print("Matricula:");
		print(aluno.getMatricula());
		print("");
		print("Horas complementares");
		print(aluno.getHorasComplementares().toString());
		print("");
	}
	
	public void listar() {
		try {
			List<Aluno> alunos = alunoCtrl.todos();
			for (Aluno aluno : alunos) {
				imprimir(aluno);
			}
		} catch (Exception e) {
			print("Falha ao listar os alunos");
			e.printStackTrace();
		}
	}
	
	public void buscarPorId() {
		try {
			print("Digite o Código");
			Integer codigo = lerInt();
			Aluno aluno = alunoCtrl.getPorId(codigo);
			if (aluno != null) {
				imprimir(aluno);
			}else {
				print("Aluno não encontrado!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
