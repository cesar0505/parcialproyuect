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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val video: VideoView =findViewById(R.id.motomami)
        video.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.tecnology))
        video.start()
        despues()


    }
    fun despues(){
        object: CountDownTimer(4000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent=Intent(applicationContext,pedidos::class.java)
                startActivity(intent)



            }


        }
            .start()
    }






}