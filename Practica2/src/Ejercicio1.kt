/*
 ██████  ██████   ██████  ██████  ██    ██  ██████ ██████
 ██   ██ ██   ██ ██    ██ ██   ██ ██    ██ ██      ██   ██
 ██████  ██████  ██    ██ ██   ██ ██    ██ ██      ██████
 ██      ██   ██ ██    ██ ██   ██ ██    ██ ██      ██   ██
 ██      ██   ██  ██████  ██████   ██████   ██████ ██   ██
Descripción: Escribir el precio con su decuento el resultado del precio final.
Autor: Kevin A. Haytara
Fecha de creación: 04/04/2026
Fecha última modificación: 04/04/2026
Duración: 90 minutos
 */
// Buena práctica de programación escribir la primera le letra con mayuscula
class Producto{
    //obligado a predeterminar los datos
    private var precio: Double = 0.0;
    private var descuento: Double = 0.0;
    //set y get para precio
    fun setPrecio(precio: Double){
        if (precio < 0){
            println("╦╦↨╦╦ El precio no puede ser negativo");
        }else{
            this.precio = precio;
        }
    }
    fun getPrecio(): Double = precio;
    //set y get para descuento
    fun setDescuento(descuento: Double){
        if (descuento > 100){
            println("╦╦╦╦ El descuento no puede superar el 100%");
        }else{
            this.descuento = descuento;
        }
    }
    fun getDescuento(): Double = descuento;
    //método para calcular el precio final
    fun calcularPrecioFinal(): Double{
        return precio - (precio * descuento /100);
    }

}


fun main(){
    val producto = Producto();

    producto.setPrecio(200.0);
    producto.setDescuento(20.0);

    println("Precio original: ${producto.getPrecio()}");
    println("Descuento: ${producto.getDescuento()}%");
    println("Precio final: ${producto.calcularPrecioFinal()}");
}