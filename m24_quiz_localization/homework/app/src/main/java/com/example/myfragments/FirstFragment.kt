package com.example.myfragments

import android.app.ActivityOptions
import android.icu.util.Calendar
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.transition.Explode
import androidx.transition.Slide
import com.example.myfragments.databinding.FragmentFirstBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd-MM-yy")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        enterTransition = Explode()
        exitTransition = Explode()

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.dateButton.setOnClickListener {
            val constraints = CalendarConstraints.Builder()
                .setOpenAt(calendar.timeInMillis)
                .build()
            activity?.let { it1 ->
                    val dateDialog =  MaterialDatePicker.Builder.datePicker()
                    .setCalendarConstraints(constraints)
                    .build()
                    dateDialog.addOnPositiveButtonClickListener { timeInMillis ->
                        calendar.timeInMillis = timeInMillis

                        Snackbar.make(binding!!.dateButton,dateFormat.format(calendar.time), Snackbar.LENGTH_LONG).show()
                    }


                    dateDialog.show(it1.supportFragmentManager,"Date Picker")
                }
            }

        binding.buttonContinue.setOnClickListener {

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
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

}