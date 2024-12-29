package com.example.masternvk

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import java.util.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_result).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val data = calculate()
            intent.putExtra("hss", data);
            startActivity(intent);

        }
        findViewById<Button>(R.id.btn_redact).setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)

        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.power)
        // устанавливает объект Toolbar как действующий тулбар в активности.
        setSupportActionBar(toolbar)
        // выход на кнопку выключить
        toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayShowTitleEnabled(false);


    }
    //добавляем наше созданое меню
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    fun popupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_main)


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.avtor -> {
                val telegram = Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=MasterNVK_Bot"))
                startActivity(telegram)
                return true
            }
            R.id.abount -> {
                val youtube = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=8mPDu18or08"))
                startActivity(youtube)
                return true
            }
            R.id.abount2 -> {
                val manual = Intent(Intent.ACTION_VIEW, Uri.parse("https://disk.yandex.ru/i/hRLy5jrkn01Oqg"))
                startActivity(manual)
                return true
            }
            R.id.donate_author -> { // Благодарность - Разработчику
                val donate = Intent(Intent.ACTION_VIEW, Uri.parse("https://pay.cloudtips.ru/p/ed8430bb"))
                startActivity(donate)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
// Получаем новые значения dnogrunt и dnoseben из второго активити
            val dnogrunt = data.getFloatExtra("dnogrunt", 0f)
            val dnoseben = data.getFloatExtra("dnoseben", 0f)

// Перезаписываем значения переменных dnogrunt и dnoseben с помощью оператора "="
            this.dnogrunt = dnogrunt
            this.dnoseben = dnoseben

            val toast = Toast.makeText(this, "Данные успешно перезаписаны", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

// Обновляем интерфейс приложения, чтобы отобразить новые значения
            updateUI()
        }
    }

    private fun updateUI() {

    }

    var dnogrunt = 00.37F
    var dnoseben = 00.17F

    val kolzahvat = 0

    fun calculate() : String
    {
        var output : String = "";
        val gorizont :Float = findViewById<TextView>(R.id.tb1).text.toString().toFloat()
        val lotok1 :Float = findViewById<TextView>(R.id.tb2).text.toString().toFloat()
        val lotok2 :Float = findViewById<TextView>(R.id.tb3).text.toString().toFloat()
        val truba :Float = findViewById<TextView>(R.id.tb4).text.toString().toFloat()
        val pesok :Float = findViewById<TextView>(R.id.tb5).text.toString().toFloat()
        var kolzahvat :Int = findViewById<TextView>(R.id.tb6).text.toString().toInt()

        val gorlot1 = gorizont - lotok1
        val gorlot2 = gorizont - lotok2
        val verhtrub1 = gorlot1 - truba
        val verhtrub2 = gorlot2 - truba
        val gruntlot1 = gorlot1 + pesok
        val gruntlot2 = gorlot2 + pesok
        val dnogrunt1 = gorlot1 + dnogrunt
        val dnogrunt2 = gorlot2 + dnogrunt
        val dnoseben1 = gorlot1 + dnoseben
        val dnoseben2 = gorlot2 + dnoseben
        val uklon = gorlot2 - gorlot1
        val st1 = uklon / kolzahvat.toFloat()
        var vn : String = if (lotok1 > lotok2) " - Идём ВНИЗ \uD83D\uDC47" else " - Идём ВВЕРХ \uD83D\uDC46"

        fun printf_(value : Float, kolzahvat : Int, st1 : Float) : String {
            val kolzahvat_2 = kolzahvat;
            var output : String = ""

            for (i in 1..kolzahvat_2) {
                val formattedValue = String.format(Locale.US, "%.3f", value + st1 * i)
                output += " [ $formattedValue"
            }

            return output
        }

        output += ( String.format("\nОт1.ВерхТрубы.\n\t%.3f", verhtrub1) )
        output += printf_(verhtrub1, kolzahvat, st1);
        output += ( String.format("\nОт1.Лот/Песок.\n\t%.3f", gorlot1) )
        output += printf_(gorlot1, kolzahvat, st1);
        output += ( String.format("\nОт1.Грунт.\n\t%.3f", gruntlot1) )
        output += printf_(gruntlot1, kolzahvat, st1);
        output += ("\n")
        output += ("\n")
        output += String.format("ДноЩе.1 = %.2f  |  ДноГр.1 = %.2f\n", dnoseben1, dnogrunt1)
        output += String.format("ДноЩе.2 = %.2f  |  ДноГр.2 = %.2f\n", dnoseben2, dnogrunt2)
        output += ("\n")
        output += ( String.format("Уклон = %.3f $vn\n", uklon) )
        output += ("\n")

        output += ( String.format("Гор. = %.3f | Л1 = %.3f | Л2 = %.3f | В.т = %.3f | Пес. = %.2f | К.з = %d\n", gorizont, lotok1, lotok2, truba, pesok, kolzahvat) )





        return output;
    }
}




private fun findItem(menuItem2: Int) {

    }
