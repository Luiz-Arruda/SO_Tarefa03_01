package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rede = new RedesController();
		
		int ops = 0;
		String os = System.getProperty("os.name");
		String suporte[] = new String [0];
		
		while (ops != 99) {
			ops = Integer.parseInt(JOptionPane.showInputDialog("Selecione \n 1 - Adpatador Ethernet \n 2 - Status PING \n 99 - Sair "));
			
			switch (ops) {
			
			case 1:
				rede.ip(os, suporte);
				break;
			
			case 2:
				rede.ping(os, suporte);
				break;
				
			case 99:
				JOptionPane.showInputDialog(null, "sair");
				break;
			
			default:
				JOptionPane.showMessageDialog(null,"Opção inválida");
				break;
			}	
		}
	}
}