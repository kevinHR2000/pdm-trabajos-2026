/*
  ____      _            _           _                   _____ _                           _        _
 / ___|__ _| | ___ _   _| | __ _  __| | ___  _ __ __ _  | ____| | ___ _ __ ___   ___ _ __ | |_ __ _| |
| |   / _` | |/ __| | | | |/ _` |/ _` |/ _ \/ '__/ _` | |  _| | |/ _ \ '_ ` _ \ / _ \ '_ \| __/ _` | |
| |__| (_| | | (__| |_| | | (_| | (_| | (_) | | | (_| | | |___| |  __/ | | | | |  __/ | | | || (_| | |
 \____\__,_|_|\___|\__,_|_|\__,_|\__,_|\___/|_|  \__,_| |_____|_|\___|_| |_| |_|\___|_| |_|\__\__,_|_|
Descripción: crear una calculadora de 2 números en resolver con cada operación
Autor: Kevin A. Haytara.
Fecha de creación: 27/03/2026.
Fecha ultima modificación: 27/03/2026.

tiempo en completar: 180 minutos
 */
fun menu(){
    println("==== Menú ====");
    println("1. Suma");
    println("2. Resta");
    println("3. Multiplicación");
    println("4. División");
    println("5. Salir");
}
// El pair es un paso de kotlin que ayuda 2 variables devuelve entrega o retorna 1 variable
fun leerNumeros(): Pair<Double, Double>{
    println("Ingresa el primer número:");
    val numero1 = readLine()!!.toDouble();

    println("Ingresa el segundo número:");
    val numero2 = readLine()!!.toDouble();
    //devolver 2 valores en un función
    return Pair(numero1, numero2);
}

fun suma(numero1: Double, numero2: Double): Double{
    return numero1 + numero2;
}
fun resta(numero1: Double, numero2: Double): Double{
    return numero1 - numero2;
}
fun multiplicacion(numero1: Double, numero2: Double): Double{
    return numero1 * numero2;
}
fun division(numero1: Double, numero2: Double): Double{
    return numero1 / numero2;
}


fun main(){
    var opcion: Int;
    do{
        menu();
        opcion = readLine()!!.toInt();

        //evita pedir número
        if (opcion != 5){
            //recibir 2 valores
            val(numero1, numero2) = leerNumeros();
            val resultado: Double;

            when(opcion){
                1 -> resultado = suma(numero1, numero2);
                2 -> resultado = resta(numero1, numero2);
                3 -> resultado = multiplicacion(numero1, numero2);
                4 -> resultado = division(numero1, numero2);
                else -> resultado = 0.0;
            }
            println("Resultado: $resultado");
        } else{
            println("○○○○○○ Saliste ○○○○○○○○○");
        }//
    //elige
    } while (opcion != 5);

}