package modelo;

public enum EstadoTareaEnum {
	porAsignar("Por asignar"),
	porHacer("Por hacer"),
	completado("Completado");
	
	private final String texto;

	private EstadoTareaEnum(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
	
	
	
}
