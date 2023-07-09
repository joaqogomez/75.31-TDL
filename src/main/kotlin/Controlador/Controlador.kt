package Controlador

import Controlador.handlers.*
import javafx.scene.Node
import modelo.Batalla.Pais
import modelo.JuegoYJugador.Juego
import modelo.JuegoYJugador.Jugador
import javafx.scene.Scene
import javafx.scene.control.TextField
import javafx.scene.text.Text
import modelo.Fases.FaseDeRonda
import modelo.Ubicable
import vista.Botones.BotonMostrarObjetivo
import vista.Elementos.*
import vista.ventanas.*
import java.util.*

object Controlador {
    private var fichas: ArrayList<Ficha>? = null
    private var fichas_jugadores: HashMap<Int, Ficha>? = null
    private var teg: Juego? = null
    fun setearJuego(numeroJugadores: Int) {
        teg = Juego(numeroJugadores)
    }

    fun setearNombres(nombres: ArrayList<TextField>) {
        for (nombre in nombres) {
            val numeroJugador = (nombre as CampoDeNombre?)!!.getNumero()
            teg!!.setNombreJugadorNumero(numeroJugador, nombre.getText())
        }
    }

    private fun setearFichas() {
        val inventario = teg!!.inventario
        val paises = inventario.paises
        fichas = ArrayList()
        for (i in 0 until inventario.cantidadDePaises()) {
            fichas!!.add(Ficha(paises[i]))
        }
        fichas_jugadores = HashMap<Int, Ficha>()
        for (jugador in teg!!.turnoJugadores.values) {
            var ubicable: Ubicable = jugador
            fichas_jugadores!!.put(jugador.getNumeroJugador(), Ficha(ubicable))
        }
    }

    fun empezarJuego() {
        teg!!.iniciarJuego()
        setearFichas()
    }

    fun pedirMenuSiguiente(): Scene? {
        val fase = teg!!.prepararSiguienteFase()
        val ventana = prepararMenu(fase)
        teg!!.actualizarFase(fase.jugadorEnTurno)
        return Scene(VentanaJuego(fichas!!, ventana))
    }

