package com.ab.vaccine.feature.splash.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ab.vaccine.R as ResApp
import com.ab.vaccine.core.delegate.viewBinding
import com.ab.vaccine.core.presentation.extensions.observe
import com.ab.vaccine.feature.splash.R
import com.ab.vaccine.feature.splash.databinding.FragmentSplashBinding
import com.ab.vaccine.feature.splash.di.SplashComponent
import com.ab.vaccine.feature.splash.di.SplashInjector
import javax.inject.Inject

class SplashFragment @Inject constructor() : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: SplashViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SplashInjector.initialize(
            applicationContext = requireActivity().application
        )
        SplashComponent.INSTANCE.inject(this)
    }

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]

        observe(mViewModel.stateLiveData, ::onStateChange)
        mViewModel.startTimeout()

        startAnimation()
    }

    private fun onStateChange(state: SplashViewModel.ViewState) {
        if (!state.waiting) {
            findNavController().navigate(ResApp.id.action_splashFragment_to_summaryActivity)
            activity?.finish()
        }
    }

    private fun startAnimation() {
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        alphaAnimation.duration = 1000
        alphaAnimation.fillAfter = true
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
            }

            override fun onAnimationStart(p0: Animation?) {
                binding.container.visibility = View.VISIBLE
            }
        })
        binding.container.startAnimation(alphaAnimation)
    }
}
