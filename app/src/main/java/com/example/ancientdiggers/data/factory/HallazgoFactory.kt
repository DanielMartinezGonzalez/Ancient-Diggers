package com.example.ancientdiggers.data.factory

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.hallazgo.Hallazgo
import com.example.ancientdiggers.data.model.hallazgo.TipoCultura
import com.example.ancientdiggers.data.model.hallazgo.TipoEpoca
import kotlinx.coroutines.channels.ticker

object HallazgoFactory {

    private val epocasConPesos = listOf(
        TipoEpoca.PREHISTORIA to 0.3,
        TipoEpoca.ANTIGÜEDAD to 0.3,
        TipoEpoca.ROMANA to 0.1,
        TipoEpoca.EDAD_MEDIA to 0.2,
        TipoEpoca.CONTEMPORANEO to 0.1
    )

    // Definición de culturas con pesos para cada época:
    private val culturasPrehistoria = listOf(
        TipoCultura.PALEOLITICO to 0.5,
        TipoCultura.NEOLITICO to 0.3,
        TipoCultura.EDAD_DE_BRONCE to 0.2
    )
    private val culturasAntiguedad = listOf(
        TipoCultura.VACCEO to 0.4,
        TipoCultura.IBERO to 0.3,
        TipoCultura.CELTA to 0.2,
        TipoCultura.CELTIBERO to 0.1
    )
    private val culturasEdadMedia = listOf(
        TipoCultura.VISIGODO to 0.3,
        TipoCultura.ASTURIANO to 0.4,
        TipoCultura.MUSULMAN to 0.3
    )

    private fun <T> elegirConPeso(opciones: List<Pair<T, Double>>): T {
        val totalPeso = opciones.sumOf { it.second }
        val randomValor = Math.random() * totalPeso
        var acumulado = 0.0
        for ((opcion, peso) in opciones) {
            acumulado += peso
            if (randomValor <= acumulado) {
                return opcion
            }
        }
        return opciones.last().first
    }

    private fun generarCultura(epoca: TipoEpoca): TipoCultura {
        return when (epoca) {
            TipoEpoca.PREHISTORIA -> elegirConPeso(culturasPrehistoria)
            TipoEpoca.ANTIGÜEDAD -> elegirConPeso(culturasAntiguedad)
            TipoEpoca.ROMANA -> TipoCultura.ROMANO
            TipoEpoca.EDAD_MEDIA -> elegirConPeso(culturasEdadMedia)
            TipoEpoca.CONTEMPORANEO -> TipoCultura.MODERNA
            else -> TipoCultura.DESCONOCIDO
        }
    }


