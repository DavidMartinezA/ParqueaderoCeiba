package com.example.ceibaparqueadero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.valueobject.Parqueadero

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carroJuan= Carro("hsu547")
        val motoJuan= Moto("lid50c", false)
        val parqueaderoCeiba = Parqueadero()

        parqueaderoCeiba.ingresoVehiculos(carroJuan)
        parqueaderoCeiba.ingresoVehiculos(motoJuan)
        val tarifaCarro =  parqueaderoCeiba.cobroTarifaCarro(9, carroJuan).toString()
        val tarifaMoto =  parqueaderoCeiba.cobroTarifaMoto(5, motoJuan).toString()

        Log.i("Prueba de Codigo 1",tarifaCarro)
        Log.i("Prueba de Codigo 2",tarifaMoto)
    }
}