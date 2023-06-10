package modelo.Parser

import modelo.Carta
import modelo.Continente
import modelo.Jugador
import modelo.Objetivo.Objetivo
import modelo.Pais
import java.util.*

class Constructor {
    var paisYCarta: ConstructorPaisYCarta
    var continente: ConstructorContinente
    lateinit var objetivos: ConstructorObjetivos

    constructor(jugadores: HashMap<Int, Jugador>) {
        paisYCarta = ConstructorPaisYCarta()
        continente = ConstructorContinente()
        objetivos = ConstructorObjetivos(jugadores)
    }

    constructor() {
        paisYCarta = ConstructorPaisYCarta()
        continente = ConstructorContinente()
    }

    fun construirPaisesYCartas(
        cartaPais: HashMap<String, String>,
        fronteras: HashMap<String, String>,
        cordenadas: HashMap<String, Coordenadas>
    ) {
        paisYCarta.construirPaisesYCartas(cartaPais, fronteras, cordenadas)
    }

    fun construirContinente(continente: HashMap<String, String>) {
        this.continente.construirContinente(continente, paisYCarta.getPaises())
    }

    fun contruirObjetivos(objetivos: HashMap<String, ArrayList<String>>) {
        if (::objetivos.isInitialized) this.objetivos.construirObjetivos(objetivos, continente.getContinentes())
    }

    fun getPaises(): HashMap<String, Pais> {
        return paisYCarta.getPaises()
    }

    fun getCartas(): ArrayList<Carta> {
        return paisYCarta.getCartas()
    }

    fun getContinente(): HashMap<String, Continente> {
        return continente.getContinentes()
    }

    fun getObjetivos(): ArrayList<Objetivo> {
        return objetivos.getObjetivos()
    }
}