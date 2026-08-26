package com.example.a24012011182_mad_practical_6

import android.app.Service
import android.app.Service.START_STICKY
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlarmService : Service() {
    var mp: MediaPlayer ? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            if (mp == null) {
                mp = MediaPlayer.create(this, R.raw.alarm)
            }
            mp?.start()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        mp?.stop()
        super.onDestroy()
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}