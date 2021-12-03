package basico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoCtrl implements IAlunoCtrl{
	private Connection conn;
	
	public AlunoCtrl() {
		try {
			PostgresConnection postgres = new PostgresConnection();
			this.conn = postgres.getInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Aluno inserir(Aluno aluno) throws Exception {
		String sql = "Insert into Aluno (nome,altura,peso,idade,"
				+ " matricula,horasComplementares)"
				+ "values (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, aluno.getNome());
		pstmt.setDouble(2, aluno.getAltura());
		pstmt.setDouble(3, aluno.getPeso());
		pstmt.setInt(4, aluno.getIdade());
		pstmt.setString(5, aluno.getMatricula());
		pstmt.setDouble(6, aluno.getHorasComplementares());
		pstmt.executeUpdate();
		return aluno;
	}

	@Override
	public Aluno alterar(Aluno aluno) throws Exception {
		String sql = "Update aluno set nome = ?, altura = ?, peso = ?,"
				+ " idade = ?, matricula = ?, horascomplementares = ?"
				+ " where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, aluno.getNome());
		pstmt.setDouble(2, aluno.getAltura());
		pstmt.setDouble(3, aluno.getPeso());
		pstmt.setInt(4, aluno.getIdade());
		pstmt.setString(5, aluno.getMatricula());
		pstmt.setDouble(6, aluno.getHorasComplementares());
		pstmt.setInt(7, aluno.getId());
		pstmt.executeUpdate();
		return aluno;
	}

	@Override
	public Boolean deletar(Aluno aluno) throws Exception {
		String sql = "Delete From Aluno where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aluno.getId());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Aluno> todos() throws Exception {
		String sql = "Select * From Aluno ";
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		List<Aluno> lista = new ArrayList<Aluno>();
		Aluno aluno = null;
		while (res.next()) {
			aluno = montar(res);			
			lista.add(aluno);
		}
		return lista;
	}
	
	public Aluno montar(ResultSet res) throws Exception{
		Aluno aluno = new Aluno();
		aluno.setId(res.getInt("id"));
		aluno.setNome(res.getString("nome"));
		aluno.setMatricula(res.getString("matricula"));
		aluno.setHorasComplementares(
				res.getDouble("horascomplementares"));
		aluno.setAltura(res.getDouble("altura"));
		aluno.setPeso(res.getDouble("peso"));
		aluno.setIdade(res.getInt("idade"));
		return aluno;
	}
	
	@Override
	public Aluno getPorId(Integer id) throws Exception {
		String sql = "Select * From Aluno where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet res = pstmt.executeQuery();
		if (res.next()) {
			return montar(res);
		}
		return null;
	}

}
