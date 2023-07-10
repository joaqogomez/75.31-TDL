package Controlador.handlers

import javafx.event.ActionEvent
import javafx.event.EventHandler
import Controlador.EstadoJuego
import Controlador.JugadorData
import Controlador.PaisData
import kotlinx.coroutines.channels.Channel
import modelo.Batalla.Pais
import vista.Elementos.Ficha
import java.util.*

class GuardarHandler(val fichas: ArrayList<Ficha>, private val logMessageChannel: Channel<EstadoJuego>) : EventHandler<ActionEvent?> {
    override fun handle(event: ActionEvent?) {
        var listaEstado = ArrayList<JugadorData>()
        var listaJugadores = HashMap<String, ArrayList<PaisData>>()
        for (ficha in fichas){
            val pais = ficha.miUbicable as Pais
            val jugador = pais.ejercitos.comandante.nombreJugador

            if (!listaJugadores.containsKey(jugador)) {
                listaJugadores.put(jugador, ArrayList())
            }
            val paisData = PaisData(pais.getNombreDelPais(), pais.ejercitos())
            var lista = listaJugadores[jugador]!!
            lista.add(paisData)
            listaJugadores.put(jugador, lista)
        }
        for (jugador in listaJugadores.keys) {
            listaEstado.add(JugadorData(jugador, listaJugadores[jugador]!!))
        }
        logMessageChannel.trySend(EstadoJuego(listaEstado))
    }
}

