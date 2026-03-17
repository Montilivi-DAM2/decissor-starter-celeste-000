package cat.montilivi.decissorviewmodel25.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class IniciViewModel: ViewModel() {
    data class IniciEstat(
        val rivalsEliminats: Int = 0
    )

    var estat by mutableStateOf(IniciEstat())
        private set

    init {
        estat = IniciEstat()
    }
}