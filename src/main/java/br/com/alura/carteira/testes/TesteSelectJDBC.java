package br.com.alura.carteira.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteSelectJDBC {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/carteira";
			String username = "root";
			String password = "root";
			Connection conexao = DriverManager.getConnection(url, username, password);
			
			TransacaoDao dao = new TransacaoDao(conexao);

			List<Transacao> transacoes = dao.listar();
			for (Transacao transacao : transacoes) {
				System.out.println(transacao);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro!");
		}
	}

}
