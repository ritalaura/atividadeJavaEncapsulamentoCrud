package exercicioJavaEncapsulamentoCrud;

public class Carro {
	private String placa;
	private String modelo;
	private String cor;
	private int id;

	public Carro(String _placa, String _modelo, String _cor, int _id) {
		this.placa = _placa;
		this.cor = _cor;
		this.modelo = _modelo;
		this.id = _id;
	}

	public Carro() {

	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
