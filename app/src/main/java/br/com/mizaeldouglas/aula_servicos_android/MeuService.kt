package br.com.mizaeldouglas.aula_servicos_android

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MeuService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}