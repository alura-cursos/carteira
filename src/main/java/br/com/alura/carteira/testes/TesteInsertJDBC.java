package br.com.alura.carteira.testes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteInsertJDBC {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/carteira";
			String username = "root";
			String password = "root";
			Connection conexao = DriverManager.getConnection(url, username, password);

			Transacao t = new Transacao(
					"BBSE3", 
					LocalDate.now(),
					new BigDecimal("23.50"),
					20,
					TipoTransacao.COMPRA);
			
			String sql = "insert into transacoes(ticker, preco, quantidade, data, tipo) values(?,?,?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, t.getTicker());
			ps.setBigDecimal(2, t.getPreco());
			ps.setInt(3, t.getQuantidade());
			ps.setDate(4, Date.valueOf(t.getData()));
			ps.setString(5, t.getTipo().toString());

			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro ao conectar com MySQL!");
		}
	}

}
