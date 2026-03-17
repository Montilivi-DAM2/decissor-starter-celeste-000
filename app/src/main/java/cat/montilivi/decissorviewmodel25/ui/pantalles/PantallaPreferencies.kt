package cat.institutmontivi.decissorviewmodel25.ui.pantalles


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.decissorviewmodel25.ui.dades.PreferenciesDataStore
import kotlinx.coroutines.launch

@Composable
fun CaixetaJocClassic(jocClassic: Boolean, onValueChange: (Boolean) -> Unit) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Tipus de joc",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Joc clàssic")
                Switch(
                    checked = jocClassic,
                    onCheckedChange = onValueChange
                )
            }
        }
    }
}

@Composable
fun CaixetaRondesPerEliminar(rondes: Int, onValueChange: (Int) -> Unit) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Rondes per eliminar un rival",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))
            Slider(
                value = rondes.toFloat(),
                onValueChange = { onValueChange(it.toInt()) },
                valueRange = 1f..15f
            )
            Text("Rondes: $rondes", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun CaixetaNomJugador(nom: String, onValueChange: (String) -> Unit) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Nom del jugador",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))
            TextField(
                value = nom,
                onValueChange = onValueChange,
                label = { Text("Nom") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun PantallaPreferencies ()
{
    val preferencies = PreferenciesDataStore(LocalContext.current)
    val jocClassic by preferencies.getJocClasic.collectAsState(initial = true)
    val rondesPerEliminar by preferencies.getRondesPerEliminar.collectAsState(initial = 3)
    val nomJugador by preferencies.getNomJugador.collectAsState(initial = "1")
    val ambitCorrutina = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Preferències",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )
        HorizontalDivider(Modifier.fillMaxWidth())

        // caixetes amb scroll
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            CaixetaJocClassic(
                jocClassic = jocClassic,
                onValueChange = {
                    ambitCorrutina.launch { preferencies.setJocClassic(it) }
                }
            )
            CaixetaRondesPerEliminar(
                rondes = rondesPerEliminar,
                onValueChange = {
                    ambitCorrutina.launch { preferencies.setRondesPerEliminar(it) }
                }
            )
            CaixetaNomJugador(
                nom = nomJugador,
                onValueChange = {
                    ambitCorrutina.launch { preferencies.setNomJugador(it) }
                }
            )
        }
    }
}


