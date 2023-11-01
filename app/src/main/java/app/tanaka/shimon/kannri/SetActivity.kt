package app.tanaka.shimon.kannri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.tanaka.shimon.kannri.databinding.ActivitySetBinding

class SetActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBinding.inflate(layoutInflater).apply { setContentView(this.root) }
    }
}