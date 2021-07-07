package br.com.alura.carteira.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {

	private List<Transacao> transacoes = new ArrayList<>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Transacao t1 = new Transacao("ITSA4", LocalDate.of(2021, 1, 1), new BigDecimal("10.22"), 20,
				TipoTransacao.COMPRA);

		Transacao t2 = new Transacao("BBSE3", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20,
				TipoTransacao.COMPRA);

		transacoes.add(t1);
		transacoes.add(t2);

		req.setAttribute("transacoes", transacoes);

		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, res);
	}

}
