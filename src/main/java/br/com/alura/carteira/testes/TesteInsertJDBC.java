package br.com.alura.carteira.testes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteInsertJDBC {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/carteira";
			String username = "root";
			String password = "root";
			Connection conexao = DriverManager.getConnection(url, username, password);
			
			TransacaoDao dao = new TransacaoDao(conexao);
			Transacao t = new Transacao("BBSE3", LocalDate.now(), new BigDecimal("23.50"), 20, TipoTransacao.COMPRA);

			dao.salvar(t);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro!");
		}
	}

}
