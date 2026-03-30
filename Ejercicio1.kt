/*

███████╗██╗   ██╗ █████╗ ██╗     ██╗   ██╗ █████╗  ██████╗██╗ ██████╗ ███╗   ██╗
██╔════╝██║   ██║██╔══██╗██║     ██║   ██║██╔══██╗██╔════╝██║██╔═══██╗████╗  ██║
█████╗  ██║   ██║███████║██║     ██║   ██║███████║██║     ██║██║   ██║██╔██╗ ██║
██╔══╝  ╚██╗ ██╔╝██╔══██║██║     ██║   ██║██╔══██║██║     ██║██║   ██║██║╚██╗██║
███████╗ ╚████╔╝ ██║  ██║███████╗╚██████╔╝██║  ██║╚██████╗██║╚██████╔╝██║ ╚████║
╚══════╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝

                E V A L U A C I Ó N    E M P L E A D O


Descripción: Calcula el nivel de rendimiento de un empleado y el dinero que recibe según su puntuación y salario.

+--------------+-------------+
| Nivel        | Puntuación  |
+--------------+-------------+
| Inaceptable  | 0 a 3       |
| Aceptable    | 4 a 6       |
| Meritorio    | 7 a 10      |
+--------------+-------------+

Autor: Kevin A. Haytara.
Fecha creación: 25/03/2026.
Fecha ultima modificación: 26/03/2026.

tiempo en completar 270 minutos
---------------------------------------------------------------------------------------------------------------------
 */



fun determinarNivel(puntuacion: Int):String {
    //Condicion de del tipo de Dato y transfomrando a String
    val nivel: String;
    if (puntuacion <= 3) {
        nivel = "Inaceptable";
    } else if (puntuacion <= 6){
        nivel = "Aceptable";
    } else{
        nivel = "Meritorio";
    }
    return nivel;
}

fun calcularDinero(sueldo: Int, puntuacion: Int): Double {
    //El toDouble ayuda a no perder los decimales
    val division = puntuacion.toDouble() / 10.0;
    val dinero = sueldo.toDouble() * division;
    return dinero;
}

fun leerPuntuacion(): Int{
    var puntuacion: Int;
    do{
      println("Ingresa la puntuación (0 al 10): ");
        // El readLine le da la orden a la computadora. El usuario puede ingresar datos
      puntuacion = readLine()!!.toInt();
        // || = y
      if(puntuacion < 0 || puntuacion > 10){
          println("☻ Puntiación inválida, intenta de nuevo");
      }

    }while (puntuacion < 0 || puntuacion > 10);
    return puntuacion;
}



fun main(){
    println("Ingresa el dinero que recibe al mes:");
    val sueldo = readLine()!!.toInt();

    val puntuacion = leerPuntuacion();
    println("Putuación ingresada: $puntuacion");

    val dinero = calcularDinero(sueldo, puntuacion);
    println("Cantidad de Dinero Recibido: $dinero");

    val nivel = determinarNivel(puntuacion);
    println("Nivel de Rendimiento: $nivel");
}