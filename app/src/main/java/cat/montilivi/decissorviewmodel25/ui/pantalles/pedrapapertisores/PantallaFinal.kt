package cat.montilivi.decissorviewmodel25.ui.pantalles.pedrapapertisores

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.institutmontivi.decissorviewmodel25.ui.common.Boto
import cat.montilivi.decissorviewmodel25.ui.viewmodels.FinalViewModel

@Composable
fun PantallaFinal(
    onInici: () -> Unit,
    viewModel: FinalViewModel = viewModel()
) {
    val estat = viewModel.estat

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Pedra-Paper-Tisores\nLlangardaix-Spock",
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                "Jugadors eliminats:",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(Modifier.weight(1f))
            Text(
                estat.jugadorsEliminats.size.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Spacer(Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Rondes guanyades:")
            Spacer(Modifier.weight(1f))
            Text(estat.rondesGuanyades.toString())
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Rondes perdudes:")
            Spacer(Modifier.weight(1f))
            Text(estat.rondesPerdudes.toString())
        }
        Spacer(Modifier.height(25.dp))
        Text(
            "Llista de jugadors eliminats:",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(10.dp))
        estat.jugadorsEliminats.forEach { jugador ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(jugador.nom)
                Spacer(Modifier.weight(1f))
                Text("Guanyades: ${jugador.rondesGuanyades} - Perdudes: ${jugador.rondesPerdudes}")
            }
            Spacer(Modifier.height(5.dp))
        }
        Spacer(Modifier.weight(1f))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Tornar a l'inici",
            clic = {
                onInici()
            }
        )
    }
}