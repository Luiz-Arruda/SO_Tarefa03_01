package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class RedesController {
	public RedesController() {
		super();
	}
	
	public void ip (String so, String [] suporte) {
        String processo = "";
        
        if(so.contains("indows")) {
                processo = "ipconfig";
                JOptionPane.showMessageDialog(null,"Seu Sistema Operacional é:\n"+so);
        } else
            if(so.contains("inux")) {
                processo = "ifconfig";
                JOptionPane.showMessageDialog(null,"Seu Sistema Operacional é:\n"+so);
            } 


        try {
            Process p = Runtime.getRuntime().exec(processo);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();


            while (linha != null) {
                linha = buffer.readLine();
                suporte = linha.split(" ");
                for (int i = 0; i < suporte.length; i++) {
                    if (suporte[i].contains("Ethernet")) {
                        JOptionPane.showMessageDialog(null,"O nome do Adaptador Ethernet:\n"+linha);
                    }
                    if (suporte[i].contains("IPv4")) {
                        JOptionPane.showMessageDialog(null,"E o IPv4 é:\n"+linha);
                    }
                }  
            } 
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
    }  

	
    public void ping (String os, String [] suporte) {
        String processo = "";

        if(os.equalsIgnoreCase("Windows 10")) {
            processo = "ping -n 10 www.google.com.br";
        } else 
            if(os.equalsIgnoreCase("Linux")) {
                processo = "ping -c 10 www.google.com.br";
            } 

        try {
            Process p = Runtime.getRuntime().exec(processo);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {
                linha = buffer.readLine();
                suporte = linha.split(" ");
            
                for (int i = 0; i < suporte.length; i++) {
                    if (suporte[i].contains("time") || suporte[i].contains("tempo")) {
                        JOptionPane.showMessageDialog(null,suporte[i]);
                    }
                
                    if (suporte[i].contains("Media") || suporte[i].contains("Average")) {
                        JOptionPane.showMessageDialog(null,"E o tempo médio é: \n"+linha);
                    }
                }  
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


		
