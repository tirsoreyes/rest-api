package pedro.rest.apprestpedro.modelo;

public class RespuestaGenerica <T> {
	private int codigo;
	private String mensaje;
	private T cuerpo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(T cuerpo) {
		this.cuerpo = cuerpo;
	}

	
	
	
}