    fun generarHallazgoAleatorio(): Hallazgo {
        var nombre: String = "Nombre hallazgo"
        var descripcion: String = "Descripcion placeholder"
        var valor: Int = 0
        val imagen: Int = R.drawable.ic_placeholder
        val epoca = elegirConPeso(epocasConPesos)

        // Seleccionamos la cultura según la época.
        val cultura: TipoCultura = generarCultura(epoca)

        when (cultura) {
            TipoCultura.PALEOLITICO -> listOf(
                {
                    nombre = "Piedra tallada"
                    descripcion =  "Fragmento de herramienta de piedra con bordes afilados, utilizada para cortar carne y procesar alimentos en el Paleolítico."
                    valor = 50
                },
                {
                    nombre = "Fóssil primitivo"
                    descripcion = "Restos óseos de un animal prehistórico, que muestra la fauna que coexistió con los primeros humanos."
                    valor = 200
                }

            ).random()
            TipoCultura.NEOLITICO -> listOf(
                {
                    nombre = "Vasija Cardial"
                    descripcion = "Cerámica decorada con impresiones de conchas, típica del Neolítico, empleada para almacenar granos o líquidos."
                    valor = 30
                },
                {
                    nombre = "Hacha pulida"
                    descripcion = "Herramienta de piedra cuidadosamente trabajada y pulida, usada para la tala y otras tareas agrícolas emergentes en el Neolítico."
                    valor = 100
                }
            ).random()
            TipoCultura.EDAD_DE_BRONCE -> listOf(
                {
                    nombre = "Adorno de bronce"
                    descripcion = "Un pequeño collar o brazalete ornamentado con motivos geométricos, que evidencia el desarrollo de la metalurgia en la Edad del Bronce."
                    valor = 20
                },
                {
                    nombre = "Herramienta de bronce"
                    descripcion = "Un cincel o cuchillo fabricado en bronce, empleado tanto en actividades cotidianas como en la elaboración de objetos ceremoniales."
                    valor = 10
                }
            ).random()
            TipoCultura.VACCEO -> listOf(
                {
                    nombre = "Monumento ritual vacceo"
                    descripcion = "Fragmento de altar o piedra ceremonial con inscripciones y símbolos propios de la cultura vaccea, empleado en ritos comunitarios."
                    valor = 500
                },
                {
                    nombre = "Herramienta agraria"
                    descripcion = "Instrumento de piedra o metal utilizado en labores de campo, que evidencia el sistema colectivo y agrícola de los vacceos."
                    valor = 20
                }
            ).random()
            TipoCultura.IBERO -> listOf(
                {
                    nombre = "Vasija ibérica"
                    descripcion = "Recipiente de cerámica con decoraciones geométricas y figurativas, usado en contextos rituales y cotidianos por los íberos."
                    valor = 40
                },
                {
                    nombre = "Moneda íbera"
                    descripcion = "Una moneda acuñada en la época íbera, con inscripciones y símbolos propios de su sistema económico y cultural."
                    valor = 30
                }
            ).random()
            TipoCultura.CELTA -> listOf(
                {
                    nombre = "Joya en oro celta"
                    descripcion = "Un broche o anillo finamente trabajado, con nudos y espirales característicos del arte celta, hallado en un túmulo funerario."
                    valor = 200
                },
                {
                    nombre = "Bastón ritual"
                    descripcion = "Un cetro decorado con grabados en espiral, posiblemente usado por líderes o druidas en ceremonias y rituales sagrados."
                    valor = 20
                }
            ).random()
            TipoCultura.CELTIBERO -> listOf(
                {
                    nombre = "Estela celtibérica"
                    descripcion = "Piedra tallada con inscripciones y relieves que combinan motivos celtas e ibéricos, reflejando la fusión cultural de los celtíberos."
                    valor = 30
                },
                {
                    nombre = "Fragmento de armadura"
                    descripcion = "Restos de un escudo o coraza en bronce decorada con símbolos celtibéricos, indicativo de la función militar y ritual de la época."
                    valor = 60
                }
            ).random()
            TipoCultura.ROMANO -> listOf(
                {
                    nombre = "Mosaico decorativo"
                    descripcion = "Fragmento de un mosaico de una villa romana, con escenas mitológicas o cotidianas, que resalta la técnica y el arte de la época."
                    valor = 40
                },
                {
                    nombre = "Moneda romana"
                    descripcion = "Una moneda de bronce o plata acuñada durante el Imperio, con el busto del emperador y emblemas imperiales."
                    valor = 50
                }
            ).random()
            TipoCultura.VISIGODO -> listOf(
                {
                    nombre = "Dibula visigoda"
                    descripcion =  "Un broche de metal con formas geométricas y motivos germánicos, usado para asegurar prendas y simbolizar estatus."
                    valor = 20
                },
                {
                    nombre = "Fragmento de manuscrito"
                    descripcion = "Piezas de pergamino con inscripciones en latín y símbolos visigodos, que ofrecen pistas sobre la organización y creencias de la época."
                    valor = 50
                }
            ).random()
            TipoCultura.ASTURIANO -> listOf(
                {
                    nombre = "Cerámica asturiana"
                    descripcion = "Fragmento de vasija decorada, típica de los reinos del norte peninsular, que refleja la estética y costumbres de la época de la Reconquista."
                    valor = 30
                },
                {
                    nombre = "Arma asturiana"
                    descripcion = "Restos de una espada o lanza, que evocan la resistencia y el espíritu guerrero de los primeros reinos cristianos en el norte."
                    valor = 70
                }
            ).random()
            TipoCultura.MUSULMAN -> listOf(
                {
                    nombre = "Azulejo andalusi"
                    descripcion = "Fragmento de azulejo con intrincados patrones geométricos y caligráficos, representativo del arte islámico en la Península Ibérica."
                    valor = 30
                },
                {
                    nombre = "Manuscrito almohade"
                    descripcion = "Páginas o fragmentos de un texto en árabe, con caligrafía ornamentada, que reflejan aspectos administrativos y culturales del dominio musulmán."
                    valor = 60
                }
            )
            TipoCultura.MODERNA -> listOf(
                {
                    nombre = "Botella de vidrio"
                    descripcion = "Una botella vacía encontrada en el campo, más común de lo que desearíamos."
                    valor = 0
                },
                {
                    nombre = "Accesorio moderno"
                    descripcion = "Un pequeño objeto de moda, como una pulsera o reloj, posiblemente caído de un visitante, que añade un guiño humorístico a la mezcla de épocas."
                    valor = 5
                }
            ).random()
            TipoCultura.DESCONOCIDO -> listOf {
                nombre = "Objeto misterioso"
                descripcion = "Objeto irreconocible que deja sin palabras a todos tus expertos"
                valor = 100000
            }
        }

        return Hallazgo(nombre, cultura, epoca, descripcion, imagen, valor)
    }

