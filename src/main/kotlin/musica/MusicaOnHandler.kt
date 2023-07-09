package musica

import javafx.event.ActionEvent
import javafx.event.EventHandler

class MusicaOnHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val c = ControladorMusica.getInstance()
        c.unmuteAll()
    }
}