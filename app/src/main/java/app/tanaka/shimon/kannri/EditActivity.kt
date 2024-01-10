package app.tanaka.shimon.kannri

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.tanaka.shimon.kannri.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater).apply { setContentView(this.root) }

    }

    override fun onResume() {
        super.onResume()
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val back = Intent(this, MainActivity::class.java)


        var money = pref.getInt("Money", 0)
        binding.button.setOnClickListener {
            val stringtext = binding.editTextNumber2.text.toString()
            val editor = pref.edit()
            money = money - stringtext.toInt()
            editor.putInt("Money", money)
            editor.apply()
            startActivity(back)
            finish()
        }
    }
}