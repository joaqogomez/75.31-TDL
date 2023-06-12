package modelo.JuegoYJugador

import modelo.Batalla.Pais
import modelo.Cartas.Carta
import modelo.Fases.FaseDeRonda
import modelo.Fases.FasePrimeraColocacion
import modelo.Objetivo.Continente
import modelo.Objetivo.Objetivo
import modelo.Parser.Parser
import modelo.SeleccionJugador
import java.util.*

class Juego(cantidadDeJugadores: Int) {
    private var turnoActual = 1
    private val turnoJugadores: HashMap<Int, Jugador> = HashMap<Int, Jugador>()
    private lateinit var faseActual: FaseDeRonda
    private lateinit var faseAnterior: FaseDeRonda
    private val parser: Parser = Parser(turnoJugadores)
    private lateinit var inventario: InventarioDeJuego

    fun iniciarJuego() {
        parser.parsearArchivo("src/main/resources/Cartas.json")
        parser.parsearArchivo("src/main/resources/Paises.json")
        parser.parsearArchivo("src/main/resources/Objetivos.json")
        parser.construirObjetos()
        generarInventario()
        repartirPaises()
        repartirObjetivos()
        faseActual = FasePrimeraColocacion(turnoJugadores[turnoActual]!!)
        faseAnterior = faseActual
    }

    private fun repartirObjetivos() {
        val objetivos: ArrayList<Objetivo> = ArrayList<Objetivo>(parser.getObjetivos())
        Collections.shuffle(objetivos)
        for (i in 1..turnoJugadores.size) {
            val objetivo: Objetivo = objetivos[i - 1]
            if (i < turnoJugadores.size) objetivo.setJugadorAuxiliar(
                turnoJugadores[i]!!,
                turnoJugadores[i + 1]!!
            ) else objetivo.setJugadorAuxiliar(
                turnoJugadores[i]!!, turnoJugadores[1]!!
            )
            turnoJugadores[i]!!.asignarObjetivo(objetivos[i - 1])
        }
    }

    private fun crearJugadores(cantidadDeJugadores: Int) {
        val jugadores = ArrayList<Jugador>()
        for (i in 1..cantidadDeJugadores) jugadores.add(Jugador(i))
        establecerTurnos(jugadores)
    }

    private fun establecerTurnos(jugadores: ArrayList<Jugador>) {
        var counter = 1
        Collections.shuffle(jugadores)
        for (jugador in jugadores) {
            turnoJugadores.put(counter, jugador)
            counter += 1
        }
    }

    fun obtenerOrder(): ArrayList<Int> {
        val numerosDeJugadores = ArrayList<Int>()
        val jugadores: Collection<Jugador> = turnoJugadores.values
        for (jugador in jugadores) {
            numerosDeJugadores.add(jugador.getNumeroJugador())
        }
        return numerosDeJugadores
    }

    fun obtenerSiguiente(): Jugador {
        val siguiente = turnoJugadores[turnoActual]
        avanzarTurno()
        return siguiente!!
    }

    fun seleccionDeJugador(jugador: Jugador, seleccion: SeleccionJugador) {
        faseActual.accionJugador(jugador, InventarioDeJuego(ArrayList(), ArrayList()), seleccion)
        actualizarFase(jugador)
    }

    private fun avanzarTurno() {
        if (esElUltimoJugador(turnoJugadores[turnoActual])) {
            turnoActual = 1
        } else {
            turnoActual++
        }
    }

    private fun repartirPaises() {
        val paises: ArrayList<Pais> = ArrayList<Pais>(parser.getPaises().values)
        Collections.shuffle(paises)
        for (pais in paises) {
            val actual = obtenerSiguiente()
            actual!!.agregarFichas(1)
            actual.ocupa(pais)
        }
        turnoActual = 1
        inventario!!.setPaises(paises)
    }

    private fun esElUltimoJugador(jugador: Jugador?): Boolean {
        return jugador === turnoJugadores[turnoJugadores.size]
    }

    private fun generarInventario() {
        val continentes: ArrayList<Continente> = ArrayList<Continente>(parser.getContinentes().values)
        val cartas: ArrayList<Carta> = parser.getCartas()
        Collections.shuffle(cartas)
        inventario = InventarioDeJuego(cartas, continentes)
    }

    fun obtenerSiguienteEnTurno(): Jugador {
        val siguiente = obtenerSiguiente()
        faseActual.aplicarAccionesDeFase(siguiente, inventario)
        return siguiente
    }


    private fun actualizarFase(siguiente: Jugador) {
        if (esElUltimoJugador(siguiente)) {
            faseActual = faseActual.cambiarFase(siguiente)
        }
    }

    private fun setNombreJugadorNumero(numero: Int, nombre: String) {
        val jugador = buscarNumero(numero)
        jugador.setNombre(nombre)
    }

    private fun buscarNumero(numero: Int): Jugador {
        val jugadores: ArrayList<Jugador> = ArrayList<Jugador>(turnoJugadores.values)
        return jugadores.stream().filter { jugador: Jugador? ->
            jugador!!.esElNumero(
                numero
            )
        }.findFirst().get()
    }
}
