package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher


class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        binding.button.setOnClickListener{otvet()}
        var rexrIn: String = "D"
        val slots = UnderscoreDigitSlotsParser().parseSlots("__")
        val formatWatcher: FormatWatcher = MaskFormatWatcher( // форматировать текст будет вот он
            MaskImpl.createTerminated(slots)
        )
        formatWatcher.installOn(binding.editTextTextPersonName2)
        formatWatcher.installOn(binding.editTextTextPersonName3)
        formatWatcher.installOn(binding.editTextTextPersonName4)
      setSupportActionBar(binding.toolbar2)

        binding.button2.setOnClickListener{
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("konsi", "What is you name?")
            startActivity(i)
        }

    }
fun sum(text_4: String, text_5: String, text_6: String) {
    val sumText =text_4 +text_5 + text_6
    binding.textView.text = sumText
}
     fun otvet() {
         val text_1: String = binding.editTextTime.text.toString()
        val text_2: String = binding.editTextTextPassword.text.toString()
        val text_3: String = binding.editTextDate.text.toString()
     return sum(text_1, text_2, text_3)
    }
}