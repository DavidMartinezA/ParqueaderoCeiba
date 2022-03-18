package com.example.domain.valueobject

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import kotlin.math.ceil

interface CobroServicio {


    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int {

        var tarifaParqueoTotal: Int
        if (duracionServicio < 9) {
            tarifaParqueoTotal = duracionServicio * Parqueadero.VALOR_HORA_MOTO
        } else {
            tarifaParqueoTotal = (ceil((duracionServicio / 24).toDouble()) * Parqueadero.VALOR_DIA_MOTO).toInt()

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
            tarifaParqueoTotal = duracionServicio * Parqueadero.VALOR_HORA_CARRO
        } else {
            tarifaParqueoTotal = (fraccionDias * Parqueadero.VALOR_DIA_CARRO).toInt()
        }
        return tarifaParqueoTotal
    }
}