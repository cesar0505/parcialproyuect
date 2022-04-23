package com.example.parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_pedidos.*

class pedidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        integrante.setOnClickListener {
            val intent= Intent(this,creador::class.java)
            startActivity(intent)
        }
        img_tankiunext.setOnClickListener {
            if(nombre.text.isEmpty()||addres.text.isEmpty()||want.text.isEmpty()){
                Toast.makeText(this, "llena todos los campos", Toast.LENGTH_SHORT).show()


        }
            else{
                var name: String=nombre.text.toString()
                var product: String=want.text.toString()
                var cantidad: String=addres.text.toString()
                insertbase(name,product,cantidad)
                Toast.makeText(this,"tu pedido ha sido enviado",Toast.LENGTH_LONG).show()
                nombre.setText("")
                want.setText("")
                addres.setText("")
            }




    }

}
    fun insertbase(cliente:String,producto:String,cantidad:String){
        val shop=HashMap<String,String>()
        shop["cliente"]=cliente.toString()
        shop["producto"]=producto.toString()
        shop["cantidad"]=cantidad.toString()
        val rootRef=FirebaseDatabase.getInstance().reference
        val taskRef= rootRef.child("pedidos").push()
        taskRef.setValue(shop)

    }
}