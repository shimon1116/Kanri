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
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val back = Intent(this, MainActivity::class.java)

        binding.button.setOnClickListener {
            val stringtext = binding.editTextNumber2.toString()
            val editor = pref.edit()
            val intValue = stringtext.toInt()
            // 整数値として保存
            //editor.putInt("GoalKey", intValue)
            editor.putInt("Money", intValue)
            editor.apply()
            startActivity(back)
        }
    }
}