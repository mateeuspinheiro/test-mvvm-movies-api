package com.pinheiro.desafiom2u

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import com.pinheiro.desafiom2u.ui.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler  = Handler()
        handler.postDelayed({

            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2800) //Delay de 2,8 Seg respeitando tempo máximo de abertura

    }
}