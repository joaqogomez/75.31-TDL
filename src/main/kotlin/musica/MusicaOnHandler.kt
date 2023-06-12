package musica

import javafx.event.ActionEvent
import javafx.event.EventHandler

class MusicaOnHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        ControladorMusica.Companion.unmuteAll()
    }
}