package com.example.parcial


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.VideoView
import java.util.*
import kotlin.concurrent.timerTask

//en este activity se realiza el splashcreen, se realizo una nueva carpeta raw y se agrego
// el recurso mp4 para lo que es el splashcreen el video se realizo en la plataforma canva

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//se crea la variable del video y su id en el xml
        val video: VideoView =findViewById(R.id.motomami)
        //se utiliza el recurso anteriormente mencionado en la carpeta r.raw
        video.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.tecnology))
        //se inicia el video
        video.start()
        //se utiliza la funcion de abajo
        despues()


    }
    fun despues(){
        //se le asigna un tiempo de ejeucion y un tiempo en que se quedara paralizado
        object: CountDownTimer(4000,1000){
            override fun onTick(p0: Long) {
            //esta funcion no se necesita entonces se deja en blanco

            }

            override fun onFinish() {
                //en esta funcion se termina el tiempo determinado y se tranladara al activity asignado
                //lo pensado es que este activity funciones como splashcreen y el siguiente en donde se agregue lo siguiente.
                val intent=Intent(applicationContext,pedidos::class.java)
                startActivity(intent)



            }


        }
                //se inicia el contador
            .start()
    }






}