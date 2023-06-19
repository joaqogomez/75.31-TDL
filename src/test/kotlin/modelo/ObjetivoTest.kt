package modelo

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import modelo.Objetivo.Continente
import modelo.Objetivo.Objetivo
import modelo.Objetivo.ObjetivoConquistar
import modelo.Objetivo.ObjetivoDerrotar
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class ObjetivoTest {
    @Test
    fun creoUnObjetivoYNoLoCumplo() {
        val japon = Pais("Japon")
        val china = Pais("China")
        val kamchatka = Pais("Kamchatcka")
        val asia = Continente("asia")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        asia.agregarPais(kamchatka)
        val americaDelSur = Continente("america del sur")
        val conquistarContinente: Objetivo = ObjetivoConquistar(asia, americaDelSur, 0)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        Assertions.assertFalse(conquistarContinente.objetivoCumplido(paises))
    }

    @Test
    fun creoUnObjetivoYLoCumplo() {
        val japon = Pais("Japon")
        val china = Pais("China")
        val kamchatka = Pais("Kamchatcka")
        val asia = Continente("asia")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        asia.agregarPais(kamchatka)
        val americaDelSur = Continente("america del sur")
        val conquistarContinente: Objetivo = ObjetivoConquistar(asia, americaDelSur, 0)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        paises.add(china)
        paises.add(kamchatka)
        Assertions.assertTrue(conquistarContinente.objetivoCumplido(paises))
    }

    @Test
    fun creoUnObjetivoYNoLoCumploConContinenteYPais() {
        val japon = Pais("Japon")
        val china = Pais("China")
        val kamchatka = Pais("Kamchatcka")
        val argentina = Pais("Argentina")
        val asia = Continente("asia")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        asia.agregarPais(kamchatka)
        val americaDelSur = Continente("america del sur")
        americaDelSur.agregarPais(argentina)
        val conquistarContinente: Objetivo = ObjetivoConquistar(asia, americaDelSur, 1)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        paises.add(china)
        paises.add(kamchatka)
        Assertions.assertFalse(conquistarContinente.objetivoCumplido(paises))
    }

    @Test
    fun creoUnObjetivoYLoCumploConContinenteYPais() {
        val japon = Pais("Japon")
        val china = Pais("China")
        val kamchatka = Pais("Kamchatcka")
        val argentina = Pais("Argentina")
        val asia = Continente("asia")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        asia.agregarPais(kamchatka)
        val americaDelSur = Continente("america del sur")
        americaDelSur.agregarPais(argentina)
        val conquistarContinente: Objetivo = ObjetivoConquistar(asia, americaDelSur, 1)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        paises.add(china)
        paises.add(kamchatka)
        paises.add(argentina)
        Assertions.assertTrue(conquistarContinente.objetivoCumplido(paises))
    }

    @Test
    fun objetivoDerrotarAlJugadorNoseCumpleAlPrincipio() {
        val jugador = Jugador(1)
        val japon = Pais("Japon")
        val china = Pais("China")
        val kamchatka = Pais("Kamchatcka")
        jugador.agregarFichas(1)
        jugador.ocupa(japon)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        paises.add(china)
        paises.add(kamchatka)
        val derrotarJugador1: Objetivo = ObjetivoDerrotar(jugador)
        Assertions.assertFalse(derrotarJugador1.objetivoCumplido(paises))
    }

    @Test
    fun objetivoDerrotarAlJugadorSeCumpleAlPerderElultimoPaisConquistado() {
        val jugador = Jugador(1)
        jugador.agregarFichas(1)
        val derrotarJugador1: Objetivo = ObjetivoDerrotar(jugador)
        val japon = Pais("Japon")
        jugador.ocupa(japon)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        jugador.perdisteA(japon)
        Assertions.assertTrue(derrotarJugador1.objetivoCumplido(paises))
    }
}