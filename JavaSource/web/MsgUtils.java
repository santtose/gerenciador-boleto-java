package web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MsgUtils {
	
	/**
	 * Envia msg de sucesso 
	 * @param mensagem
	 */
	public static void enviarSucesso(String mensagem) {
		enviarMensagem(mensagem, FacesMessage.SEVERITY_INFO);
	}
	
	public static void enviarAtencao(String mensagem) {
		enviarMensagem(mensagem, FacesMessage.SEVERITY_WARN);
	}
	
	private static void enviarMensagem(String mensagem, FacesMessage.Severity severety) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(severety);
		message.setSummary(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
