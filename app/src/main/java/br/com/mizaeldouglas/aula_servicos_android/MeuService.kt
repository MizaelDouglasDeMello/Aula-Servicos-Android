package br.com.mizaeldouglas.aula_servicos_android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MeuService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Service", "onCreate ")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val myThread = MyThread()
        myThread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    inner class MyThread : Thread() {
        override fun run() {
            super.run()
            for (i in 0..10) {
                Log.i("Service", "Contador: $i")
                sleep(1000)
                Log.i("Service", "run: MyThread")
            }
            stopSelf()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("Service", "onDestroy")
    }
}