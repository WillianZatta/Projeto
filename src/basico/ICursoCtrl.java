package basico;

import java.util.List;

public interface ICursoCtrl {

	public Curso inserir(Curso curso)throws Exception;
	
	public Curso alterar(Curso curso)throws Exception;
	
	public Boolean deletar(Curso curso)throws Exception;
	
	public List<Curso> todos()throws Exception;
	
	public Curso getPorId(Integer id)throws Exception;
}