    fun generarAllHallazgos(): ArrayList<Hallazgo> {
        return arrayListOf(
            Hallazgo(
                nombre = "Piedra tallada",
                cultura = TipoCultura.PALEOLITICO,
                epoca = TipoEpoca.PREHISTORIA,
                descripcion = "Fragmento de herramienta de piedra con bordes afilados, utilizada para cortar carne y procesar alimentos en el Paleolítico.",
                imagen = R.drawable.ic_placeholder,
                valor = 50
            ),
            Hallazgo(
                nombre = "Fóssil primitivo",
                cultura = TipoCultura.PALEOLITICO,
                epoca = TipoEpoca.PREHISTORIA,
                descripcion = "Restos óseos de un animal prehistórico, que muestra la fauna que coexistió con los primeros humanos.",
                imagen = R.drawable.ic_placeholder,
                valor = 200
            ),
            Hallazgo(
                nombre = "Vasija Cardial",
                cultura = TipoCultura.NEOLITICO,
                epoca = TipoEpoca.PREHISTORIA,
                descripcion = "Cerámica decorada con impresiones de conchas, típica del Neolítico, empleada para almacenar granos o líquidos.",
                imagen = R.drawable.ic_placeholder,
                valor = 30
            ),
            Hallazgo(
                nombre = "Hacha pulida",
                cultura = TipoCultura.NEOLITICO,
                epoca = TipoEpoca.PREHISTORIA,
                descripcion = "Herramienta de piedra cuidadosamente trabajada y pulida, usada para la tala y otras tareas agrícolas emergentes en el Neolítico.",
                imagen = R.drawable.ic_placeholder,
                valor = 100
            ),
            Hallazgo(
                nombre = "Adorno de bronce",
                cultura = TipoCultura.EDAD_DE_BRONCE,
                epoca = TipoEpoca.PREHISTORIA,
                descripcion = "Un pequeño collar o brazalete ornamentado con motivos geométricos, que evidencia el desarrollo de la metalurgia en la Edad del Bronce.",
                imagen = R.drawable.ic_placeholder,
                valor = 20
            ),
            Hallazgo(
                nombre = "Herramienta de bronce",
                cultura = TipoCultura.EDAD_DE_BRONCE,
                epoca = TipoEpoca.PREHISTORIA,
                descripcion = "Un cincel o cuchillo fabricado en bronce, empleado tanto en actividades cotidianas como en la elaboración de objetos ceremoniales.",
                imagen = R.drawable.ic_placeholder,
                valor = 10
            ),

            Hallazgo(
                nombre = "Monumento ritual vacceo",
                cultura = TipoCultura.VACCEO,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Fragmento de altar o piedra ceremonial con inscripciones y símbolos propios de la cultura vaccea, empleado en ritos comunitarios.",
                imagen = R.drawable.ic_placeholder,
                valor = 500
            ),
            Hallazgo(
                nombre = "Herramienta agraria",
                cultura = TipoCultura.VACCEO,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Instrumento de piedra o metal utilizado en labores de campo, que evidencia el sistema colectivo y agrícola de los vacceos.",
                imagen = R.drawable.ic_placeholder,
                valor = 20
            ),
            Hallazgo(
                nombre = "Vasija ibérica",
                cultura = TipoCultura.IBERO,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Recipiente de cerámica con decoraciones geométricas y figurativas, usado en contextos rituales y cotidianos por los íberos.",
                imagen = R.drawable.ic_placeholder,
                valor = 40
            ),
            Hallazgo(
                nombre = "Moneda íbera",
                cultura = TipoCultura.IBERO,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Una moneda acuñada en la época íbera, con inscripciones y símbolos propios de su sistema económico y cultural.",
                imagen = R.drawable.ic_placeholder,
                valor = 30
            ),
            Hallazgo(
                nombre = "Joya en oro celta",
                cultura = TipoCultura.CELTA,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Un broche o anillo finamente trabajado, con nudos y espirales característicos del arte celta, hallado en un túmulo funerario.",
                imagen = R.drawable.ic_placeholder,
                valor = 200
            ),
            Hallazgo(
                nombre = "Bastón ritual",
                cultura = TipoCultura.CELTA,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Un cetro decorado con grabados en espiral, posiblemente usado por líderes o druidas en ceremonias y rituales sagrados.",
                imagen = R.drawable.ic_placeholder,
                valor = 20
            ),
            Hallazgo(
                nombre = "Estela celtibérica",
                cultura = TipoCultura.CELTIBERO,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Piedra tallada con inscripciones y relieves que combinan motivos celtas e ibéricos, reflejando la fusión cultural de los celtíberos.",
                imagen = R.drawable.ic_placeholder,
                valor = 30
            ),
            Hallazgo(
                nombre = "Fragmento de armadura",
                cultura = TipoCultura.CELTIBERO,
                epoca = TipoEpoca.ANTIGÜEDAD,
                descripcion = "Restos de un escudo o coraza en bronce decorada con símbolos celtibéricos, indicativo de la función militar y ritual de la época.",
                imagen = R.drawable.ic_placeholder,
                valor = 60
            ),

            Hallazgo(
                nombre = "Mosaico decorativo",
                cultura = TipoCultura.ROMANO,
                epoca = TipoEpoca.ROMANA,
                descripcion = "Fragmento de un mosaico de una villa romana, con escenas mitológicas o cotidianas, que resalta la técnica y el arte de la época.",
                imagen = R.drawable.ic_placeholder,
                valor = 40
            ),
            Hallazgo(
                nombre = "Moneda romana",
                cultura = TipoCultura.ROMANO,
                epoca = TipoEpoca.ROMANA,
                descripcion = "Una moneda de bronce o plata acuñada durante el Imperio, con el busto del emperador y emblemas imperiales.",
                imagen = R.drawable.ic_placeholder,
                valor = 50
            ),

            Hallazgo(
                nombre = "Dibula visigoda",
                cultura = TipoCultura.VISIGODO,
                epoca = TipoEpoca.EDAD_MEDIA,
                descripcion = "Un broche de metal con formas geométricas y motivos germánicos, usado para asegurar prendas y simbolizar estatus.",
                imagen = R.drawable.ic_placeholder,
                valor = 20
            ),
            Hallazgo(
                nombre = "Fragmento de manuscrito",
                cultura = TipoCultura.VISIGODO,
                epoca = TipoEpoca.EDAD_MEDIA,
                descripcion = "Piezas de pergamino con inscripciones en latín y símbolos visigodos, que ofrecen pistas sobre la organización y creencias de la época.",
                imagen = R.drawable.ic_placeholder,
                valor = 50
            ),
            Hallazgo(
                nombre = "Cerámica asturiana",
                cultura = TipoCultura.ASTURIANO,
                epoca = TipoEpoca.EDAD_MEDIA,
                descripcion = "Fragmento de vasija decorada, típica de los reinos del norte peninsular, que refleja la estética y costumbres de la época de la Reconquista.",
                imagen = R.drawable.ic_placeholder,
                valor = 30
            ),
            Hallazgo(
                nombre = "Arma asturiana",
                cultura = TipoCultura.ASTURIANO,
                epoca = TipoEpoca.EDAD_MEDIA,
                descripcion = "Restos de una espada o lanza, que evocan la resistencia y el espíritu guerrero de los primeros reinos cristianos en el norte.",
                imagen = R.drawable.ic_placeholder,
                valor = 70
            ),
            Hallazgo(
                nombre = "Azulejo andalusi",
                cultura = TipoCultura.MUSULMAN,
                epoca = TipoEpoca.EDAD_MEDIA,
                descripcion = "Fragmento de azulejo con intrincados patrones geométricos y caligráficos, representativo del arte islámico en la Península Ibérica.",
                imagen = R.drawable.ic_placeholder,
                valor = 30
            ),
            Hallazgo(
                nombre = "Manuscrito almohade",
                cultura = TipoCultura.MUSULMAN,
                epoca = TipoEpoca.EDAD_MEDIA,
                descripcion = "Páginas o fragmentos de un texto en árabe, con caligrafía ornamentada, que reflejan aspectos administrativos y culturales del dominio musulmán.",
                imagen = R.drawable.ic_placeholder,
                valor = 60
            ),

            Hallazgo(
                nombre = "Botella de vidrio",
                cultura = TipoCultura.MODERNA,
                epoca = TipoEpoca.CONTEMPORANEO,
                descripcion = "Una botella vacía encontrada en el campo, más común de lo que desearíamos.",
                imagen = R.drawable.ic_placeholder,
                valor = 0
            ),
            Hallazgo(
                nombre = "Accesorio moderno",
                cultura = TipoCultura.MODERNA,
                epoca = TipoEpoca.CONTEMPORANEO,
                descripcion = "Un pequeño objeto de moda, como una pulsera o reloj, posiblemente caído de un visitante, que añade un guiño humorístico a la mezcla de épocas.",
                imagen = R.drawable.ic_placeholder,
                valor = 5
            ),

            Hallazgo(
                nombre = "Objeto misterioso",
                cultura = TipoCultura.DESCONOCIDO,
                epoca = TipoEpoca.DESCONOCIDO,
                descripcion = "Objeto irreconocible que deja sin palabras a todos tus expertos.",
                imagen = R.drawable.ic_placeholder,
                valor = 100000
            )
        )
    }

}