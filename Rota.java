package reservaDePassagens;

import java.util.Scanner;

public class Rota {
	private String origem;
	private String destino;
	int numeroPoltronas;
	private String data;
	private String hora;
	
	public Rota() {
		System.out.println("Digite a origem:");
        this.origem = lerString();

		System.out.println("Digite o destino:");
        this.destino = lerString();
        
		System.out.println("Digite o numero de acentos disponíveis:");
        this.numeroPoltronas = lerInt();
        
		System.out.println("Digite a data:");
        this.data = lerString();

		System.out.println("Digite o hora:");
        this.hora = lerString();
	}
	
	public String lerString() {
		Scanner text= new Scanner(System.in);
		String txt = text.nextLine();
		
		return txt;
	}
	
	public int lerInt() {
		Scanner text= new Scanner(System.in);
		int txt = text.nextInt();
		
		return txt;
	}

	@Override
	public String toString(){
		return "Origem: "+this.origem+
				", Destino: "+this.destino+
				", Data: "+this.data+
				", Hora: "+this.hora+
				", Numero de passagens disponíves: "+this.numeroPoltronas;
	}
	
	//getters e setters
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getNumeroPoltronas() {
		return numeroPoltronas;
	}

	public void setNumeroPoltronas(int numeroPoltronas) {
		this.numeroPoltronas = numeroPoltronas;
	}
	public String getDataVoo() {
		return data;
	}

	public void setDataVoo(String dataVoo) {
		this.data = dataVoo;
	}

	public String getHoraVoo() {
		return hora;
	}

	public void setHoraVoo(String horaVoo) {
		this.hora = horaVoo;
	}
}
