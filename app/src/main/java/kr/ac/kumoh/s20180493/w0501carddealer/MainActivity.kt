package kr.ac.kumoh.s20180493.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20180493.w0501carddealer.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnDeal.setOnClickListener {
            val res = IntArray(5)
            for (i in 0 until res.size) {
                res[i] = resources.getIdentifier(
                    getCardName(Random.nextInt(52)),
                    "drawable",
                    packageName
                )
                binding.card1.setImageResource(res[0])
                binding.card2.setImageResource(res[1])
                binding.card3.setImageResource(res[2])
                binding.card4.setImageResource(res[3])
                binding.card5.setImageResource(res[4])
            }
        }
    }

    private fun getCardName(c: Int): String {
        Log.i("getCardName():", c.toString())
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }
        val number = when (c % 13) {
            0 -> "ace"
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            in 1..9 -> (c % 13 + 1).toString()
            else -> "error"
        }
        Log.i("getCardName():", shape.toString())
        Log.i("getCardName():", number.toString())
        //return "c_ace_of_spades.png"
        return "c_${number}_of_${shape}"
    }
}