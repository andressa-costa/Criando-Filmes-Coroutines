package com.everis.filmescoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.everis.filmescoroutines.ui.main.MainFragment
import com.example.projeto_kotlin_coroutines_mvvm_livedata.R
import com.example.projeto_kotlin_coroutines_mvvm_livedata.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}