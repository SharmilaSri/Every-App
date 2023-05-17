package com.eclipse.everynote.ui.Reminder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eclipse.everynote.databinding.FragmentRemindersBinding

class ReminderFragment : Fragment() {

    private var _binding: FragmentRemindersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reminderViewModel =
            ViewModelProvider(this).get(ReminderViewModel::class.java)

        _binding = FragmentRemindersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textReminders
        reminderViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}