    private fun prepararMenu(fase: FaseDeRonda): VentanaMenu {
        val jugadorEnTurno = fase.jugadorEnTurno
        val ficha = fichas_jugadores!![jugadorEnTurno.nroJugador()]!!
        val nombreDelJugador = Text("Turno de: " + jugadorEnTurno.nombreJugador)
        nombreDelJugador.style = "-fx-font-weight: bold"
        nombreDelJugador.translateY = 50.0
        nombreDelJugador.translateX = 900.0

        when (fase.tipo()) {
            "atacar" -> {
                val textoDeError = TextoNotificable()
                textoDeError.setPosicion(870, 550)
                val handlerGeneral = BotonAtacarHandle(jugadorEnTurno, textoDeError)
                handlerGeneral.setJugadorEnTurno(jugadorEnTurno)
                for (ficha_pais in fichas!!) {
                    ficha_pais.agregarNuevoHandler(handlerGeneral.getCopy())
                }
                val menuAPreparar: VentanaMenu = VentanaMenuAtacar(ficha)
                val f = FabricaTextoObjetivo()
                val textoDeObjetivo = f.textoObjetivo(jugadorEnTurno.objetivo)
                val colores = ColoresJugadores()
                val color = colores.getColor(jugadorEnTurno.nroJugador())!!
                val botonObjetivo = BotonMostrarObjetivo(textoDeObjetivo, jugadorEnTurno.nombreJugador, color)
                botonObjetivo.translateX = 905.0
                botonObjetivo.translateY = 70.0
                menuAPreparar.children.add(botonObjetivo)
                menuAPreparar.children.add(nombreDelJugador)
                return menuAPreparar
            }
            "colocar_ejercitos" -> {
                val textoDeError = TextoNotificable()
                textoDeError.setPosicion(900, 550)
                val handlerGeneral = BotonAgregarEjercitoHandle(jugadorEnTurno, textoDeError)
                handlerGeneral.setJugadorEnTurno(jugadorEnTurno)
                for (ficha_pais in fichas!!) {
                    ficha_pais.agregarNuevoHandler(handlerGeneral.getCopy())
                }
                val menuAPreparar: VentanaMenu = VentanaMenuColocacion(ficha)
                val f = FabricaTextoObjetivo()
                val textoDeObjetivo = f.textoObjetivo(jugadorEnTurno.objetivo)
                val colores = ColoresJugadores()
                val color = colores.getColor(jugadorEnTurno.nroJugador())!!
                val botonObjetivo = BotonMostrarObjetivo(textoDeObjetivo, jugadorEnTurno.nombreJugador, color)
                botonObjetivo.translateX = 905.0
                botonObjetivo.translateY = 70.0
                menuAPreparar.children.add(botonObjetivo)
                menuAPreparar.children.add(nombreDelJugador)
                return menuAPreparar
            }
            "primera_colocacion" -> {
                val textoDeError = TextoNotificable()
                textoDeError.setPosicion(900, 550)
                val handlerGeneral = BotonAgregarEjercitoHandle(jugadorEnTurno, textoDeError)
                handlerGeneral.setJugadorEnTurno(jugadorEnTurno)
                for (ficha_pais in fichas!!) {
                    ficha_pais.agregarNuevoHandler(handlerGeneral.getCopy())
                }
                val menuAPreparar: VentanaMenu = VentanaMenuColocacion(ficha)
                val f = FabricaTextoObjetivo()
                val textoDeObjetivo = f.textoObjetivo(jugadorEnTurno.objetivo)
                val colores = ColoresJugadores()
                val color = colores.getColor(jugadorEnTurno.nroJugador())!!
                val botonObjetivo = BotonMostrarObjetivo(textoDeObjetivo, jugadorEnTurno.nombreJugador, color)
                botonObjetivo.translateX = 905.0
                botonObjetivo.translateY = 70.0
                menuAPreparar.children.add(botonObjetivo)
                menuAPreparar.children.add(nombreDelJugador)
                return menuAPreparar
            }
            "segunda_colocacion" -> {
                val textoDeError = TextoNotificable()
                textoDeError.setPosicion(900, 550)
                val handlerGeneral = BotonAgregarEjercitoHandle(jugadorEnTurno, textoDeError)
                handlerGeneral.setJugadorEnTurno(jugadorEnTurno)
                for (ficha_pais in fichas!!) {
                    ficha_pais.agregarNuevoHandler(handlerGeneral.getCopy())
                }
                val menuAPreparar: VentanaMenu = VentanaMenuColocacion(ficha)
                val f = FabricaTextoObjetivo()
                val textoDeObjetivo = f.textoObjetivo(jugadorEnTurno.objetivo)
                val colores = ColoresJugadores()
                val color = colores.getColor(jugadorEnTurno.nroJugador())!!
                val botonObjetivo = BotonMostrarObjetivo(textoDeObjetivo, jugadorEnTurno.nombreJugador, color)
                botonObjetivo.translateX = 905.0
                botonObjetivo.translateY = 70.0
                menuAPreparar.children.add(botonObjetivo)
                menuAPreparar.children.add(nombreDelJugador)
                return menuAPreparar
            }
            else -> {
                val textoDeError = TextoNotificable()
                textoDeError.setPosicion(870, 550)
                val handlerGeneral = BotonMoverHandle(jugadorEnTurno, textoDeError)
                handlerGeneral.setJugadorEnTurno(jugadorEnTurno)
                for (ficha_pais in fichas!!) {
                    ficha_pais.agregarNuevoHandler(handlerGeneral.getCopy())
                }
                val menuAPreparar: VentanaMenu = VentanaMenuReagrupar(ficha)
                val f = FabricaTextoObjetivo()
                val textoDeObjetivo = f.textoObjetivo(jugadorEnTurno.objetivo)
                val colores = ColoresJugadores()
                val color = colores.getColor(jugadorEnTurno.nroJugador())!!
                val botonObjetivo = BotonMostrarObjetivo(textoDeObjetivo, jugadorEnTurno.nombreJugador, color)
                botonObjetivo.translateX = 905.0
                botonObjetivo.translateY = 70.0
                menuAPreparar.children.add(botonObjetivo)
                menuAPreparar.children.add(nombreDelJugador)
                return menuAPreparar
            }
        }
    }

    fun obtenerEscenaObjetivos(): Scene? {
        val jugadores = ArrayList(teg!!.turnoJugadores.values)
        val nodosDeJugadores = ArrayList<Node>()
        for (jugador in jugadores) {
            val nro = jugador.getNumeroJugador()
            val colores = ColoresJugadores()
            val color = colores.getColor(nro)!!
            val f = FabricaTextoObjetivo()
            val textoDeObjetivo = f.textoObjetivo(jugador.objetivo)
            val nodo = BotonMostrarObjetivo(textoDeObjetivo, jugador.nombreJugador, color)
            nodosDeJugadores.add(nodo)
        }
        val menuDeObjetivos = VentanaMenuObjetivos(nodosDeJugadores)
        val objetivos = VentanaMostrarObjetivos(menuDeObjetivos)
        return Scene(objetivos)
    }

    fun habilitarPaises(pais: Pais, confirmacionAtaqueHandle: HandlerDePais) {
        for (ficha in fichas!!) {
            val paisDestino = ficha.miUbicable as Pais
            if (paisDestino != pais) {
                ficha.agregarNuevoHandler(confirmacionAtaqueHandle.getCopy())
            }
        }
    }

    fun habilitarPaisesParaColocacion(handler: HandlerDePais?) {
        for (ficha_pais in fichas!!) {
            ficha_pais.agregarNuevoHandler(handler!!.getCopy())
        }
    }

    fun reestablecerPaises(jugador: Jugador?, handler: HandlerDePais?) {
        for (ficha in fichas!!) {
            val pais = ficha.miUbicable as Pais
            ficha.limpiarHandler()
            if (pais.ejercitos.comandante == jugador!!) {
                ficha.agregarNuevoHandler(handler!!.getCopy())
            }
        }
    }
}