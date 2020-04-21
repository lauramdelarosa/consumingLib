package com.delarosa.fisrtclient

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scarecrow.ui.BackActivity
import com.scarecrow.ui.FrontActivity
import com.scarecrow.ui.FrontActivity.Companion.ID_NUMBER
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        front?.setOnClickListener {
            if (editTextCedula.text.isNotEmpty()) {
                val intent = Intent(this, FrontActivity::class.java).putExtra(ID_NUMBER, editTextCedula?.text.toString())
                startActivityForResult(intent, REQUEST_CODE_FRONT)
            }
        }
        back?.setOnClickListener {
            val intent = Intent(this, BackActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_BACK)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_BACK && resultCode == Activity.RESULT_OK) {
            ResultActivity.responseScanner = BackActivity.scarecrowBack
            startActivity(Intent(this, ResultActivity::class.java))
        }

        if (requestCode == REQUEST_CODE_FRONT && resultCode == Activity.RESULT_OK) {
            ResultActivity.responseScanner = FrontActivity.scarecrowFront
            startActivity(Intent(this, ResultActivity::class.java))
        }

    }

    companion object {
        val REQUEST_CODE_BACK = 1
        val REQUEST_CODE_FRONT = 2
    }

}
