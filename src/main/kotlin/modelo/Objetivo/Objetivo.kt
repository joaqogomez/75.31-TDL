package modelo.Objetivo

import modelo.Batalla.Pais
import java.util.*

interface Objetivo {
    fun objetivoCumplido(paises: ArrayList<Pais>): Boolean
}