package com.example.masternvk
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {


    @SuppressLint("SetTextI18n", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data = getIntent().extras!!.getString("hss")
        findViewById<TextView>(R.id.textView22).setText(data)



// Добавляем в тулбар стрелку назад
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
        // Переопределяем функцию onOptionsItemSelected для обработки нажатий на элементы меню
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == android.R.id.home)  {
                finish() //закрываем активити можем назначить другое
                return true
            }
            return super.onOptionsItemSelected(item)
        }














    }
