package cat.montilivi.decissorviewmodel25.ui.dades

object Dades {
    val jugadors: MutableList<Jugador> = mutableListOf()

    fun creaJugador(): Jugador {
        val nom = noms.random()
        val jugador = Jugador(nom, 0, 0)
        jugadors.add(jugador)
        return jugador
    }

    fun reset() {
        jugadors.clear()
    }

    private val noms = listOf(
        "Joan", "Anna", "Marc", "Laura", "Pau",
        "Clara", "David", "Marta", "Miquel", "Sergi"
    )

    enum class Tirada {
        PEDRA,
        PAPER,
        TISORA,
        LLANGARDAIX,
        SPOCK
    }

    enum class Resultat {
        EMPAT,
        PERD,
        GUANYA
    }

    fun resultat(a: Tirada, b: Tirada): Resultat {
        return when {
            // tirada quan és empat
            a == b -> Resultat.EMPAT

            // tirada quan a guanya a b
            (a == Tirada.PEDRA && (b == Tirada.TISORA || b == Tirada.LLANGARDAIX)) ||
                    (a == Tirada.PAPER && (b == Tirada.PEDRA || b == Tirada.SPOCK)) ||
                    (a == Tirada.TISORA && (b == Tirada.PAPER || b == Tirada.LLANGARDAIX)) ||
                    (a == Tirada.LLANGARDAIX && (b == Tirada.SPOCK || b == Tirada.PAPER)) ||
                    (a == Tirada.SPOCK && (b == Tirada.TISORA || b == Tirada.PEDRA)) -> Resultat.GUANYA

            // tirada quan a perd
            else -> Resultat.PERD
        }
    }
}