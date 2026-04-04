/*
  █▀▄▀█ █ █▀▄ █   █ █▀█ ▀█▀ █▀▀ █▀▀ █▀█
  █▀▀▀█ █ █▀▄ █   █ █ █  █  █▀▀ █   █▀█
  ▀   ▀ ▀ ▀▀  ▀▀▀ ▀ ▀▀▀  ▀  ▀▀▀ ▀▀▀ ▀ ▀
Descripción: Una interfaz de biblioteca : devolucion, registro, disponible, pr♪stamo
Autor: Kevin A. Haytara
Fecha de creación: 04/04/2026
Fecha última modificación: 04/04/2026
Duración: 180 minutos

 */
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int){
    abstract fun mostrarDetalles();
}
//Subclase libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
    ): Material(titulo, autor, anioPublicacion){
    override fun mostrarDetalles() {
        println("==== Libro ====");
        println("Título: $titulo")
        println("Autor: $autor");
        println("Año: $anioPublicacion");
        println("GEnero: $genero");
        println("Páginas: $numeroPaginas");
    }
}
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String,
    ): Material(titulo, autor, anioPublicacion){
    override fun mostrarDetalles() {
        println("==== Revista ====");
        println("Título: $titulo");
        println("Autor: $autor");
        println("Año: $anioPublicacion");
        println("ISSN: $issn");
        println("Volumen: $volumen");
        println("Número: $numero");
        println("Editorial: $editorial");
    }
}
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int,
)
interface IBiblioteca{
    fun registrarMaterial(material: Material);
    fun registrarUsuario(usuario: Usuario);
    fun prestamo(usuario: Usuario, material: Material);
    fun devolucion(usuario: Usuario, material: Material);
    fun mostrarMaterialesDisponibles();
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario);
}
class Biblioteca: IBiblioteca{
    private val materialesDisponibles = mutableListOf<Material>();
    private val materialesPrestados = mutableMapOf<Usuario, MutableList<Material>>();

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material);
        println("Material registrado: ${material.titulo}");
    }
    override fun registrarUsuario(usuario: Usuario){
        materialesPrestados[usuario] = mutableListOf();
        println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)){
            materialesDisponibles.remove(material)
            materialesPrestados[usuario]?.add(material)
            println("Préstamo exitoso: ${material.titulo} -> ${usuario.nombre}")
        }else{
            println("Material no disponible: ${material.titulo}")
        }
    }
    override fun devolucion(usuario: Usuario, material: Material){
        if (materialesPrestados[usuario]?.contains(material) == true){
            materialesPrestados[usuario]?.remove(material);
            materialesDisponibles.add(material);
            println("Devolución exitosa: ${material.titulo} -> ${usuario.nombre}")
        }else{
            println("▼▼▼ El usuario no tiene ese material: ${material.titulo}");
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("=== Materiales Disponibles === \n");
        if (materialesDisponibles.isEmpty()){
            println("No hay materiales disponibles.")
        } else{
            materialesDisponibles.forEach{it.mostrarDetalles()}
        }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("=== Materiales de ${usuario.apellido} ===");
        val lista = materialesPrestados[usuario]
        if (lista.isNullOrEmpty()){
            println("No tiene materiales en préstamo");
        }else{
            lista.forEach{it.mostrarDetalles()}
        }
    }
}



fun main(){
    val biblioteca = Biblioteca();
    //crea materiales
    val libro = Libro("El quijote", "Cervantes", 1605, "Novela", 863);
    val revista = Revista("Nature", "Varios", 2023, "0028-0836", 10, 5, "Springer");

    //crea usuarios
    val usuario1 = Usuario("Pedro", "Perez", 25);
    val usuario2 = Usuario("Judas", "Lopez", 30);
    //Registrar materiales, usuarios
    biblioteca.registrarMaterial(libro);
    biblioteca.registrarMaterial(revista);
    biblioteca.registrarUsuario(usuario1);
    biblioteca.registrarUsuario(usuario2);
    //disponibles
    biblioteca.mostrarMaterialesDisponibles();
    //pr♪stamos
    biblioteca.prestamo(usuario1, libro);
    biblioteca.prestamo(usuario2, revista);
    //reservados
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1);
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2);
    //devoluci♪n
    biblioteca.devolucion(usuario1, libro);
    //disponibles al devolver
    biblioteca.mostrarMaterialesDisponibles();
}