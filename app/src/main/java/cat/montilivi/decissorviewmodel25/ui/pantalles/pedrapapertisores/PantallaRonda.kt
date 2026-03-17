package cat.montilivi.decissorviewmodel25.ui.pantalles.pedrapapertisores

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
import cat.montilivi.decissorviewmodel25.ui.dades.Dades
import cat.montilivi.decissorviewmodel25.ui.viewmodels.RondaViewModel

@Composable
fun PantallaRonda(
    onFinal: () -> Unit,
    viewModel: RondaViewModel = viewModel()
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
        Text(
            "Rival: ${estat.rivalNom}",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Jugador: ")
            Spacer(Modifier.weight(1f))
            Text(estat.puntsJugador.toString())
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(estat.rivalNom)
            Spacer(Modifier.weight(1f))
            Text(estat.puntsRival.toString())
        }
        Spacer(Modifier.height(20.dp))
        Text(
            estat.missatge,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Pedra",
            clic = { viewModel.jugar(Dades.Tirada.PEDRA) }
        )
        Spacer(Modifier.height(10.dp))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Paper",
            clic = { viewModel.jugar(Dades.Tirada.PAPER) }
        )
        Spacer(Modifier.height(10.dp))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Tisora",
            clic = { viewModel.jugar(Dades.Tirada.TISORA) }
        )
        Spacer(Modifier.height(10.dp))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Llangardaix",
            clic = { viewModel.jugar(Dades.Tirada.LLANGARDAIX) }
        )
        Spacer(Modifier.height(10.dp))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Spock",
            clic = { viewModel.jugar(Dades.Tirada.SPOCK) }
        )
        Spacer(Modifier.weight(1f))
        if (estat.rondaAcabada) {
            Boto(
                modifier = Modifier.fillMaxWidth(),
                text = "Ronda finalitzada",
                clic = onFinal
            )
        }
    }
}