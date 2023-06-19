package modelo

import modelo.Batalla.Pais
import modelo.Objetivo.Continente
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class ContinenteTest {
    @Test
    fun creoContinenteYNoLoConquisto() {
        val asia = Continente("asia", 7)
        val japon = Pais("Japon")
        val china = Pais("china")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        Assertions.assertFalse(asia.fueConquistado(paises))
    }

    @Test
    fun creoContinenteYLoConquisto() {
        val asia = Continente("asia", 7)
        val japon = Pais("Japon")
        val china = Pais("china")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        paises.add(china)
        Assertions.assertTrue(asia.fueConquistado(paises))
    }

    @Test
    fun creoContinenteYLoConquistoConMasPaises() {
        val asia = Continente("asia", 7)
        val japon = Pais("Japon")
        val china = Pais("China")
        val argentina = Pais("Argentina")
        asia.agregarPais(japon)
        asia.agregarPais(china)
        val paises = ArrayList<Pais>()
        paises.add(japon)
        paises.add(china)
        paises.add(argentina)
        Assertions.assertTrue(asia.fueConquistado(paises))
    }
}