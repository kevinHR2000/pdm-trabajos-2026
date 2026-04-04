/*
╔════════════════════════════════════╗
║  CÁLCULO DE ÁREAS Y PERÍMETROS     ║
╚════════════════════════════════════╝
Descripción: Busca la áres y perimetro de cuadrado, rectangulo, circulo
Autor: Kevin A. Haytara
Fecha de creación: 04/04/2026
Fecha última modificación: 04/04/2026
Duración: 90 minutos
*/
//la clase abstracta Shape
abstract class Shape {
    abstract val area: Double;
    abstract val perimetro: Double;

    fun imprimirResultados() {
        println("Área: $area");
        println("Perímetro: $perimetro");
    }
}

//Subclase Cuadrado
class Cuadrado(
    private val lado: Double) : Shape() {
    //implenta al cuadrado
    override val area: Double
        //Calcula y retorna el área cada vez que se accede a la propiedad
        get() = lado * lado;

    override val perimetro: Double
        //Calcula y retorna el perímetro cada vez que se accede a la propiedad
        get() = 4 * lado;
}

//Subclase Rectangulo
class Rectangulo(
    private val base: Double,
    private val altura: Double) : Shape() {
    override val area: Double
        get() = base * altura;

    override val perimetro: Double
        get() = 2 * (base + altura);
}

//Subclase Circulo
class Circulo(
    private val radio: Double) : Shape() {
    override val area: Double
        get() = 3.1416  * radio * radio;

    override val perimetro: Double
        get() = 2 * 3.1416 * radio;
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    println("=== Cuadrado (lado=5) ===");
    //llama al método heredado de shape
    cuadrado.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    println("=== Rectángulo (base=4, altura=6) ===");
    rectangulo.imprimirResultados()

    val circulo = Circulo(3.0)
    println("=== Círculo (radio=3) ===");
    circulo.imprimirResultados()
}