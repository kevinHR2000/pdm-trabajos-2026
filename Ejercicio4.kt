/*
 █████  ██████  ██ ██    ██ ██ ███    ██  █████      ███    ██ ██    ██ ███    ███ ███████ ██████   ██████
██   ██ ██   ██ ██ ██    ██ ██ ████   ██ ██   ██     ████   ██ ██    ██ ████  ████ ██      ██   ██ ██    ██
███████ ██   ██ ██ ██    ██ ██ ██ ██  ██ ███████     ██ ██  ██ ██    ██ ██ ████ ██ █████   ██████  ██    ██
██   ██ ██   ██ ██  ██  ██  ██ ██  ██ ██ ██   ██     ██  ██ ██ ██    ██ ██  ██  ██ ██      ██   ██ ██    ██
██   ██ ██████  ██   ████   ██ ██   ████ ██   ██     ██   ████  ██████  ██      ██ ███████ ██   ██  ██████
Descripción: Adivinar el número entre 1 al 30 con 5 intentos
Autor: Kevin A. Haytara
Fecha de creación: 27/03/2026
Fecha ultima modificación: 29/03/2026
tiempo de duración:

 */


fun generarNumero(): Int {
    return (1..30).random();
}

fun mostrarPista(numeroSecreto: Int, intento: Int) {
    when {
        intento < numeroSecreto -> println("El número es MAYOR que $intento");
        intento > numeroSecreto -> println("El número es MENOR que $intento")
    }
}

fun mostrarIntentos(intentosRestantes: Int) {
    println("Te quedan $intentosRestantes intentos");
}

fun main() {
    println("*******************************");
    println("*     ADIVINA EL NÚMERO       *");
    println("*        ( 1 al 30 )          *");
    println("*******************************");

    val numeroSecreto = generarNumero();
    var intento: Int;
    var intentosRestantes = 5;
    var adivinado = false;

    // con 5 intentos maximo
    do {
        println("\nIngresa un número del 1 al 30:");
        intento = readLine()!!.toInt();
        //los guieones para que no genere un bucle infinitp
        intentosRestantes--;

        if (intento == numeroSecreto) {
            adivinado = true;
        } else {
            mostrarPista(numeroSecreto, intento);
            mostrarIntentos(intentosRestantes);
        }

    } while (!adivinado && intentosRestantes > 0)

    if (adivinado) {
        println("¡FELICIDADES! Adivinaste el número $numeroSecreto");
    } else {
        println("GAME OVER  El número era $numeroSecreto");
    }
}