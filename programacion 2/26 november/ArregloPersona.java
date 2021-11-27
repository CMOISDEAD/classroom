public class ArregloPersona {

  Persona listadoPersona[];
  private static final int TOTALPERSONAS = 5;
  private String[] listadoNombres;
  private String[] listadoApellidos;

  public ArregloPersona() {
    this.listadoNombres = new String[10];
    this.listadoNombres[0] = "Jose";
    this.listadoNombres[1] = "Pedro";
    this.listadoNombres[2] = "Juan";
    this.listadoNombres[3] = "Camilo";
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
    this.listadoApellidos[3] = "Vargas";
    this.listadoApellidos[4] = "Davila";
    this.listadoApellidos[5] = "Jiménez";
    this.listadoApellidos[6] = "Arías";
    this.listadoApellidos[7] = "Castillo";
    this.listadoApellidos[8] = "Meza";
    this.listadoApellidos[9] = "Carvajal";

    this.listadoPersona = new Persona[ArregloPersona.TOTALPERSONAS];

    for (int i = 0; i < listadoPersona.length; i++) {

      String nombre =
          listadoNombres[Number.generateRandomIntegerNumberUpTo(this.listadoNombres.length - 1)];
      String apellido =
          listadoApellidos[
              Number.generateRandomIntegerNumberUpTo(this.listadoApellidos.length - 1)];
      int anoNacimiento = 1960 + Number.generateRandomIntegerNumberUpTo(50);

      String genero =
          Number.generateRandomIntegerNumberUpTo(2) == 1 ? Persona.FEMENINO : Persona.MASCULINO;
      this.listadoPersona[i] = new Persona(nombre, apellido, anoNacimiento + "-01-01");

      this.listadoPersona[i].setGenero(genero);
    }
  }

  private void imprimirPersonas() {
    for (int i = 0; i < listadoPersona.length; i++) {
      Persona p = listadoPersona[i];
      System.out.println(
          "["
              + i
              + "] - "
              + p.getNombres()
              + " "
              + p.getApellidos()
              + " - "
              + p.getEdad()
              + " - "
              + p.getGenero());
    }
  }

  double calcularPromedioEdad() {
    double promedioEdad = 0.0;
    for (int i = 0; i < this.listadoPersona.length; i++) {
      promedioEdad += this.listadoPersona[i].getEdad();
    }

    return promedioEdad / (double) this.listadoPersona.length;
  }

  int personasApellidoIniciaCon(char letra) {
    int contador = 0;

    for (int i = 0; i < this.listadoPersona.length; i++) {
      if (this.listadoPersona[i].getApellidos().charAt(0) == letra
          || this.listadoPersona[i].getApellidos().charAt(0) == Character.toUpperCase(letra)) {
        contador++;
      }
    }

    return contador;
  }

  /*
   * Punto 1: Metodo calcular edad promedio personas femenino menores.
   * */

  double promedioEdadMujeresMenores() {
    double retorno = 0;
    int cantidad = 0;

    for (int i = 0; i < this.listadoPersona.length; i++) {
      if (this.listadoPersona[i].getGenero() == Persona.FEMENINO
          && this.listadoPersona[i].getEdad() < 18) {
        retorno += this.listadoPersona[i].getEdad();
        cantidad++;
      }
    }

    retorno = retorno / cantidad; 

    System.out.println("[Promedio edad mujeres menores 18] " + Math.round(retorno * 100.0) / 100.0);
    return Math.round(retorno * 100.0) / 100.0;
  }

  /*
   * Punto 3: Metodo devolver promedio edad hombres y mujeres.
   * */

  double[] promedioEdadGenero() {
    double[] retorno = new double[2];
    int promM = 0, promH = 0;

    int[] cantidadGenero = conteoGlobal(false);

    for (int i = 0; i < this.listadoPersona.length; i++) {
      if (this.listadoPersona[i].getGenero() == Persona.FEMENINO) {
        promM += this.listadoPersona[i].getEdad();
      } else {
        promH += this.listadoPersona[i].getEdad();
      }
    }

    retorno[0] = promM / cantidadGenero[0];
    retorno[1] = promH / cantidadGenero[1];

    System.out.println("[Promedio Edad Femenino] " + retorno[0]);
    System.out.println("[Promedio Edad Masculino] " + retorno[1]);

    return retorno;
  }

  /*
   *  Punto 4: metodo contador de hombre y mujeres.
   * */

  int[] conteoGlobal(boolean cmd) {
    int hombres = 0, mujeres = 0;
    int retorno[] = new int[2];

    for (int i = 0; i < this.listadoPersona.length; i++) {
      if (this.listadoPersona[i].getGenero() == Persona.MASCULINO) {
        hombres++;
      } else {
        mujeres++;
      }
    }
    retorno[0] = mujeres;
    retorno[1] = hombres;

    if (cmd) {
      System.out.println("[Cantidad Mujeres] " + retorno[0]);
      System.out.println("[Cantidad Hombres] " + retorno[1]);
    }

    return retorno;
  }

  /*
   * Punto 5: Devolver mujeres con apellido en especifico.
   * */

  public String[] mujeresApellidoE() {
    String[] retorno = new String[TOTALPERSONAS];
    for (int i = 0; i < this.listadoPersona.length; i++) {
      if (this.listadoPersona[i].getGenero() == Persona.FEMENINO
          && this.listadoPersona[i].getApellidos() == "Davila") {
        String nombreCompleto =
            this.listadoPersona[i].getNombres() + " " + this.listadoPersona[i].getApellidos();
        retorno[i] = nombreCompleto;
      }
    }

    for (int i = 0; i < retorno.length; i++) {
      if (retorno[i] != null) {
        System.out.println("[Davila] " + retorno[i]);
      }
    }

    return retorno;
  }

  /*
   * Void Main
   * */
  public static void main(String[] args) {
    ArregloPersona aP = new ArregloPersona();
    aP.imprimirPersonas();
    aP.conteoGlobal(true);
    aP.mujeresApellidoE();
    aP.promedioEdadGenero();
    aP.promedioEdadMujeresMenores();
  }

  /*
   * generateRandomIntegerNumberUpTo
   */
}
