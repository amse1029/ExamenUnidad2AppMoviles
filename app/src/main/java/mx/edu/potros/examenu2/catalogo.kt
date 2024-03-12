package mx.edu.potros.examenu2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class catalogo : AppCompatActivity() {

var detallesAdapter:DetalleAdapter?=null
var globosAdapter:DetalleAdapter?=null
var peluchesAdapter:DetalleAdapter?=null
var regalosAdapter:DetalleAdapter?=null
var tazasAdapter:DetalleAdapter?=null

var detalles=ArrayList<Detalles>()
var globos=ArrayList<Detalles>()
var peluches=ArrayList<Detalles>()
var regalos=ArrayList<Detalles>()
var tazas=ArrayList<Detalles>()

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.regalos)

    cargarDetalles()
    cargarGlobos()
    cargarPeluches()
    cargarRegalos()
    cargarTazas()


    detallesAdapter = DetalleAdapter(this, detalles)
    globosAdapter = DetalleAdapter(this, globos)
    peluchesAdapter = DetalleAdapter(this, peluches)
    regalosAdapter = DetalleAdapter(this, regalos)
    tazasAdapter = DetalleAdapter(this, tazas)

    var gridDetalles: GridView = findViewById(R.id.grid_regalos_detalles)

    gridDetalles.adapter = detallesAdapter
}

fun cargarDetalles() {
    detalles.add(Detalles(R.drawable.cumplebotanas, "$280"))
    detalles.add(Detalles(R.drawable.cumplecheve, "$320"))
    detalles.add(Detalles(R.drawable.cumpleescolar, "$330"))
    detalles.add(Detalles(R.drawable.cumplepaletas, "$190"))
    detalles.add(Detalles(R.drawable.cumplesnack, "$150"))
    detalles.add(Detalles(R.drawable.cumplevinos, "$370"))
}

    fun cargarGlobos() {
        globos.add(Detalles(R.drawable.globoamor, "$240"))
        globos.add(Detalles(R.drawable.globocumple, "$820"))
        globos.add(Detalles(R.drawable.globofestejo, "$260"))
        globos.add(Detalles(R.drawable.globonum, "$760"))
        globos.add(Detalles(R.drawable.globoregalo, "$450"))
        globos.add(Detalles(R.drawable.globos, "$240"))
    }

fun cargarRegalos() {
    regalos.add(Detalles(R.drawable.regaloazul, "$80"))
    regalos.add(Detalles(R.drawable.regalobebe, "$290"))
    regalos.add(Detalles(R.drawable.regalocajas, "$85"))
    regalos.add(Detalles(R.drawable.regalocolores, "$85"))
    regalos.add(Detalles(R.drawable.regalos, "$"))
    regalos.add(Detalles(R.drawable.regalovarios, "$75"))
}

    fun cargarPeluches() {
        peluches.add(Detalles(R.drawable.peluchemario, "$320"))
        peluches.add(Detalles(R.drawable.pelucheminecraft, "$320"))
        peluches.add(Detalles(R.drawable.peluchepeppa, "$290"))
        peluches.add(Detalles(R.drawable.peluches, "$"))
        peluches.add(Detalles(R.drawable.peluchesony, "$330"))
        peluches.add(Detalles(R.drawable.peluchestich, "$280"))
        peluches.add(Detalles(R.drawable.peluchevarios, "$195"))
    }

    fun cargarTazas() {
        tazas.add(Detalles(R.drawable.tazaabuela, "$80"))
        tazas.add(Detalles(R.drawable.tazalove, "$290"))
        tazas.add(Detalles(R.drawable.tazaquiero, "$85"))
        tazas.add(Detalles(R.drawable.tazas, "$85"))
    }
}

class DetalleAdapter: BaseAdapter {
    var detalles=ArrayList<Detalles>()
    var context: Context?=null

    constructor(context: Context, detalles:ArrayList<Detalles>):super() {
        this.detalles = detalles
        this.context = context
    }

    override fun getCount(): Int {
        return detalles.size
    }

    override fun getItem(p0: Int): Any {
        return detalles[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
        var detalle =detalles[pe]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.detalle_regalos, null)
        var image: ImageView =vista.findViewById(R.id.iv_regalo_imagen)
        var precio: TextView =vista.findViewById(R.id.tv_regalo_precio)

        image.setImageResource(detalle.image)
        precio.setText(detalle.precio)

        image.setOnClickListener {
            var intento = Intent(context, Detalles::class.java)
            intento.putExtra("precio", detalle.precio)
            intento.putExtra("imagen", detalle.image)
            context!!.startActivity(intento)
        }
        return vista
    }

}