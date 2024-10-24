package com.example.databinding

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.databinding.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val inputText = binding.textSearch.text.toString()
            viewModel.onButtonClick(inputText)
        }

        binding.textSearch.addTextChangedListener { text ->
            if (text != null) {
                viewModel.checkInput(text.length >= 3)
            }
        }
        observeButtonState()
        observeViewState()
    }

    private fun observeViewState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    setSearchStatus(state)
                }
            }
        }
    }

    private fun observeButtonState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.buttonState.collect { buttonState ->
                    binding.button.isEnabled = buttonState
                }
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun setSearchStatus(state: State) {
        when (state) {
            is State.Initial -> {

            }

            is State.Loading -> {
                with(binding) {
                    progressBar.visibility = View.VISIBLE
                }
            }

            is State.Success -> {
                with(binding) {
                    progressBar.visibility = View.INVISIBLE
                    binding.textResult.text = "По запросу \"${state.result}\" ничего не найдено"
                }
            }

            is State.Error -> {

            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}