package app.tanaka.shimon.kannri

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.tanaka.shimon.kannri.databinding.ActivitySetBinding

class SetActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val back = Intent(this, MainActivity::class.java)

        binding.saveButton.setOnClickListener {
            var a = 0
            val stringtext = binding.editTextNumber.text.toString()
            val editor = pref.edit()
            val intValue = stringtext.toInt()
            if (intValue >= 0) {
                // 整数値として保存
                editor.putInt("GoalKey", intValue)
                editor.apply()
                startActivity(back)
                finish()
            } else {
                // 整数値として保存
                editor.putInt("GoalKey", 0)
                editor.apply()
                startActivity(back)
                finish()
            }

        }
    }
}