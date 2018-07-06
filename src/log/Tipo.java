package log;

import java.io.Serializable;

import lista.Lista;

public class Tipo implements Serializable{
	private Lista<Mensagem> listaMsg;
	
	public Tipo() {
		listaMsg = new Lista<Mensagem>();
	}
	
	public static int INFO = 0;
	public static int ERROR = 1;
	public static int WARN = 2;
	public static int SUCCESS = 3;
	
	private int tipo;
	
	public Lista<Mensagem> getListaMsg() {
		return listaMsg;
	}
	public void setListaMsg(Lista<Mensagem> listaMsg) {
		this.listaMsg = listaMsg;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Tipo: "+(tipo==INFO?"INFO":
			tipo==ERROR?"ERROR":
			tipo==WARN?"WARN":
			tipo==SUCCESS?"SUCCESS":"");
	}
	
	public static Tipo strToTipo(String strTipo) {
		Tipo tipo = new Tipo();
		switch(strTipo.replaceAll("Tipo: ","")) {
		case "INFO":
			tipo.setTipo(INFO);
			break;
		case "ERROR":
			tipo.setTipo(ERROR);
			break;
		case "WARN":
			tipo.setTipo(WARN);
			break;
		case "SUCESS":
			tipo.setTipo(SUCCESS);
			break;
		}
		return tipo; 
	}
}
