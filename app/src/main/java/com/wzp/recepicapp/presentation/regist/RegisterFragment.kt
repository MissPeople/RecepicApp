package com.wzp.recepicapp.presentation.regist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wzp.recepicapp.R
import com.wzp.recepicapp.databinding.FragmentRegistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val binding by lazy { FragmentRegistBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<RegisterViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect{
                when (it) {
                    is RegisterContract.Effect.PopBackStack -> {
                        findNavController().navigate(R.id.nav_regist_to_login)
                    }
                    is RegisterContract.Effect.ShowError -> {

                    }
                }
            }
        }
        binding.regist.setOnClickListener {
            val name = binding.name.text.trim().toString()
            val password = binding.password.text.trim().toString()
            viewModel.notifyEvent(RegisterContract.Event.Register(name, password))
        }
    }


}