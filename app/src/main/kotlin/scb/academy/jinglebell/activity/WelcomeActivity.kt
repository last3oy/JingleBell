package scb.academy.jinglebell.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import scb.academy.jinglebell.R

class WelcomeActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_NICKNAME = "nickname"

        fun startActivity(context: Context, nickname: String) = context.startActivity(
                Intent(context, WelcomeActivity::class.java).apply {
                    putExtra(EXTRA_NICKNAME, nickname)
                })
    }

    private lateinit var tvNickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        tvNickname = findViewById(R.id.tv_nickname)

        val nickName = intent.getStringExtra(EXTRA_NICKNAME) ?: return
        tvNickname.text = nickName
    }
}