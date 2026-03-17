package cat.institutmontivi.decissorviewmodel25.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaCaraOCreu
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaInstruccions
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaOraclePregunta
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaOracleResposta
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaPortada
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaPreferencies
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaQuantA
import cat.institutmontivi.decissorviewmodel25.ui.pantalles.PantallaTriaUnNumero
import cat.montilivi.decissorviewmodel25.ui.pantalles.pedrapapertisores.PantallaFinal
import cat.montilivi.decissorviewmodel25.ui.pantalles.pedrapapertisores.PantallaInicial
import cat.montilivi.decissorviewmodel25.ui.pantalles.pedrapapertisores.PantallaRonda


@Composable
fun GrafDeNavegacio (controladorDeNavegacio: NavHostController = rememberNavController(), paddingValues: PaddingValues = PaddingValues(0.dp))
{
    NavHost(navController = controladorDeNavegacio, startDestination = DestinacioPortada, modifier = Modifier.padding(paddingValues))
    {
        composable<DestinacioPortada> {
            PantallaPortada()
        }

        composable<DestinacioInstruccions> {
            PantallaInstruccions()
        }

        composable<DestinacioPreferencies> {
            PantallaPreferencies()
        }

        composable<DestinacioQuantA> {
            PantallaQuantA()
        }

//        composable<DestinacioCaraOCreu> {
//            PantallaCaraOCreu()
//        }
//
//        composable<DestinacioTriaNumero> {
//            PantallaTriaUnNumero()
//        }
//
//        composable<DestinacioOraclePregunta> {
//            PantallaOraclePregunta(
//                onClick = {pregunta:String -> controladorDeNavegacio.navigate(DestinacioOracleResposta(pregunta)) }
//            )
//        }
//
//        composable<DestinacioOracleResposta> {
//            val argument = it.toRoute<DestinacioOracleResposta>()
//            PantallaOracleResposta(
//                pregunta = argument.pregunta,
//              )
//        }

        composable<DestinacioPedraPaperTisoresInici> {
            PantallaInicial(
                onRonda = {
                    controladorDeNavegacio.navigate(DestinacioPedraPaperTisoresRonda)
                }
            )
        }

        composable<DestinacioPedraPaperTisoresRonda> {
            PantallaRonda(
                onFinal = {
                    controladorDeNavegacio.navigate(DestinacioPedraPaperTisoresFinal)
                }
            )
        }

        composable<DestinacioPedraPaperTisoresFinal> {
            PantallaFinal(
                onInici = {
                    controladorDeNavegacio.navigate(DestinacioPedraPaperTisoresInici)
                }
            )
        }
    }
}
