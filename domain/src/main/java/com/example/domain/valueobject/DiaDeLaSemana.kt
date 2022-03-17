package com.example.domain.valueobject

import java.time.LocalDate

class DiaDeLaSemana {

    private lateinit var diaHoy: String
    private var diaSemana = LocalDate.now().dayOfWeek.name

    fun diaSemana():String {
        when (diaSemana) {
            "Monday" -> {
                diaHoy = "Lunes"
            }
            "Tuesday" -> {
                diaHoy = "Martes"
            }
            "Wednesday" -> {
                diaHoy = "Miercoles"
            }
            "thursday" -> {
                diaHoy = "Jueves"
            }
            "Friday" -> {
                diaHoy = "Viernes"
            }
            "Saturday" -> {
                diaHoy = "Sabado"
            }
            "Sunday" -> {
                diaHoy = "Domingo"
            }
            else -> {
                diaHoy ="Domingo"
            }
        }
        return diaHoy
    }
}