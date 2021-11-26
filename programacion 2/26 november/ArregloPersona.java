public class ArregloPersona {
	
	Persona listadoPersona[];
	private static  final int TOTALPERSONAS = 10;
	private  String [] listadoNombres;
	private  String [] listadoApellidos;

	public ArregloPersona() {
		this.listadoNombres = new String[10];
		this.listadoNombres[0] = "Jose";
		this.listadoNombres[1] = "Pedro";
		this.listadoNombres[2] = "Juan";
		this.listadoNombres[3] = "Rafael";
		this.listadoNombres[4] = "Maria";
		this.listadoNombres[5] = "Juana";
		this.listadoNombres[6] = "Lucia";
		this.listadoNombres[7] = "Luz";
		this.listadoNombres[8] = "Stella";
		this.listadoNombres[9] = "Rocío";
		
		this.listadoApellidos = new String[10];
		this.listadoApellidos[0] = "Botero";
		this.listadoApellidos[1] = "Martínez";
		this.listadoApellidos[2] = "Jaramillo";
		this.listadoApellidos[3] = "Taborda";
		this.listadoApellidos[4] = "Arias";
		this.listadoApellidos[5] = "Jiménez";
		this.listadoApellidos[6] = "Arías";
		this.listadoApellidos[7] = "Castillo";
		this.listadoApellidos[8] = "Meza";
		this.listadoApellidos[9] = "Carvajal";
		
		this.listadoPersona = new Persona[ArregloPersona.TOTALPERSONAS];
		
		for(int i = 0; i < listadoPersona.length; i++){
			
			String nombre 	= listadoNombres[Number.generateRandomIntegerNumberUpTo(this.listadoNombres.length-1)];
			String apellido = listadoApellidos[Number.generateRandomIntegerNumberUpTo(this.listadoApellidos.length -1)];
			int anoNacimiento = 1960 +  Number.generateRandomIntegerNumberUpTo(50);
			//System.out.println(anoNacimiento);
			
			this.listadoPersona[i] = new Persona(nombre, apellido, anoNacimiento+"-01-01");


      // String genero = Number.generateRandomIntegerNumberUpTo(2) == 1?Persona.FEMENINO:Persona.MASCULINO;
      int option = Number.generateRandomIntegerNumberUpTo(2);
      String genero = "";
      if (option == 1){
        genero = Persona.FEMENINO;
      }else{
        genero = Persona.MASCULINO;
      }
      		this.listadoPersona[i].setGenero(genero);
		}
		
	}
	
	private void imprimirPersonas() {
		for(int i = 0; i< listadoPersona.length; i++){
			Persona p = listadoPersona[i];
			System.out.println("["+i+"] - "+p.getNombres() + " " + p.getApellidos()+ " - " + p.getEdad() );
		}
		
	}
	
	double calcularPromedioEdad() {
		double promedioEdad = 0.0;
		for(int i = 0; i< this.listadoPersona.length; i++){
			promedioEdad += this.listadoPersona[i].getEdad();
		}
		
		return promedioEdad/(double)this.listadoPersona.length;	
	}
	
	int personasApellidoIniciaCon(char letra) {
		int contador = 0;
		
		for(int i = 0; i< this.listadoPersona.length; i++){
			if (this.listadoPersona[i].getApellidos().charAt(0) == letra ||
				this.listadoPersona[i].getApellidos().charAt(0) == Character.toUpperCase(letra)) {
				contador++;
			}
		}
		
		return contador;
	}

	public static void main(String[] args) {
		
		ArregloPersona aP = new ArregloPersona();
		aP.imprimirPersonas();
		char letra = 'c';
		System.out.println("Promedio edad: " +aP.calcularPromedioEdad());
		System.out.println("Apellidos que comienzan con ("+letra+") ó "+ 
		Character.toUpperCase(letra)+"): " +   aP.personasApellidoIniciaCon(letra));
	}
	
	/*
	 * generateRandomIntegerNumberUpTo
	 */

}
