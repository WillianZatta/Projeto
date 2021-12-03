package basico;

public class Aluno extends Pessoa {

	private String matricula;
	private Double horasComplementares;
	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Double getHorasComplementares() {
		return horasComplementares;
	}
	public void setHorasComplementares(Double horasComplementares) {
		this.horasComplementares = horasComplementares;
	}
}
