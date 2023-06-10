package modelo.JuegoYJugador

import modelo.Batalla.Ejercitos
import modelo.Batalla.Pais
import modelo.Carta
import modelo.Objetivo.Objetivo


class Jugador(numeroDeJugador: Int) {
    val numeroJugador: Int
    var nombreJugador: String? = null
        private set
    var color: String? = null
        private set
    val paisesOcupados: ArrayList<Pais>
    private val inventarioDeJugador: InventarioDeJugador
    private var objetivo: Objetivo? = null

    init {
        paisesOcupados = ArrayList()
        numeroJugador = numeroDeJugador
        setColor()
        inventarioDeJugador = InventarioDeJugador(this)
    }

    private fun setColor() {
        val colores = ColoresJugadores()
        color = colores.getColor(numeroJugador)
    }

    fun ocupa(unPais: Pais) {
        ocuparCon(unPais, 1)
    }

    fun ocuparCon(unPais: Pais, cantidadFuerzas: Int) {
        val nuevaDivision: Ejercitos = inventarioDeJugador.generarDivision(cantidadFuerzas)
        unPais.recibirTropas(nuevaDivision)
        devolverFuerzas(unPais, cantidadFuerzas)
    }

    private fun devolverFuerzas(unPais: Pais, cantidadFuerzas: Int) {
        if (!ocupeElPais(unPais)) {
            agregarFichas(cantidadFuerzas)
        }
    }

    //AgregarEstadoDerrotado
    fun perdisteA(unPais: Pais) {
        paisesOcupados.remove(unPais)
    }

    fun ocupasteA(unPais: Pais) {
        paisesOcupados.add(unPais)
    }

    fun agregarFichas(cantidadFichas: Int) {
        inventarioDeJugador.agregarEjercitos(cantidadFichas)
    }

    fun atacarPaisDesdeA(unPais: Pais, otroPais: Pais) {
        unPais.atacarA(otroPais)
        verificarOcupacion(otroPais)
    }

    private fun verificarOcupacion(otroPais: Pais) {
        if (ocupeElPais(otroPais)) {
            inventarioDeJugador.ocupePais()
        }
    }

    private fun ocupeElPais(otroPais: Pais): Boolean {
        return paisesOcupados.contains(otroPais)
    }

    fun cantidadDeEjercitosAColocar(inventarioDeJuego: InventarioDeJuego) {
        var cantidadEjercitos = paisesOcupados.size / 2
        cantidadEjercitos += inventarioDeJuego.ejercitosPorContinentesConquistados(paisesOcupados)
        agregarFichas(cantidadEjercitos)
    }

    fun agregarFichasA(numeroDeFichas: Int, unPais: Pais) {
        if (ocupeElPais(unPais)) inventarioDeJugador.agregarFichasA(
            numeroDeFichas,
            unPais
        ) else throw ColocacionEjercitoError("Debes elegir a un pais tuyo")
    }

    fun recibirCarta(unaCarta: Carta?) {
        inventarioDeJugador.recibirCarta(unaCarta)
    }

    fun canjearCartas(primeraCarta: Carta?, segundaCarta: Carta?, terceraCarta: Carta?) {
        inventarioDeJugador.canjearCartas(primeraCarta, segundaCarta, terceraCarta)
    }

    fun canjearCarta(unaCarta: Carta) {
        if (puedoCanjearLaCarta(unaCarta)) {
            inventarioDeJugador.activarCarta(unaCarta)
        } else throw CanjesError("Debes tener a este pais para activarla")
    }

    private fun puedoCanjearLaCarta(unaCarta: Carta): Boolean {
        return paisesOcupados.contains(unaCarta.pais)
    }

    fun fueDerrotado(): Boolean {
        return paisesOcupados.isEmpty()
    }

    fun moverFichasDeACon(unPais: Pais, otroPais: Pais?, cantidad: Int) {
        unPais.moverEjercitoA(otroPais, cantidad)
    }

    fun pedirCarta(inventario: InventarioDeJuego?) {
        inventarioDeJugador.pedirCarta(inventario)
    }

    fun setNombre(nombre: String?) {
        nombreJugador = nombre
    }

    fun habilitarPaises(handler: HandlerDePais) {
        for (pais in paisesOcupados) {
            val handlerDePais: HandlerDePais = handler.getCopy()
            pais.agregarHandler(handlerDePais)
        }
    }

    val ficha: Ficha
        get() = inventarioDeJugador.getFicha()

    fun prepararNombre(): Text {
        val nombre = Text("Turno de: " + nombreJugador)
        nombre.setStyle("-fx-font-weight: bold")
        nombre.setTranslateY(50)
        nombre.setTranslateX(900)
        return nombre
    }

    fun esElNumero(numero: Int): Boolean {
        return numeroJugador == numero
    }

    fun asignarObjetivo(objetivo: Objetivo?) {
        this.objetivo = objetivo
    }

    fun prepararObjetivo(): Node {
        val textoDeObjetivo: Text = objetivo.prepararVista()
        return BotonMostrarObjetivo(textoDeObjetivo, nombreJugador, color)
    }

    private fun gane(): Boolean {
        return objetivo.objetivoCumplido(paisesOcupados)
    }

    fun evaluarVictoria(evento: MouseEvent) {
        if (gane()) {
            val stage: Stage = (evento.getSource() as Node).getScene().getWindow() as Stage
            val victoria = VentanaVictoria(this)
            val scenaFinal = Scene(victoria)
            stage.setScene(scenaFinal)
            stage.show()
        }
    }

    val cartas: ArrayList<Carta>
        get() = inventarioDeJugador.getCartas()

    fun elegirCarta(cartaElegidaUno: Carta, cartaElegidaDos: Carta, handler: HandlerDeCarta) {
        for (carta in inventarioDeJugador.getCartas()) {
            if (carta != cartaElegidaUno && carta != cartaElegidaDos) {
                val handlerDeCarta: HandlerDeCarta = handler.getCopy()
                handlerDeCarta.asociarCarta(carta)
                carta.agregarHandler(handlerDeCarta)
            }
        }
    }

    fun habilitarCartas(handler: HandlerDeCarta) {
        for (carta in inventarioDeJugador.getCartas()) {
            carta.agregarHandler(handler.getCopy())
        }
    }

    fun botonMostrarCarta(): Button {
        return BotonMostrarCartas(inventarioDeJugador)
    }

    fun mostrarCartas() {
        inventarioDeJugador.mostrarCartas()
    }

    fun atacarPaisDesdeAVisual(paisOrigen: Pais, paisDestino: Pais?) {
        paisOrigen.atacarAVisual(paisDestino)
        verificarOcupacion(paisOrigen)
    }

    fun quedanFichas(): Boolean {
        return inventarioDeJugador.quedanFichas()
    }
}