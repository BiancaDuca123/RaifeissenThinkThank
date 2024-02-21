package com.ubb.raiffaisen.thinktank.test.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ubb.raiffaisen.thinktank.databinding.FragmentTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding

    private val viewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // am initializat bindingul
        // am facut legatua dintre fragmnetul meu si xml
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    private fun setupUi() = with(binding) {

        multiplication.setOnClickListener {
            result.text = viewModel.multiplication(
                number1.text.toString().toIntOrNull() ?: 0,
                number2.text.toString().toIntOrNull() ?: 0
            ).toString()
        }

        sum.setOnClickListener {
            result.text = viewModel.sum(
                number1.text.toString().toIntOrNull() ?: 0,
                number2.text.toString().toIntOrNull() ?: 0
            ).toString()
        }
    }
}