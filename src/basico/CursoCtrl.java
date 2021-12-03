package basico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoCtrl implements ICursoCtrl{
	private Connection conn;
	
	public CursoCtrl() {
		try {
			PostgresConnection postgres = new PostgresConnection();
			this.conn = postgres.getInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Curso inserir(Curso curso) throws Exception {
		String sql = "Insert into Curso (nome)"
				+ "values (?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, curso.getNome()); 
		pstmt.executeUpdate();
		return curso;
	}

	@Override
	public Curso alterar(Curso curso) throws Exception {
		String sql = "Update Curso set nome = ? where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, curso.getNome());
		pstmt.setInt(7, curso.getId());
		pstmt.executeUpdate();
		return curso;
	}

	@Override
	public Boolean deletar(Curso curso) throws Exception {
		String sql = "Delete From Curso where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, curso.getId());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Curso> todos() throws Exception {
		String sql = "Select * From Curso ";
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		List<Curso> lista = new ArrayList<Curso>();
		Curso curso = null;
		while (res.next()) {
			curso = montar(res);			
			lista.add(curso);
		}
		return lista;
	}
	
	public Curso montar(ResultSet res) throws Exception{
		Curso curso = new Curso();
		curso.setId(res.getInt("id"));
		curso.setNome(res.getString("nome"));
		return curso;
	}
	
	@Override
	public Curso getPorId(Integer id) throws Exception {
		String sql = "Select * From Curso where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet res = pstmt.executeQuery();
		if (res.next()) {
			return montar(res);
		}
		return null;
	}

}
