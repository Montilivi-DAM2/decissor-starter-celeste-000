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
import cat.montilivi.decissorviewmodel25.ui.viewmodels.IniciViewModel

@Composable
fun PantallaInicial(
    onRonda: () -> Unit,
    viewModel: IniciViewModel = viewModel()
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
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Rivals eliminats:",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(Modifier.weight(1f))
            Text(
                estat.rivalsEliminats.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            "El primer en obtenir 3 punts guanya la ronda.",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(15.dp))
        Boto(
            modifier = Modifier.fillMaxWidth(),
            text = "Iniciar torneig",
            clic = {
                onRonda()
            }
        )
    }
}