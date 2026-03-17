package cat.montilivi.decissorviewmodel25.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cat.montilivi.decissorviewmodel25.ui.dades.Dades
import cat.montilivi.decissorviewmodel25.ui.dades.Dades.resultat

class RondaViewModel: ViewModel() {
    data class RondaEstat(
        val rivalNom: String = "",
        val puntsJugador: Int = 0,
        val puntsRival: Int = 0,
        val missatge: String = "",
        val rondaAcabada: Boolean = false
    )

    var estat by mutableStateOf(RondaEstat())
        private set

    init {
        iniciarRonda()
    }

    fun iniciarRonda() {
        val rival = Dades.creaJugador()
        estat = RondaEstat(
            rivalNom = rival.nom,
            missatge = "Nou rival: ${rival.nom}"
        )
    }

    fun jugar(tiradaJugador: Dades.Tirada) {
        val tiradaRival = Dades.Tirada.entries.random()
        val resultatTirada = resultat(tiradaJugador, tiradaRival)
        var puntsJugador = estat.puntsJugador
        var puntsRival = estat.puntsRival
        var missatge = ""

        when (resultatTirada) {
            Dades.Resultat.EMPAT -> missatge = "Hi ha empat"
            Dades.Resultat.GUANYA -> {
                puntsJugador++
                missatge = "Guanya jugador"
            }
            Dades.Resultat.PERD -> {
                puntsRival++
                missatge = "Guanya ${estat.rivalNom}"
            }
        }
        val acabada = puntsJugador == 3 || puntsRival == 3
        estat = estat.copy(
            puntsJugador = puntsJugador,
            puntsRival = puntsRival,
            missatge = missatge,
            rondaAcabada = acabada
        )
    }
}