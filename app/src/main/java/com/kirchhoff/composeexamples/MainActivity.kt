package com.kirchhoff.composeexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.compose.foundation.ExperimentalFoundationApi
import com.kirchhoff.composeexamples.animateborders.AnimateBordersActivity
import com.kirchhoff.composeexamples.animatedvisibility.AnimatedVisibilityActivity
import com.kirchhoff.composeexamples.animation.AnimationActivity
import com.kirchhoff.composeexamples.bottomnavigation.BottomNavigationBarActivity
import com.kirchhoff.composeexamples.bottomsheet.modal.BottomSheetModalActivity
import com.kirchhoff.composeexamples.bottomsheet.scaffold.BottomSheetScaffoldActivity
import com.kirchhoff.composeexamples.boxwithconstraints.BoxWithConstraintsActivity
import com.kirchhoff.composeexamples.circularreveal.CircularRevealAnimationActivity
import com.kirchhoff.composeexamples.clock.ClockActivity
import com.kirchhoff.composeexamples.counterbadge.CounterBadgeActivity
import com.kirchhoff.composeexamples.customshape.CustomShapeActivity
import com.kirchhoff.composeexamples.emoji.EmojiListActivity
import com.kirchhoff.composeexamples.expandablelist.ExpandableListActivity
import com.kirchhoff.composeexamples.expandabletextview.ExpandableTextViewActivity
import com.kirchhoff.composeexamples.navigationdrawer.NavigationDrawerActivity
import com.kirchhoff.composeexamples.otptextfield.OtpTextFieldActivity
import com.kirchhoff.composeexamples.searchinlist.SearchInListActivity
import com.kirchhoff.composeexamples.tabs.TabsExampleActivity
import com.kirchhoff.composeexamples.texttransformation.TextTransformationActivity
import com.kirchhoff.composeexamples.touchfeedback.TouchFeedbackAnimationActivity
import com.kirchhoff.composeexamples.undesnackbar.UndoSnackbarActivity
import com.kirchhoff.composeexamples.viewmodel.BaseViewModelExampleActivity

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalFoundationApi::class)
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
        findViewById<Button>(R.id.bTabsExample).setOnClickListener { startActivity(Intent(this, TabsExampleActivity::class.java)) }
        findViewById<Button>(R.id.bBaseViewModelExample).setOnClickListener { startActivity(Intent(this, BaseViewModelExampleActivity::class.java)) }
        findViewById<Button>(R.id.bBottomNavigationBarExample).setOnClickListener { startActivity(Intent(this, BottomNavigationBarActivity::class.java)) }
        findViewById<Button>(R.id.bClockExample).setOnClickListener { startActivity(Intent(this, ClockActivity::class.java)) }
        findViewById<Button>(R.id.bCounterBadgeExample).setOnClickListener { startActivity(Intent(this, CounterBadgeActivity::class.java)) }
        findViewById<Button>(R.id.bTextTransformationExample).setOnClickListener { startActivity(Intent(this, TextTransformationActivity::class.java)) }
        findViewById<Button>(R.id.bSearchInListExample).setOnClickListener { startActivity(Intent(this, SearchInListActivity::class.java)) }
        findViewById<Button>(R.id.bEmojiListExample).setOnClickListener { startActivity(Intent(this, EmojiListActivity::class.java)) }
        findViewById<Button>(R.id.bAnimationExample).setOnClickListener { startActivity(Intent(this, AnimationActivity::class.java)) }
        findViewById<Button>(R.id.bAnimatedVisibilityExample).setOnClickListener { startActivity(Intent(this, AnimatedVisibilityActivity::class.java)) }
        findViewById<Button>(R.id.bBoxWithConstraints).setOnClickListener { startActivity(Intent(this, BoxWithConstraintsActivity::class.java)) }
        findViewById<Button>(R.id.bExpandableListExample).setOnClickListener { startActivity(Intent(this, ExpandableListActivity::class.java)) }
        findViewById<Button>(R.id.bOtpTextFieldExample).setOnClickListener { startActivity(Intent(this, OtpTextFieldActivity::class.java)) }
        findViewById<Button>(R.id.bExpandableTextView).setOnClickListener { startActivity(Intent(this, ExpandableTextViewActivity::class.java)) }
        findViewById<Button>(R.id.bTouchFeedbackAnimation).setOnClickListener { startActivity(Intent(this, TouchFeedbackAnimationActivity::class.java)) }
        findViewById<Button>(R.id.bCircularRevealAnimation).setOnClickListener { startActivity(Intent(this, CircularRevealAnimationActivity::class.java)) }
        findViewById<Button>(R.id.bAnimateBorders).setOnClickListener { startActivity(Intent(this, AnimateBordersActivity::class.java)) }
    }
}