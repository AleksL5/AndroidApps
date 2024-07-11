package com.example.myfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myfragments.databinding.FragmentSecondBinding
import com.example.myfragments.databinding.FragmentThirdBinding
import com.example.quiz.quiz.Question
import com.example.quiz.quiz.QuizStorage
import com.example.quiz.quiz.QuizStorage.Locale

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val list = arguments?.getString(ARGS)
        result(Locale.Ru, "$list")
        binding.switch2.setOnClickListener {
            if (!binding.switch2.isChecked)
                result(Locale.Ru, "$list")
            else result(Locale.En, "$list")
        }
        binding.restartButton.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun result(locale: Locale, list: String?) {
        binding.firstAnswer.text = when (list?.get(0)) {
            '0' -> QuizStorage.getQuiz(locale).questions.get(0).feedback[0]
            '1' -> QuizStorage.getQuiz(locale).questions.get(0).feedback[1]
            '2' -> QuizStorage.getQuiz(locale).questions.get(0).feedback[2]
            '3' -> QuizStorage.getQuiz(locale).questions.get(0).feedback[3]
            else -> ""
        }
        binding.secondAnswer.text = when (list?.get(1)) {
            '0' -> QuizStorage.getQuiz(locale).questions.get(1).feedback[0]
            '1' -> QuizStorage.getQuiz(locale).questions.get(1).feedback[1]
            '2' -> QuizStorage.getQuiz(locale).questions.get(1).feedback[2]
            '3' -> QuizStorage.getQuiz(locale).questions.get(1).feedback[3]
            else -> ""
        }
        binding.thirdAnswer.text = when (list?.get(2)) {
            '0' -> QuizStorage.getQuiz(locale).questions.get(2).feedback[0]
            '1' -> QuizStorage.getQuiz(locale).questions.get(2).feedback[1]
            '2' -> QuizStorage.getQuiz(locale).questions.get(2).feedback[2]
            '3' -> QuizStorage.getQuiz(locale).questions.get(2).feedback[3]
            else -> ""
        }
        if (list == "   "){
            binding.firstAnswer.text = if (locale == Locale.Ru)
                "Вы не выбрали ответы" else "Please check answers"
        }

    }
}
