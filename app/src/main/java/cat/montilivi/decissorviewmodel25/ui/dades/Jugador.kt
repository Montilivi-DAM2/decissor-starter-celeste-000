package cat.montilivi.decissorviewmodel25.ui.dades

class Jugador(
    var nom: String,
    var rondesGuanyades: Int,
    var rondesPerdudes: Int
) {
    fun incrementaRondesGuanyades() {
        rondesGuanyades++
    }
    fun incrementaRondesPerdudes() {
        rondesPerdudes++
    }
}