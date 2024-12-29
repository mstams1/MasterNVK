package com.example.masternvk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // Назначаем обработчик клика для кнопки "ПЕРЕЗАПИСАТЬ"
        findViewById<Button>(R.id.btn_record).setOnClickListener {
// Получаем новые значения dnogrunt и dnoseben из EditText
            val dnogrunt = findViewById<EditText>(R.id.tbdnogrunt).text.toString().toFloat()
            val dnoseben = findViewById<EditText>(R.id.tbdnosheben).text.toString().toFloat()

// Создаем Intent для передачи результата в главное активити
            val intent = Intent()
// Передаем новые значения dnogrunt и dnoseben в MainActivity
            intent.putExtra("dnogrunt", dnogrunt)
            intent.putExtra("dnoseben", dnoseben)
// Возвращаем результат в MainActivity
            setResult(RESULT_OK, intent)
// Закрываем EditActivity
            finish()

        }


    }
}