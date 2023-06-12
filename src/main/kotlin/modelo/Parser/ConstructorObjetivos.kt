package modelo.Parser

import modelo.Objetivo.Continente
import modelo.JuegoYJugador.Jugador
import modelo.Objetivo.*
import java.util.*
import java.util.regex.Pattern

class ConstructorObjetivos(jugadores: HashMap<Int, Jugador>) {

    var objetivos: HashMap<String, ArrayList<Objetivo>>
    var jugadores: HashMap<Int, Jugador>

    fun construirObjetivos(objetivos: HashMap<String, ArrayList<String>>, continentes: HashMap<String, Continente>) {
        val tipos: Set<String> = objetivos.keys
        for (tipo in tipos) {
            val objetivosDelTipo = objetivos[tipo]!!
            when (tipo) {
                "Ocupacion" -> this.objetivos.put(
                    tipo,
                    crearObjetivosOcupacion(objetivosDelTipo, continentes)
                )
                "Destruccion" -> this.objetivos.put(
                    tipo,
                    crearObjetivosDestruccion(objetivosDelTipo)
                )
                else -> this.objetivos.put(tipo, crearObjetivosComun(objetivosDelTipo))
            }
        }
    }

    private fun crearObjetivosOcupacion(
        objetivosDelTipo: ArrayList<String>,
        continentes: HashMap<String, Continente>
    ): ArrayList<Objetivo> {
        val listaObjetivosOcupacion: ArrayList<Objetivo> = ArrayList<Objetivo>()
        for (objetivo in objetivosDelTipo) {
            val elementos: Array<String> = Pattern.compile(",").split(objetivo)
            listaObjetivosOcupacion.add(
                ObjetivoConquistar(
                    continentes[elementos[0]]!!,
                    continentes[elementos[1]]!!,
                    elementos[2].toInt()
                )
            )
        }
        return listaObjetivosOcupacion
    }

    private fun crearObjetivosDestruccion(objetivosDelTipo: ArrayList<String>): ArrayList<Objetivo> {
        val listaObjetivosDestruccion: ArrayList<Objetivo> = ArrayList<Objetivo>()
        for (objetivo in objetivosDelTipo) {
            if (objetivo.toInt() <= jugadores.size) {
                listaObjetivosDestruccion.add(ObjetivoDerrotar(jugadores[objetivo.toInt()]!!))
            }
        }
        return listaObjetivosDestruccion
    }

    private fun crearObjetivosComun(objetivosDelTipo: ArrayList<String>): ArrayList<Objetivo> {
        val listaObjetivosComun: ArrayList<Objetivo> = ArrayList<Objetivo>()
        for (objetivo in objetivosDelTipo) {
            listaObjetivosComun.add(ObjetivoGeneral(objetivo.toInt()))
        }
        return listaObjetivosComun
    }

    fun getObjetivos(): ArrayList<Objetivo> {
        return this.construirObjetivos()
    }

    private fun construirObjetivos(): ArrayList<Objetivo> {
        val objetivosFinales: ArrayList<Objetivo> = ArrayList<Objetivo>()
        val objetivoComun: Objetivo = objetivos["Comun"]!![0]
        terminarObjetivosOcupacion(objetivosFinales, objetivoComun)
        terminarObjetivosDestruccion(objetivosFinales, objetivoComun)
        return objetivosFinales
    }

    private fun terminarObjetivosDestruccion(objetivosFinales: ArrayList<Objetivo>, objetivoComun: Objetivo) {
        val objetivosDeDestruccion: ArrayList<Objetivo> = objetivos["Destruccion"]!!
        completarConstruccionDe(objetivosFinales, objetivoComun, objetivosDeDestruccion)
    }

    private fun completarConstruccionDe(
        objetivosFinales: ArrayList<Objetivo>, objetivoComun: Objetivo,
        objetivosDeTipo: ArrayList<Objetivo>
    ) {
        for (objetivo in objetivosDeTipo) {
            objetivosFinales.add(ObjetivoJugador(objetivoComun, objetivo))
        }
    }

    private fun terminarObjetivosOcupacion(objetivosFinales: ArrayList<Objetivo>, objetivoComun: Objetivo) {
        val objetivosDeOcupacion: ArrayList<Objetivo> = objetivos["Ocupacion"]!!
        completarConstruccionDe(objetivosFinales, objetivoComun, objetivosDeOcupacion)
    }

    init {
        objetivos = HashMap<String, ArrayList<Objetivo>>()
        this.jugadores = jugadores
    }
}