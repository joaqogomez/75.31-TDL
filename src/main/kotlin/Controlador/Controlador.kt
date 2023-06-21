package Controlador

import Controlador.handlers.HandlerDePais
import javafx.scene.Node
import modelo.Batalla.Pais
import modelo.JuegoYJugador.Juego
import modelo.JuegoYJugador.Jugador
import vista.Elementos.Ficha
import javafx.scene.Scene
import javafx.scene.control.TextField
import javafx.scene.text.Text
import modelo.Fases.FaseDeRonda
import modelo.Ubicable
import vista.Botones.BotonMostrarCartas
import vista.Botones.BotonMostrarObjetivo
import vista.Elementos.CampoDeNombre
import vista.Elementos.ColoresJugadores
import vista.ventanas.*
import java.util.*

object Controlador {
    private var fichas: ArrayList<Ficha>? = null
    private var fichas_jugadores: ArrayList<Ficha>? = null
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
            paises[i].ejercitos.getCantidadEjercitos()
        }
        fichas_jugadores = ArrayList()
        for (jugador in teg!!.turnoJugadores.values) {
            var ubicable: Ubicable = jugador
            fichas_jugadores!!.add(Ficha(ubicable))
        }
    }

    fun empezarJuego() {
        teg!!.iniciarJuego()
        setearFichas()
    }

    fun pedirMenuSiguiente(): Scene? {
        val fase = teg!!.prepararSiguienteFase()
        val ventana = prepararMenu(fase)
        return Scene(VentanaJuego(fichas!!, ventana))
       //return teg.prepararMenuSiguiente()
        return null
    }

    private fun prepararMenu(fase: FaseDeRonda): VentanaMenu {
        val jugadorEnTurno = fase.jugadorEnTurno
        val ficha = fichas_jugadores!![jugadorEnTurno.nroJugador()]
        val nombreDelJugador = Text("Turno de: " + jugadorEnTurno.nombreJugador)
        nombreDelJugador.style = "-fx-font-weight: bold"
        nombreDelJugador.translateY = 50.0
        nombreDelJugador.translateX = 900.0

        when (fase.tipo()) {
            "atacar" -> {

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
                val menuAPreparar: VentanaMenu = VentanaMenuColocacion(ficha)
                val boton =  BotonMostrarCartas(jugadorEnTurno.inventarioDeJugador)
                boton.translateX = 920.0
                boton.translateY = 550.0
                menuAPreparar.children.add(boton)
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

    fun habilitarPaises(pais: Pais?, confirmacionAtaqueHandle: HandlerDePais?) {
        //teg.habilitarPaisesParaAtaque(pais, confirmacionAtaqueHandle)
    }

    fun habilitarPaisesParaColocacion(handler: HandlerDePais?) {
        //teg.habilitarPaisesParaColocacion(handler)
    }

    fun reestablecerPaises(jugador: Jugador?, handler: HandlerDePais?) {
        //teg.reestablecerPaises(jugador, handler)
    }
}