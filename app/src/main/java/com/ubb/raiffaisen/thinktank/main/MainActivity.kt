/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ubb.raiffaisen.thinktank.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        triggerSplashScreen()
        setContentView(R.layout.activity_main)

        setupUi()
        hideSystemUi()
    }

    /** Method used to hide system toolbar and nav buttons. */
    private fun hideSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    /** Method used to setup activity's fragment container view. */
    private fun setupUi() {
        navController =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()
        navController?.setGraph(R.navigation.navigation_graph)
    }

    /** Method used to display a splashscreen for 2 seconds.
     * Must be called before setContentView().
     **/
    private fun triggerSplashScreen() {
        Thread.sleep(SPLASH_SCREEN_DURATION)
        installSplashScreen()
    }

    private companion object {
        const val SPLASH_SCREEN_DURATION = 2000L
    }
}
