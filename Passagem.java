package reservaDePassagens;

import java.util.Scanner;

public class Passagem {
	private Rota rota;
	private Usuario passageiro;
	
	//getters e setters
	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Usuario getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Usuario passageiro) {
		this.passageiro = passageiro;
	}


}
