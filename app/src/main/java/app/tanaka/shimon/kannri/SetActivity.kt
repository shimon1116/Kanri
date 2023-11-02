package app.tanaka.shimon.kannri

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.tanaka.shimon.kannri.databinding.ActivitySetBinding

class SetActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val stringtext = binding.editTextNumber.text.toString()
        val pref : SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val back = Intent(this, MainActivity::class.java)

        binding.saveButton.setOnClickListener {
            val editor = pref.edit()
            editor.putInt("GoalKey", stringtext.toInt())
            editor.apply()
            startActivity(back)
        }
    }
}