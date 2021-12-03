package basico;

import java.util.List;

public interface IAlunoCtrl {

	public Aluno inserir(Aluno aluno)throws Exception;
	
	public Aluno alterar(Aluno aluno)throws Exception;
	
	public Boolean deletar(Aluno aluno)throws Exception;
	
	public List<Aluno> todos()throws Exception;
	
	public Aluno getPorId(Integer id)throws Exception;
}
