package cat.montilivi.decissorviewmodel25.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cat.montilivi.decissorviewmodel25.ui.dades.Dades.jugadors
import cat.montilivi.decissorviewmodel25.ui.dades.Jugador

class FinalViewModel: ViewModel() {
    data class FinalEstat(
        val jugadorsEliminats: List<Jugador> = emptyList(),
        val rondesGuanyades: Int = 0,
        val rondesPerdudes: Int = 0
    )

    var estat by mutableStateOf(FinalEstat())
        private set

    fun actualitzaEstadistiques(guanyades: Int, perdudes: Int) {
        estat = estat.copy(
            jugadorsEliminats = jugadors,
            rondesGuanyades = guanyades,
            rondesPerdudes = perdudes
        )
    }

    fun reset() {
        reset()
        estat = FinalEstat()
    }
}