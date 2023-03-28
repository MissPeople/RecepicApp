package com.wzp.recepicapp.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.wzp.recepicapp.R
import com.wzp.recepicapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val viewModel by activityViewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            val name = binding.name.text.trim().toString()
            val password = binding.password.text.trim().toString()
            viewModel.checkLogin(name, password)
        }
        binding.regist.setOnClickListener {
            findNavController().navigate(R.id.nav_login_to_regist)
        }
        view.findViewById<TextView>(R.id.login).setOnClickListener {
            findNavController().navigate(R.id.nav_login_to_home)
        }
    }



}