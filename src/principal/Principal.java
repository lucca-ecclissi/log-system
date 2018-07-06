package principal;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import log.Log;
import log.Tipo;
import logica.Arquivo;

public class Principal {
	public static void main(String[] args) {
		String menu = "\t\tMENU\n"
				+ "Escolha uma opção:\n"
				+ "\t1- Adicionar LOG\n"
				+ "\t2- Mostrar LOGs\n"
				+ "\t3- Mostrar Aquivo\n"
				+ "\t4- Remover Log\n"
				+ "\t5- Alterar Log\n"
				+ "\t6- Sair";
		
	    Scanner sc = new Scanner(System.in);
	    Log m = new Log();
	    do {
	    	System.out.print(menu);
	    	if(sc.hasNext()) {
	    		switch (sc.nextInt()) {
				case 1:
					System.out.println("Informe o TIPO (0-INFO/1-ERROR/2-WARN/3-SUCCESS):");
					int tipo = sc.nextInt();
					tipo = (tipo  == Tipo.INFO || tipo  == Tipo.ERROR || tipo  == Tipo.WARN || tipo  == Tipo.SUCCESS)? tipo :1;
					System.out.println("Informe a Mensagem:");
					sc = new Scanner(System.in);
					String msgs = sc.nextLine();
					m.carregar();
					m.log(new Date(), tipo, msgs);
					m.salvar();
					m.salvarBinary();
					break;
				case 2:
					m.carregarBinary();
					m.carregar();
					m.mostrar();
					break;
				case 3:
					try {
						Runtime.getRuntime().exec("gedit bin.log");
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					m.carregarBinary();
					sc = new Scanner(System.in);
					System.out.println("Informe a Mensagem exata:");
					String msg = sc.nextLine();
					m.remover(msg);
					break;
				case 5:
					m.carregarBinary();
					sc = new Scanner(System.in);
					System.out.println("Informe a Mensagem exata:");
					String msgAntiga = sc.nextLine();
					System.out.println("Informe a nova Mensagem:");
					String msgNova = sc.nextLine();
					m.alterar(msgAntiga,msgNova);
					break;
				case 6:
					sc.close(); 
					return;
				}
	    	}
	    }
	    while(true);//Encerra o programa
	}
}
