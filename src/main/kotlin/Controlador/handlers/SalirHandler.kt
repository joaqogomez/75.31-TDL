package Controlador.handlers

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler

class SalirHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        Platform.exit()
        System.exit(0)
    }
}