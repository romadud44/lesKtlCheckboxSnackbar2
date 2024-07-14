package com.example.lesktlcheckboxsnackbar2


import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    private lateinit var checkCB: CheckBox
    private lateinit var outTV: TextView
    private lateinit var infoPddTV: TextView
    private fun findId(){
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Правила дорожного движения"
        toolbarMain.subtitle = "версия 1.0"

        checkCB = findViewById(R.id.checkCB)
        outTV = findViewById(R.id.outTV)
        infoPddTV = findViewById(R.id.infoPddTV)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findId()

        checkCB.setOnClickListener{
            if(checkCB.isChecked){
                outTV.text = "Правила дорожного движения"
                infoPddTV.text = TrafficRules().rules
            } else{
                outTV.text = ""
                infoPddTV.text = ""
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


