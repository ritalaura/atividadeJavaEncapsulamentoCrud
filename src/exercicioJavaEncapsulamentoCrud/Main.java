package exercicioJavaEncapsulamentoCrud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		var kwid = new Carro("MHG-789", "Renault kwid", "Preto", 1);
		var peugeot = new Carro("TSG-789", "peugeot 307", "branco", 2);
		
		var dao = new CarroDAO();
		
		dao.inserirCarro(kwid);
		dao.inserirCarro(peugeot);
		
		dao.deletarCarro(peugeot.getId());
		
		kwid.setCor("rosa");
		dao.atulizarCarro(kwid.getId(), kwid);
		
		
		
		var kwidAtualizado = dao.obterCarro(kwid.getId());
		
		System.out.println(kwidAtualizado.getPlaca());
		System.out.println(kwidAtualizado.getModelo());
		System.out.println(kwidAtualizado.getCor());
	}

}
