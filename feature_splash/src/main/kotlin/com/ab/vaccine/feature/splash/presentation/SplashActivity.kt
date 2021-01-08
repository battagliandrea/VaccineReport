package com.ab.vaccine.feature.splash.presentation

import android.os.Bundle
import androidx.navigation.findNavController
import com.ab.vaccine.R as ResApp
import com.ab.vaccine.core.presentation.BaseActivity
import com.ab.vaccine.feature.splash.R
import com.ab.vaccine.presentation.extensions.setupNavHost
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private val navGraph: Int = ResApp.navigation.feature_splash_nav_graph

    override val layoutResId: Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavHost(navGraph, navHostFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp()
    }
}
