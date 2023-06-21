package Controlador

import javafx.scene.text.Text
import modelo.Objetivo.*

class FabricaTextoObjetivo {

    fun textoObjetivo(objetivo: Objetivo): Text? {
        val textoDeObjetivo = Text()
        textoDeObjetivo.text = objetivo.texto()
        return textoDeObjetivo
    }
}