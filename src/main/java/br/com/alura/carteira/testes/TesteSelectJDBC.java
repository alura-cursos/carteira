package br.com.alura.carteira.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteSelectJDBC {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/carteira";
			String username = "root";
			String password = "root";
			Connection conexao = DriverManager.getConnection(url, username, password);

			String sql = "select * from transacoes";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Transacao t = new Transacao();
				
				t.setTicker(rs.getString("ticker"));
				t.setPreco(rs.getBigDecimal("preco"));
				t.setQuantidade(rs.getInt("quantidade"));
				t.setData(rs.getDate("data").toLocalDate());
				t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));

				System.out.println(t);
				System.out.println("==========================================");
			}
		} catch (Exception e) {
			System.out.println("Erro ao conectar com MySQL!");
		}
	}

}
