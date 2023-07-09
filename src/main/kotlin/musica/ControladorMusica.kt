package musica

import javafx.scene.media.AudioClip

class ControladorMusica private constructor() {
    private var backgroundMusic: AudioClip = AudioClip("file:src/main/resources/AgeOfEmpiresMainTheme.mp3")
    private var effectMusic: AudioClip = AudioClip("file:src/main/resources/campana_aoe.mp3")
    private var victoryMusic: AudioClip = AudioClip("file:src/main/resources/AgeofEmpires2VictoryMusic.mp3")

    init {
        backgroundMusic.volume = 5.0
        effectMusic.volume = 5.0
        victoryMusic.volume = 5.0
    }

    companion object {
        private var instanciaMusica: ControladorMusica? = null
        fun getInstance(): ControladorMusica {
            if (instanciaMusica == null) {
                instanciaMusica = ControladorMusica()
            }
            return instanciaMusica!!
        }

    }
    fun playBackgroundMusic() {
        backgroundMusic.cycleCount = AudioClip.INDEFINITE
        backgroundMusic.play()
        victoryMusic.stop()
    }

    fun playEffect() {
        effectMusic.play()
    }

    fun playVictory() {
        backgroundMusic.stop()
        victoryMusic.play()
    }

    fun soundRestart() {
        victoryMusic.stop()
        if (!backgroundMusic.isPlaying) {
            backgroundMusic.play()
        }
    }

    fun muteAll() {
        backgroundMusic.volume = 0.0
        backgroundMusic.stop()
        victoryMusic.volume = 0.0
        effectMusic.volume = 0.0
    }

    fun unmuteAll() {
        backgroundMusic.volume = 5.0
        backgroundMusic.play()
        victoryMusic.volume = 5.0
        effectMusic.volume = 5.0
    }
}