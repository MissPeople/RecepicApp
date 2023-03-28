package com.wzp.recepicapp.presentation.splash

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.animation.addListener
import androidx.core.animation.doOnEnd
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.wzp.recepicapp.R
import com.wzp.recepicapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {
    val animation = ValueAnimator.ofInt(0,1000)
    private val binding by lazy { FragmentSplashBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animation.apply {
            duration = 3000
            addUpdateListener {
                binding.progressBar.progress = it.animatedValue as Int
            }
            doOnEnd { findNavController().navigate(R.id.nav_splash_to_login) }
            start()
        }
    }


}