package com.kirchhoff.composeexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kirchhoff.composeexamples.navigationdrawer.NavigationDrawerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bHelloAndroid).setOnClickListener { startActivity(Intent(this, HelloAndroidActivity::class.java)) }
        findViewById<Button>(R.id.bSimpleLayout).setOnClickListener { startActivity(Intent(this, SimpleLayoutActivity::class.java)) }
        findViewById<Button>(R.id.bSimpleCard).setOnClickListener { startActivity(Intent(this, SimpleCardActivity::class.java)) }
        findViewById<Button>(R.id.bDrawerExample).setOnClickListener { startActivity(Intent(this, NavigationDrawerActivity::class.java)) }
    }
}