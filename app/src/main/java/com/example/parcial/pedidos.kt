package com.example.parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_pedidos.*
//en este activity se tiene pensado recibir los datos que se desean para la actividad(nombre,cantidad de producto y descripcion del producto)
// se asignaron dos botones el de la parte inferior para mandar la informacion a la firebase y el de la parte superior para transladar al siguiente activity
class pedidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        //se crea el evento oncliclistener del boton que dirige al siguiente activity
        integrante.setOnClickListener {
            val intent= Intent(this,creador::class.java)
            //abrimos el activity
            startActivity(intent)
        }
        // se crea el evento oncliclistener del siguiente imagebuton este valida si se han rellenado todos los campos
        //y manda los datos a la firebase
        img_tankiunext.setOnClickListener {
           //se realiza una condicion if que nos dice que si los edit text estan vacios
            // enviara un mensaje toast que nos dice: "llena todos los campos"
            if(nombre.text.isEmpty()||addres.text.isEmpty()||want.text.isEmpty()){
                Toast.makeText(this, "llena todos los campos", Toast.LENGTH_SHORT).show()


        }
            //si no se cumple lo anteriormente mencionado proseguimos creando variables string que almacenaran nuestra
            //recopilada de los edit text
            else{
                var name: String=nombre.text.toString()
                var product: String=want.text.toString()
                var cantidad: String=addres.text.toString()
                //se llama a la funcion insertbase con los argumentos necesarios
                insertbase(name,product,cantidad)
                //se muestra un toast que nos dice que: "tu pedido ha sido enviado"
                Toast.makeText(this,"tu pedido ha sido enviado",Toast.LENGTH_LONG).show()
                //se limpian las variables una vez ya enviados los datos
                nombre.setText("")
                want.setText("")
                addres.setText("")
            }




    }



}
    // esta funcion es la encargada de mandar los datos a la base de datos firebase
    fun insertbase(cliente:String,producto:String,cantidad:String){
        val shop=HashMap<String,String>()
        //se describen los valores y como se llaman en la base de datos
        shop["cliente"]=cliente.toString()
        shop["producto"]=producto.toString()
        shop["cantidad"]=cantidad.toString()
        //se hace la instaciacion de la base de datos y el nombre de esta
        val rootRef=FirebaseDatabase.getInstance().reference
        val taskRef= rootRef.child("pedidos").push()
        taskRef.setValue(shop)

    }
}