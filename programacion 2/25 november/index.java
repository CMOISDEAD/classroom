/**
 * @author : camilo
 * @created : 2021-11-25
**/

/**
 * Promedio carga y pasajeros
**/

class  Avion {
    String fabricante, modelo;
    int capacidadPasajeros, capacidadCarga, maximaAltitud;

    Avion (String fabricante, String modelo, int capacidadPasajeros, int capacidadCarga, int maximaAltitud){
     this.fabricante = fabricante; 
     this.modelo = modelo;
     this.capacidadCarga = capacidadCarga; 
     this.capacidadPasajeros = capacidadPasajeros;
     this.maximaAltitud = maximaAltitud;
    }  
}

class index {
  
  public static void main(String args[]) {
    Avion A1 = new Avion("RZA","RZA1", 281, 300, 100);
    Avion A2 = new Avion("GZA","GZA1", 282, 300, 200);
    Avion A3 = new Avion("DMX","DMX1", 283, 300, 300);
    Avion A4 = new Avion("Nas","Nas1", 284, 300, 400);
    
    Avion A5 = new Avion("RZA","RZA2", 285, 300, 150);
    Avion A6 = new Avion("GZA","GZA2", 286, 300, 250);
    Avion A7 = new Avion("DMX","DMX2", 287, 300, 350);
    Avion A8 = new Avion("Nas","Nas2", 287, 300, 450);

    /* Capacidad de carga
     * @fix : calcular todos los promedios;
     * */
    int[] listadoAvionesCapacidad = new int[4];

    listadoAvionesCapacidad[0] = A1.capacidadPasajeros;
    listadoAvionesCapacidad[1] = A2.capacidadPasajeros;
    listadoAvionesCapacidad[2] = A3.capacidadPasajeros;
    listadoAvionesCapacidad[3] = A4.capacidadPasajeros;
    
    double promedio = promedioPasajeros(listadoAvionesCapacidad);

    /* Matriz Alturas 
     * */
    int[] matrizAlturas = new int[8]; 

    matrizAlturas[0] = A1.maximaAltitud;
    matrizAlturas[1] = A2.maximaAltitud;
    matrizAlturas[2] = A3.maximaAltitud;
    matrizAlturas[3] = A4.maximaAltitud;

    matrizAlturas[4] = A5.maximaAltitud;
    matrizAlturas[5] = A6.maximaAltitud;
    matrizAlturas[6] = A7.maximaAltitud;
    matrizAlturas[7] = A8.maximaAltitud;

    matrizAlturaMarca(matrizAlturas);
  }

  // Funciones
  public static double[] matrizAlturaMarca (int[] aviones){
    double[] matrix = new double[aviones.length-1];
    
    for (int i = 0; i< aviones.length; i++) {
      
    }

    return matrix;
  }

  public static double promedioPasajeros(int[] aviones){
    double promedio = 0;

    for (int i = 0; i< aviones.length; i++) {
      promedio += aviones[i];
    }

    promedio = promedio/aviones.length;
    return promedio;
  }
}
