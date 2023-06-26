package modelo
abstract class Ubicable : Observable() {
    abstract fun ejercitos(): Int
    abstract fun nroJugador(): Int
    abstract fun posX(): Int
    abstract fun posY(): Int
}