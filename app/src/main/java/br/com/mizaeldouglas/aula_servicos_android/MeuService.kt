package br.com.mizaeldouglas.aula_servicos_android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class MeuService : Service() {

    private val coroutine = CoroutineScope(Dispatchers.IO)


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("my_service", "onCreate ")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        val myThread = MyThread()
//        myThread.start()

        coroutine.launch {
            for (i in 0..10) {
                Log.i("my_service", "Contador: $i")
                delay(2000)
                Log.i("my_service", "run: MyThread")
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


    inner class MyThread : Thread() {
        override fun run() {
            super.run()
            for (i in 0..10) {
                Log.i("my_service", "Contador: $i")
                sleep(1000)
                Log.i("my_service", "run: MyThread")
            }
            stopSelf()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        coroutine.cancel()
        Log.i("my_service", "onDestroy")
    }
}