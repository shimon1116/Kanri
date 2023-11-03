package app.tanaka.shimon.kannri

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.tanaka.shimon.kannri.databinding.ActivityMainBinding
import app.tanaka.shimon.kannri.databinding.ActivitySetBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val pref : SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        //var money = pref.getInt("GoalKey", 0)

        val moneyString = pref.getString("GoalKey", "0")
        var money = moneyString?.toIntOrNull() ?: 0

        //var money = pref.getInt("GoalKey", 0)
        //var money = goal
        //var money = 0
        val editor = pref.edit()


        binding.money.setTextColor(Color.parseColor("#F9B208"))
        binding.money.text = "￥" + money.toString()


        binding.plus100.setOnClickListener {
            money = money - 100
            if (money < 0) {
                //money = money * -1
                binding.money.setTextColor(Color.RED)
                binding.money.text = "￥" + money.toString()
                editor.putString("GoalKey", money.toString())
                editor.apply()
            } else {
                binding.money.text = "￥" + money.toString()
                editor.putString("GoalKey", money.toString())
                editor.apply()
            }
        }

        binding.plus1000.setOnClickListener {
            money = money - 1000
            if (money < 0) {
                //money = money * -1
                binding.money.setTextColor(Color.RED)
                binding.money.text = "￥" + money.toString()
                editor.putString("GoalKey", money.toString())
                editor.apply()
            } else {
                binding.money.text = "￥" + money.toString()
                editor.putString("GoalKey", money.toString())
                editor.apply()
            }
        }

        binding.plus10000.setOnClickListener {
            money = money - 10000
            if (money < 0) {
                //money = money * -1
                binding.money.setTextColor(Color.RED)
                binding.money.text = "￥" + money.toString()
                editor.putString("GoalKey", money.toString())
                editor.apply()
            } else {
                binding.money.text = "￥" + money.toString()
                editor.putString("GoalKey", money.toString())
                editor.apply()
            }
        }

        binding.setButton.setOnClickListener {
            val setIntent = Intent(this, SetActivity::class.java)
            startActivity(setIntent)
            finish()
        }
    }
}