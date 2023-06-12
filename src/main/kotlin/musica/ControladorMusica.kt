package musica

import javafx.scene.media.AudioClip

class ControladorMusica {
    init {
        backgroundMusic = AudioClip("file:AgeOfEmpiresMainTheme.mp3")
        effectMusic = AudioClip("file:campana_aoe.mp3")
        victoryMusic = AudioClip("file:AgeofEmpires2VictoryMusic.mp3")
        backgroundMusic.setVolume(5.0)
        effectMusic.setVolume(5.0)
        victoryMusic.setVolume(5.0)
    }

    companion object {
        private var instanciaMusica: ControladorMusica? = null
        private var backgroundMusic: AudioClip?
        private var effectMusic: AudioClip?
        private var victoryMusic: AudioClip?
        fun getInstance(): ControladorMusica? {
            if (instanciaMusica == null) {
                instanciaMusica = ControladorMusica()
            }
            return instanciaMusica
        }

        fun playBackgroundMusic() {
            backgroundMusic.setCycleCount(AudioClip.INDEFINITE)
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
            if (!backgroundMusic.isPlaying()) {
                backgroundMusic.play()
            }
        }

        fun muteAll() {
            backgroundMusic.setVolume(0.0)
            backgroundMusic.stop()
            victoryMusic.setVolume(0.0)
            effectMusic.setVolume(0.0)
        }

        fun unmuteAll() {
            backgroundMusic.setVolume(5.0)
            backgroundMusic.play()
            victoryMusic.setVolume(5.0)
            effectMusic.setVolume(5.0)
        }
    }
}