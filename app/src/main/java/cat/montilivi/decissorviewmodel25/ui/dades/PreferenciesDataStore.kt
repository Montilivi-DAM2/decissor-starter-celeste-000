package cat.montilivi.decissorviewmodel25.ui.dades

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class PreferenciesDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore by preferencesDataStore("preferencies")
        private val JOC_CLASSIC = booleanPreferencesKey("jocClassic")
        private val RONDES_PER_ELIMINAR = intPreferencesKey("rondesPerEliminar")
        private val NOM_JUGADOR = stringPreferencesKey("nomJugador")
    }

    val getJocClasic = context.dataStore.data.map { preferencies ->
        preferencies[JOC_CLASSIC] ?: true
    }

    val getRondesPerEliminar = context.dataStore.data.map { preferencies ->
        preferencies[RONDES_PER_ELIMINAR] ?: 3
    }

    val getNomJugador = context.dataStore.data.map { preferencies ->
        preferencies[NOM_JUGADOR] ?: "1"
    }

    suspend fun setJocClassic(classic: Boolean) {
        context.dataStore.edit { preferencies ->
            preferencies[JOC_CLASSIC] = classic
        }
    }

    suspend fun setRondesPerEliminar(rondes: Int) {
        context.dataStore.edit { preferencies ->
            preferencies[RONDES_PER_ELIMINAR] = rondes
        }
    }

    suspend fun setNomJugador(nom: String) {
        context.dataStore.edit { preferencies ->
            preferencies[NOM_JUGADOR] = nom
        }
    }
}