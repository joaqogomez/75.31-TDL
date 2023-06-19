package edu.fiuba.algo3.vista.Elementos

import javafx.scene.paint.Color
import javafx.scene.text.*

class TextoCreditos : Text(
    """
    
    Hecho Por:
    
    Valdez, Santiago
    Gomez, Joaquin
    Romero, Adrian
    
    Para la materia Teoria del Lenguaje,
    de la Facultad de Ingenieria de la Universidad de Buenos Aires.
    
    """
) {
    init {
        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15.0))
        super.setTextAlignment(TextAlignment.JUSTIFY)
        super.setFill(Color.BLACK)
    }
}