package reservaDePassagens;

import java.util.*;

/*Autor: Paula Graziela Militão Valadares*/

public class ReservaPassagem {
	private static ArrayList<Usuario> passageiro= new ArrayList<>();
	private static ArrayList<Passagem> passagem= new ArrayList<>();
	private static ArrayList<Rota> rota= new ArrayList<>();
	
	//metodos de busca
	public Passagem buscarPassagem(String origem, String destino, String CPF) {
		for(Passagem passagem : this.passagem) {
			int valueOrigem = passagem.getRota().getOrigem().compareTo(origem);
			int valueDestino = passagem.getRota().getDestino().compareTo(destino);
			int valueCPF = passagem.getPassageiro().getCPF().compareTo(CPF);
			if(valueOrigem == 0 && valueDestino == 0 && valueCPF == 0) {
				return passagem;
			}
		}
		return null;
	}
	
	public Usuario buscarUsuario(String cpf) {
		for(Usuario usuario : this.passageiro) {
			int value = usuario.getCPF().compareTo(cpf);
			if(value==0) {
				return usuario;
			}
		}
		return null;
	}
	
	public Rota buscarRota(String origem, String destino) {
		for(Rota rotas: this.rota) {
			int valueOrigem = rotas.getOrigem().compareTo(origem);
			int valueDestino = rotas.getDestino().compareTo(destino);
			if(valueOrigem==0 && valueDestino==0) {
				return rotas;
			}
		}
		return null;
	}
	
	//metodos de leitura
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
	
	//metodos de cadastro
	public Usuario cadastrarUser() {
		Usuario user = new Usuario();
		Usuario busca = buscarUsuario(user.getCPF());
		
		while(busca!=null) {
			System.out.println("Usuário já cadastrado. Por favor, insira um CPF diferente.");
			user = new Usuario();
			busca = buscarUsuario(user.getCPF());
		}

		passageiro.add(user);
		
		return user;
	}
	
	public Rota cadastrarRotas() {
		Rota rota = new Rota();
		Rota busca = buscarRota(rota.getOrigem(), rota.getDestino());
		
		while(busca!=null && busca.getHoraVoo()==rota.getHoraVoo() && busca.getDataVoo()==rota.getDataVoo()) {
			System.out.println("Rota já cadastrado. Por favor, insira outra.");
			rota = new Rota();
			busca = buscarRota(rota.getOrigem(), rota.getDestino());
		}

		this.rota.add(rota);
		
		return rota;
	}

	public void menu() {
		
		int opcao = 0;
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------- Menu -----------------");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Reservar passagem");
			System.out.println("2 - Cancelamento de Reservas");
			System.out.println("3 - Cadastrar Usuario");
			System.out.println("4 - Cadastrar Rota");
			System.out.println("5 - Visualizar Rotas");
			System.out.println("0 - Sair");
			
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Você está cadastro? (0 para SIM ou 1 para NÃO)");
				int cadastrado = lerInt();
				
				if(cadastrado == 0) {
					System.out.println("Digite seu CPF:");
					String CPF = lerString();
					
					System.out.println("Digite o local de origem:");
					String origem = lerString();
					
					System.out.println("Digite o local de origem:");
					String dest = lerString();
					

					Rota rota = buscarRota(origem,dest);
					Usuario user = buscarUsuario(CPF);
					if(user!=null && rota!=null) {
						int passagemJaCadastra = 0;
						for(Passagem passagem : this.passagem) {
							if(passagem.getPassageiro() == user)
								passagemJaCadastra = 1;
						}
						if(passagemJaCadastra == 0 && rota.getNumeroPoltronas()>0) {
							Passagem pass = new Passagem();
							pass.setPassageiro(user);
							pass.setRota(rota);
							rota.setNumeroPoltronas(rota.numeroPoltronas-1);
							passagem.add(pass);
							
							System.out.println("Reserva feita com sucesso!");
						}
						else if(passagemJaCadastra == 1){
							System.out.println("Um lugar neste voo já está reservado para esse CPF.");
						}
						else {
							System.out.println("Não há mais lugares disponíveis neste voo.");
						}
					}
					else if(rota==null){
						System.out.println("Rota não encontrada.");
					}
					else {
						System.out.println("Passageiro não encontrada.");						
					}
					menu();
					
				}else if(cadastrado == 1){
					System.out.println("Cadastre-se na opção (3) para reservar uma passagem.");
					menu();
				}
				else {
					System.out.println("Opção Inválida.");		
				}
				break;
			case 2:
				System.out.println("Digite seu CPF:");
				String CPF = lerString();
				
				System.out.println("Digite o local de origem:");
				String origem = lerString();
				
				System.out.println("Digite o local de origem:");
				String dest = lerString();
				
				Passagem pass = buscarPassagem(origem, dest, CPF);
				if(pass!=null) {
					passagem.remove(pass);
					pass.getRota().setNumeroPoltronas(pass.getRota().getNumeroPoltronas()+1);
					
					System.out.println("Reserva cancelada com sucesso!");
				}
				else
					System.out.println("Passagem não encontrada! Tente novamente.");
				menu();
				break;
			case 3:
				Usuario user = cadastrarUser();
				System.out.println(user.getNome() + " cadastrado (a) com sucesso!\n");
				menu();
				break;
			case 4:
				Rota rota = cadastrarRotas();
				System.out.println("Rota com embarque em "+rota.getOrigem()+" e desembarque em "
						+rota.getDestino()+" as "+rota.getHoraVoo()+" no dia "+rota.getDataVoo()+""
						+ " cadastrada com sucesso!\n");
				menu();
				break;
			case 5:
				if(this.rota.size()>0) {
					System.out.println("Rotas disponíveis: ");
					for(Rota rotas: this.rota) {
						System.out.println(rotas.toString());
					}
				}
				else
					System.out.println("Não existem rotas cadastradas.");
				
				break;
			case 0:
                System.exit(0);
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			
		} while(opcao!=0 || opcao<0 || opcao>2);
		
	}

	public static void main(String[] args){
		ReservaPassagem reserva = new ReservaPassagem();
		reserva.menu();
	}
}
