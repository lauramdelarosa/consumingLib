package com.delarosa.fisrtclient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scarecrow.model.ResponseScanner
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        responseScanner?.let {
            val text =
                "Cedula: ${responseScanner?.identificationCard?.id} Fecha: ${responseScanner?.identificationCard?.birthDate} Sexo: ${responseScanner?.identificationCard?.gender}  Rh: ${responseScanner?.identificationCard?.rh} Nombres: ${responseScanner?.identificationCard?.firstName} ${responseScanner?.identificationCard?.secondName} ${responseScanner?.identificationCard?.surName} ${responseScanner?.identificationCard?.lastName}"
            info?.text = text
            image?.setImageBitmap(responseScanner?.imgBase64)
        }
    }

    companion object {
        var responseScanner: ResponseScanner? = ResponseScanner()
    }
}
