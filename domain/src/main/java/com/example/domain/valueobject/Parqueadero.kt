package com.example.domain.valueobject

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo

class Parqueadero : CobroServicio {

    private var listaVehiculo = arrayListOf<Vehiculo>()
    private val diaDeLaSemana = DiaDeLaSemana().diaSemana()
    private val diasPermitidos = arrayListOf("Domingo", "Lunes")

    private fun restriccionIngreso(numeroPlaca: String): Boolean {

        var restringido = false

        if (numeroPlaca.isEmpty()) {
            restringido = true// todo mostrar mensaje que no es admintido
        } else {
            if (numeroPlaca.first().uppercase() == LETRA_RESTRINGIDA) {
                restringido = !diasPermitidos.contains(diaDeLaSemana)
            }
        }
        return restringido
    }

    fun ingresoVehiculos(vehiculo: Vehiculo) {
        var hayCupo = false

        when (vehiculo) {
            is Carro -> {
                val cuantosCarros = listaVehiculo.filterIsInstance<Carro>().size
                hayCupo = cuantosCarros <= LIMITE_CARRO
            }
            is Moto -> {
                val cuantasMotos = listaVehiculo.filterIsInstance<Moto>().size
                hayCupo = cuantasMotos <= LIMITE_MOTO
            }
        }

        if (restriccionIngreso(vehiculo.numeroPlaca) && hayCupo) {
            listaVehiculo.add(vehiculo)
        }

    }

    fun salidaVehiculos(vehiculo: Vehiculo): Boolean {
        listaVehiculo.remove(vehiculo)
        return true
    }

    companion object {

        const val LETRA_RESTRINGIDA = "A"
        const val LIMITE_MOTO = 10
        const val LIMITE_CARRO = 20
        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val VALOR_HORA_CARRO = 1000
        const val VALOR_DIA_CARRO = 8000

    }
}
