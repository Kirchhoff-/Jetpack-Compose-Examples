package com.kirchhoff.composeexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kirchhoff.composeexamples.bottomsheet.modal.BottomSheetModalActivity
import com.kirchhoff.composeexamples.bottomsheet.scaffold.BottomSheetScaffoldActivity
import com.kirchhoff.composeexamples.customshape.CustomShapeActivity
import com.kirchhoff.composeexamples.navigationdrawer.NavigationDrawerActivity
import com.kirchhoff.composeexamples.undesnackbar.UndoSnackbarActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bHelloAndroid).setOnClickListener { startActivity(Intent(this, HelloAndroidActivity::class.java)) }
        findViewById<Button>(R.id.bSimpleLayout).setOnClickListener { startActivity(Intent(this, SimpleLayoutActivity::class.java)) }
        findViewById<Button>(R.id.bSimpleCard).setOnClickListener { startActivity(Intent(this, SimpleCardActivity::class.java)) }
        findViewById<Button>(R.id.bDrawerExample).setOnClickListener { startActivity(Intent(this, NavigationDrawerActivity::class.java)) }
        findViewById<Button>(R.id.bCustomShapeExample).setOnClickListener { startActivity(Intent(this, CustomShapeActivity::class.java)) }
        findViewById<Button>(R.id.bUndoSnackbarExample).setOnClickListener { startActivity(Intent(this, UndoSnackbarActivity::class.java)) }
        findViewById<Button>(R.id.bBottomSheetScaffold).setOnClickListener { startActivity(Intent(this, BottomSheetScaffoldActivity::class.java)) }
        findViewById<Button>(R.id.bBottomSheetModal).setOnClickListener { startActivity(Intent(this, BottomSheetModalActivity::class.java)) }
    }
}