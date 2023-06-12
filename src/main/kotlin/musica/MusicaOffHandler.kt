package musica

import javafx.event.ActionEvent
import javafx.event.EventHandler

class MusicaOffHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        ControladorMusica.Companion.muteAll()
    }
}