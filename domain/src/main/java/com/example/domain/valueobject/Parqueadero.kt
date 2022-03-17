package com.example.domain.valueobject


import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import kotlin.math.ceil

class Parqueadero {

    private var listaVehiculo = arrayListOf<Vehiculo>()
    private val diaDeLaSemana = DiaDeLaSemana().diaSemana()
    private val valorHoraMoto = 500
    private val valorDiaMoto = 4000
    private val valorHoraCarro = 1000
    private val valorDiaCarro = 8000
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

    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int {

        var tarifaParqueoTotal: Int
        if (duracionServicio < 9) {
            tarifaParqueoTotal = duracionServicio * valorHoraMoto
        } else {
            tarifaParqueoTotal = (ceil((duracionServicio / 24).toDouble()) * valorDiaMoto).toInt()

        }
        if (moto.cilindrajeAlto) {
            tarifaParqueoTotal += 2000
        }
        return tarifaParqueoTotal
    }

    fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int {

        val tarifaParqueoTotal: Int
        duracionServicio.toDouble()
        val fraccionDias = 24.0 / duracionServicio
        ceil(fraccionDias)


        if (duracionServicio < 9) {
            tarifaParqueoTotal = duracionServicio * valorHoraCarro
        } else {
            tarifaParqueoTotal = (fraccionDias * valorDiaCarro).toInt()
        }
        return tarifaParqueoTotal
    }

    fun salidaVehiculos(vehiculo: Vehiculo): Boolean {
        listaVehiculo.remove(vehiculo)
        return true
    }

    companion object {
        const val LETRA_RESTRINGIDA = "A"
        const val LIMITE_MOTO = 10
        const val LIMITE_CARRO = 20
    }
}
