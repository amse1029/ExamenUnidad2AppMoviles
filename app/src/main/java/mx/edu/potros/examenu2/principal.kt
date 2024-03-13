package mx.edu.potros.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)



        val btn_detalles: Button = findViewById(R.id.btn_detalles)
        val btn_regalos: Button = findViewById(R.id.btn_regalos)
        val btn_globos: Button = findViewById(R.id.btn_globos)
        val btn_peluches: Button = findViewById(R.id.btn_peluches)
        val btn_tazas: Button = findViewById(R.id.btn_tazas)

        btn_detalles.setOnClickListener() {
            var intent: Intent = Intent(this, regalos::class.java)
            intent.putExtra("selection", "Detalles")
            startActivity(intent)
        }

        btn_regalos.setOnClickListener() {
            var intent: Intent = Intent(this, regalos::class.java)
            intent.putExtra("selection", "Regalos")
            startActivity(intent)
        }

        btn_globos.setOnClickListener() {
            var intent: Intent = Intent(this, regalos::class.java)
            intent.putExtra("selection", "Globos")
            startActivity(intent)
        }

        btn_tazas.setOnClickListener() {
            var intent: Intent = Intent(this, regalos::class.java)
            intent.putExtra("selection", "Tazas")
            startActivity(intent)
        }

        btn_peluches.setOnClickListener() {
            var intent: Intent = Intent(this, regalos::class.java)
            intent.putExtra("selection", "Peluches")
            startActivity(intent)
        }
    }
}