package vista.Elementos

import javafx.scene.paint.Color
import javafx.scene.text.*

class TextoComoJugar : Text(
    """
    
    Para colocar una ficha, cliquea en el pais en el que desees colocarla,
    solo podras colocar una ficha en un pais de tu mismo color.
    
    Para utilizar una carta, primero tendras que activarla haciendo click derecho
    para luego poder canjearla haciendo click izquierdo.
    
    Solo podras atacar paises limitrofes al seleccionado.
    
    Solo podras reagrupar ejercitos entre paises limitrofes.
    
    Para mas detalles, ver la pestaña Ayuda.
    
    """
) {
    init {
        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15.0))
        super.setTextAlignment(TextAlignment.JUSTIFY)
        super.setFill(Color.BLACK)
    }
}