// MainActivity
package app.tanaka.shimon.kannri

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.tanaka.shimon.kannri.databinding.ActivityMainBinding
import app.tanaka.shimon.kannri.databinding.ActivitySetBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

    }

    override fun onResume() {
        super.onResume()
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        // SharedPreferencesからデータを取得する際、デフォルト値として0を指定
        val editor = pref.edit()
        var money = pref.getInt("Money", 0)
        editor.putInt("Money", money)
        editor.apply()

        binding.moneyText.text = "￥ $money"

        binding.resetbutton.setOnClickListener {
            money = 0
            editor.putInt("Money", money)
            editor.apply()
            binding.moneyText.text = "￥ $money"
            if (money < 0) {
                binding.moneyText.setTextColor(Color.RED)
            } else {
                binding.moneyText.setTextColor(Color.GREEN)
            }
        }

        if (money < 0) {
            binding.moneyText.setTextColor(Color.RED)
        } else {
            binding.moneyText.setTextColor(Color.GREEN)
        }

        //var money = pref.getInt("GoalKey", 0)
        //val editor = pref.edit()
        //binding.money.setTextColor(Color.parseColor("#F9B208"))
        //binding.money.text = "￥" + money.toString()

        binding.plus100.setOnClickListener {
            money = money - 100
            if (money < 0) {
                binding.moneyText.setTextColor(Color.RED)
                binding.moneyText.text = "￥" + money.toString()
                editor.putInt("Money", money)
                editor.apply()
            } else {
                binding.moneyText.text = "￥" + money.toString()
                editor.putInt("Money", money)
                editor.apply()
            }
        }

        binding.plus500.setOnClickListener {
            money = money - 500
            if (money < 0) {
                binding.moneyText.setTextColor(Color.RED)
                binding.moneyText.text = "￥" + money.toString()
                editor.putInt("Money", money)
                editor.apply()
            } else {
                binding.moneyText.text = "￥" + money.toString()
                editor.putInt("Money", money)
                editor.apply()
            }
        }

        binding.plus1000.setOnClickListener {
            money = money - 1000
            if (money < 0) {
                binding.moneyText.setTextColor(Color.RED)
                binding.moneyText.text = "￥" + money.toString()
                editor.putInt("Money", money)
                editor.apply()
            } else {
                binding.moneyText.text = "￥" + money.toString()
                editor.putInt("Money", money)
                editor.apply()
            }
        }

        binding.setMoneyButton.setOnClickListener {
            val editIntent = Intent(this, EditActivity::class.java)
            startActivity(editIntent)
            finish()
        }

        binding.setButton.setOnClickListener {
            val setIntent = Intent(this, SetActivity::class.java)
            startActivity(setIntent)
            finish()
        }
    }
}