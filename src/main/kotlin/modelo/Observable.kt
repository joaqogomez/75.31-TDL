package modelo

import java.util.ArrayList

abstract class Observable{
    private var observadores : ArrayList<Observador> = ArrayList()
    fun notificar() {
        for (o in observadores) {
            o.notificar()
        }
    }
    fun agregar_observador(o: Observador) {
        observadores.add(o)
    }
}