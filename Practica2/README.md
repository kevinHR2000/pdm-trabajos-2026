# PDM - Trabajo 2 (2026-I)

Proyecto del curso **Programación de Dispositivos Móviles** (Semestre 6, 2026-I) desarrollado en **Kotlin**. Contiene tres ejercicios que aplican conceptos de Programación Orientada a Objetos: encapsulamiento, herencia, clases abstractas, interfaces y polimorfismo.

**Autor:** Kevin A. Haytara

## Estructura del proyecto

```
pdm-trabajo2-2026/
├── src/
│   ├── Main.kt         # Archivo principal (vacío, plantilla)
│   ├── Ejercicio1.kt   # Clase Producto con descuento
│   ├── Ejercicio2.kt   # Figuras geométricas (área y perímetro)
│   └── Ejercicio3.kt   # Sistema de biblioteca
├── out/                # Salida de compilación
└── pdm-trabajo2-2026.iml
```

## Ejercicios

### Ejercicio 1 — Producto con descuento
Clase `Producto` que demuestra **encapsulamiento** mediante métodos `set`/`get` para los atributos `precio` y `descuento`. Incluye validaciones (precio no negativo, descuento ≤ 100%) y calcula el precio final aplicando el descuento.

### Ejercicio 2 — Figuras geométricas
Clase abstracta `Shape` con propiedades abstractas `area` y `perimetro`. Implementa tres subclases:
- `Cuadrado` (lado)
- `Rectangulo` (base, altura)
- `Circulo` (radio)

Demuestra **herencia** y **polimorfismo** a través del método heredado `imprimirResultados()`.

### Ejercicio 3 — Sistema de biblioteca
Sistema completo de gestión de biblioteca que integra múltiples conceptos:
- Clase abstracta `Material` con subclases `Libro` y `Revista`.
- `data class Usuario` para representar a los usuarios.
- Interfaz `IBiblioteca` que define las operaciones: `registrarMaterial`, `registrarUsuario`, `prestamo`, `devolucion`, `mostrarMaterialesDisponibles` y `mostrarMaterialesReservadosPorUsuario`.
- Clase `Biblioteca` que implementa la interfaz y gestiona los materiales disponibles y prestados.

## Ejecución

Cada ejercicio tiene su propia función `main()`. Desde IntelliJ IDEA, abrir el archivo deseado y ejecutar con el botón de run del gutter, o usar el atajo configurado (`Shift + F10`).

## Requisitos

- Kotlin
- IntelliJ IDEA (recomendado)
