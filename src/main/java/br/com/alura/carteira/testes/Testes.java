package br.com.alura.carteira.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class Testes {

	public static void main(String[] args) {
		Transacao t = new Transacao();
		t.setTicker("ITSA4");
		t.setData(LocalDate.now());
		t.setPreco(new BigDecimal("10.50"));
		t.setQuantidade(50);
		t.setTipo(TipoTransacao.COMPRA);
		
		System.out.println(t.getTicker());
		System.out.println(t.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(t.getPreco());
		System.out.println(t.getQuantidade());
		System.out.println(t.getTipo());

		Transacao t2 = new Transacao(
				"BBSE3", 
				LocalDate.now(),
				new BigDecimal("23.50"),
				20,
				TipoTransacao.COMPRA);
		
		System.out.println(t2);
	}

}