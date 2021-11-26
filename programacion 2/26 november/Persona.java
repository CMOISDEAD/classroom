import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
	
	private String nombres;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private int edad;
	private String genero;
	private String tipoDocumentoIdentidad;
	private String numeroDocumentoIdentidad;
	private String direccion;
	private String telefono;
	private String nacionalidad;
	private static final String FECHANACIMIENTOPORDEFECTO = "2000-01-01";
	public static final String MASCULINO = "Masculino";
	public static final String FEMENINO = "Femenino";
	public static final String CC = "Cédula de Ciudadanía";
	public static final String CE = "Cédula de Extrangería";
	public static final String TI = "Tarjeta de Identidad";
	public static final String PP = "Pasaporte";
	public static final String NACIONALIDADPORDEFECTO = "Colombiano";

	public Persona(String nombres, String apellidos) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.setFechaNacimiento(FECHANACIMIENTOPORDEFECTO);
		this.genero = Persona.FEMENINO;
		this.tipoDocumentoIdentidad = Persona.CC;
		this.nacionalidad = Persona.NACIONALIDADPORDEFECTO;
	}
	
	public Persona(String nombres, String apellidos, String fechaNaciiento) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		
		this.setFechaNacimiento(fechaNaciiento);
	}
	
	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	protected String getFechaNacimiento() {
		return fechaNacimiento.toString();
	}

	protected void setFechaNacimiento(String fechaNacimiento) {
		 DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatoFecha);
		 this.calcularEdad();
	}

	public int getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if(genero != Persona.MASCULINO && genero != Persona.FEMENINO) {
			this.genero = Persona.FEMENINO;
		} else {
			this.genero = genero;
		}
	}

	protected String getTipoDocumentoIdentidad() {
		return tipoDocumentoIdentidad;
	}

	protected void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
		if(	tipoDocumentoIdentidad != Persona.CC || 
			tipoDocumentoIdentidad != Persona.CE ||
			tipoDocumentoIdentidad != Persona.TI ||
			tipoDocumentoIdentidad != Persona.PP) {
			this.tipoDocumentoIdentidad = Persona.CC;
		} else {
			this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
		}
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	protected String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	protected void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	protected String getDireccion() {
		return direccion;
	}

	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	protected String getTelefono() {
		return telefono;
	}

	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getNacionalidad() {
		return this.nacionalidad;
	}

	private void calcularEdad() {
		this.edad = Period.between(this.fechaNacimiento,  LocalDate.now()).getYears();

	}
}
