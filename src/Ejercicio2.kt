
/*
  _____ _ _      _____     _      _____     _
 |_   _(_) | __ |_   _|_ _| | __ |_   _|__ | | __
   | | | | |/ /   | |/ _` | |/ /   | |/ _ \| |/ /
   | | | |   <    | | (_| |   <    | | (_) |   <
   |_| |_|_|\_\   |_|\__,_|_|\_\   |_|\___/|_|\_\
  -----------------------------------------------
   PIEDRA  •  PAPEL  •  TIJERA

Descripcióm: Escriba un programa que realice el juego de piedra, papel o tijera.
 Imprimir si ganó, perdió o empató.

Autor: Kevin A. Haytara.
Fecha creación: 26/03/2026.
Fecha ultima modificación: 27/03/2026.

//tiempo en completar 225 minutos
 */

fun mostrarMenu(){
    println("Elige tu opción:");
    println("1. Piedra");
    println("2. Papel");
    println("3. Tijera");

    println(" _______                         _______                             _______");
    println(" ---'   ____)                ---'   ____)____                    ---'   ____)____");
    println("|      (_____)              |           ______)                 |          ______)");
    println("|      (_____)              |           _______)                |       __________)");
    println("|      (____)               |         _______)                  |       (____)");
    println(" ---.__(___)                 ---.__________)                     ---.__(___)");


}

fun determinarGanador(eleccionUsuario: String, eleccionPc: String): String {
    val resultadoFinal: String
    // las 9 posibilidades de resultado con los parametos no mutables y de retorno como String
    when {
        eleccionUsuario == "Piedra" && eleccionPc == "Piedra" -> resultadoFinal = "Empate";
        eleccionUsuario == "Piedra" && eleccionPc == "Papel"  -> resultadoFinal = "Perdiste";
        eleccionUsuario == "Piedra" && eleccionPc == "Tijera" -> resultadoFinal = "Ganaste";
        eleccionUsuario == "Papel"  && eleccionPc == "Piedra" -> resultadoFinal = "Ganaste";
        eleccionUsuario == "Papel"  && eleccionPc == "Papel"  -> resultadoFinal = "Empate";
        eleccionUsuario == "Papel"  && eleccionPc == "Tijera" -> resultadoFinal = "Perdiste";
        eleccionUsuario == "Tijera" && eleccionPc == "Piedra" -> resultadoFinal = "Perdiste";
        eleccionUsuario == "Tijera" && eleccionPc == "Papel"  -> resultadoFinal = "Ganaste";
        eleccionUsuario == "Tijera" && eleccionPc == "Tijera" -> resultadoFinal = "Empate";
        else                                                  -> resultadoFinal = "Jugador no eligio intente otra vez";
    }

    return resultadoFinal;
}


fun eligeComputadora(): String{
    //eligiendo un numero aleatorio
    val opcionPc = (1..3).random();
    //al escoger un número compara con la funcion convertirOpcion y se crea una nueva variable
    return convertirOpcion(opcionPc);
}

fun convertirOpcion(opcion: Int): String {
    val resultado: String;
    // La variable no es mutable y se usa la condición when
    when (opcion) {
        1 -> resultado = "Piedra";
        2 -> resultado = "Papel";
        3 -> resultado = "Tijera";
        else -> resultado = "Opción inválida";
    }

    return resultado;
}

fun main(){
    mostrarMenu();
    val opcion = readLine()!!.toInt();
    val eleccionUsuario = convertirOpcion(opcion);
    val eleccionPc = eligeComputadora();


    println("Tú Elegiste: $eleccionUsuario");
    println("Pc eligio: $eleccionPc");

    val resultadoFinal = determinarGanador(eleccionUsuario, eleccionPc);
    println("Resultado: $resultadoFinal");
}