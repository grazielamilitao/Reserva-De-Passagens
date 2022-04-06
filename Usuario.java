package reservaDePassagens;

import java.util.Scanner;

public class Usuario {
	private String nome;
	private String CPF;
	
	public Usuario() {
		System.out.println("Digite seu nome:");
        this.nome = lerString();

		System.out.println("Digite seu CPF:");
        this.CPF = lerString();
	}
	
	public String lerString() {
		Scanner text= new Scanner(System.in);
		String txt = text.nextLine();
		
		return txt;
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
}
