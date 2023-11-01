package app.tanaka.shimon.kannri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.tanaka.shimon.kannri.databinding.ActivityMainBinding
import app.tanaka.shimon.kannri.databinding.ActivitySetBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        var money = 0
        val setIntent = Intent(this, SetActivity::class.java)


        binding.money.text = "￥" + money.toString()


        binding.plus100.setOnClickListener {
            money = money - 100
            binding.money.text = "￥" + money.toString()
        }

        binding.plus1000.setOnClickListener {
            money = money - 1000
            binding.money.text = "￥" + money.toString()
        }

        binding.plus10000.setOnClickListener {
            money = money - 10000
            binding.money.text = "￥" + money.toString()
        }

        binding.setButton.setOnClickListener {
            binding.money.text = "￥" + 9999
            startActivity(setIntent)
            binding.money.text = "￥" + 4444
        }
    }
}