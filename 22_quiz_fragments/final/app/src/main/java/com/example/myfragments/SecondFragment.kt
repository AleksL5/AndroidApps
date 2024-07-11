package com.example.myfragments

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.myfragments.databinding.FragmentSecondBinding
import com.example.quiz.quiz.Question
import com.example.quiz.quiz.QuizStorage
import com.example.quiz.quiz.QuizStorage.Locale
    const val ARGS = "ARGS"

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        text(Locale.Ru)
        binding.switch1.setOnClickListener {
            if (!binding.switch1.isChecked)
                text(Locale.Ru)
            else text(Locale.En)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSend.setOnClickListener {
            val bundle = bundleOf(ARGS to readyTest())
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment, bundle)


        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun text(locale: Locale) {
        binding.firstQuestion.text = QuizStorage.getQuiz(locale).questions.get(0).question
        binding.firstGroupFirst.text = QuizStorage.getQuiz(locale).questions.get(0).answers.get(0)
        binding.firstGroupSecond.text = QuizStorage.getQuiz(locale).questions.get(0).answers.get(1)
        binding.firstGroupThird.text = QuizStorage.getQuiz(locale).questions.get(0).answers.get(2)
        binding.firstGroupFourth.text = QuizStorage.getQuiz(locale).questions.get(0).answers.get(3)

        binding.secondQuestion.text = QuizStorage.getQuiz(locale).questions.get(1).question
        binding.secondGroupFirst.text = QuizStorage.getQuiz(locale).questions.get(1).answers.get(0)
        binding.secondGroupSecond.text = QuizStorage.getQuiz(locale).questions.get(1).answers.get(1)
        binding.secondGroupThird.text = QuizStorage.getQuiz(locale).questions.get(1).answers.get(2)
        binding.secondGroupFourth.text = QuizStorage.getQuiz(locale).questions.get(1).answers.get(3)

        binding.thirdQuestion.text = QuizStorage.getQuiz(locale).questions.get(2).question
        binding.thirdGroupFirst.text = QuizStorage.getQuiz(locale).questions.get(2).answers.get(0)
        binding.thirdGroupSecond.text = QuizStorage.getQuiz(locale).questions.get(2).answers.get(1)
        binding.thirdGroupThird.text = QuizStorage.getQuiz(locale).questions.get(2).answers.get(2)
        binding.thirdGroupFourth.text = QuizStorage.getQuiz(locale).questions.get(2).answers.get(3)
    }

    private fun readyTest(): String {
        var readyTest = ""
        readyTest += when {
            binding.firstGroupFirst.isChecked -> 0
            binding.firstGroupSecond.isChecked -> 1
            binding.firstGroupThird.isChecked -> 2
            binding.firstGroupFourth.isChecked -> 3
            else -> " "
        }
        readyTest += when {
            binding.secondGroupFirst.isChecked -> 0
            binding.secondGroupSecond.isChecked -> 1
            binding.secondGroupThird.isChecked -> 2
            binding.secondGroupFourth.isChecked -> 3
            else -> " "
        }
        readyTest += when {
            binding.thirdGroupFirst.isChecked -> 0
            binding.thirdGroupSecond.isChecked -> 1
            binding.thirdGroupThird.isChecked -> 2
            binding.thirdGroupFourth.isChecked -> 3
            else -> " "
        }
        return readyTest
    }
}