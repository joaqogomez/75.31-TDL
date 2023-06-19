package edu.fiuba.algo3.vista.Elementos

import javafx.scene.paint.Color
import javafx.scene.text.*

class TextoAyuda : Text(
    """
    
    El juego propone un conflicto bélico que tiene lugar sobre un mapa-tablero dividido
    en 50 países. Para empezar se reparten los 50 países entre los jugadores, quienes
    ocupan sus dominios con fichas (ejércitos).
    
    Cada jugador tiene un OBJETIVO SECRETO a cumplir, que se le asigna por azar y
    que el resto de los jugadores desconoce. Para cumplir con su objetivo (ocupar
    cierta cantidad de países o destruir otros bandos) el jugador deberá ampliar
    sus dominios y reordenar sus fuerzas, lo que exigirá emprender ataques y
    defenderse de ataques adversarios; agrupar y desplazar ejércitos; concertar
    pactos con otros contendientes.
    
    La conquista de nuevos territorios le permitirá aumentar el número de ejércitos
    a su disposición, otorgándole mayores chances para triunfar en los combates.
    
    Si el jugador posee una tarjeta de país aún no activada de un país que controla
    puede activarla, lo cual le brinda dos ejércitos adicionales en dicho país.
    Estas tarjetas pueden activarse una sola vez, a menos que sean devueltas a
    través de un canje.
    Asimismo, si un jugador posee tres tarjetas de país con el mismo símbolo o tres
    símbolos distintos puede solicitar un canje según:
    
    1° canje:              4 ejercitos
    2° canje:              7 ejercitos
    3° canje:              10 ejercitos
    4° canje:              15 ejercitos
    n-esimo° canje:  (n-1) * 5 ejercitos
    
    Luego del canje las tarjetas vuelven a estar desactivadas.
    
    """
) {
    init {
        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15.0))
        super.setTextAlignment(TextAlignment.JUSTIFY)
        super.setFill(Color.BLACK)
    }
}