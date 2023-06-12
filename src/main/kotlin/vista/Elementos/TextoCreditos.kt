package edu.fiuba.algo3.vista.Elementos

import javafx.scene.paint.Color
import javafx.scene.text.*

class TextoCreditos : Text(
    """
    
    Hecho Por:
    
    Leonel Fernandez
    Axel Higa
    Francisco Pereira
    Julia Valdovinos
    Lucia Valdovinos
    
    Para la materia Algoritmos y Programacion 3 catedra Suarez,
    de la Facultad de Ingenieria de la Universidad de Buenos Aires.
    
    """.trimIndent()
) {
    init {
        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15.0))
        super.setTextAlignment(TextAlignment.JUSTIFY)
        super.setFill(Color.BLACK)
    }
}