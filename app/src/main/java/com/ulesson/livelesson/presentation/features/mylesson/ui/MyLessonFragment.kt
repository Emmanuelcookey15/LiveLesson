package com.ulesson.livelesson.presentation.features.mylesson.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener
import com.ulesson.livelesson.R
import com.ulesson.livelesson.databinding.FragmentLiveLessonBinding
import com.ulesson.livelesson.databinding.FragmentMyLessonBinding
import com.ulesson.livelesson.presentation.adapter.LiveLessonAdapter
import com.ulesson.livelesson.presentation.adapter.MyLessonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyLessonFragment : Fragment() {

    private var _binding: FragmentMyLessonBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapterMyLesson = MyLessonAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyLessonBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {

        binding.recyclerView.apply {
            adapter = adapterMyLesson
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        binding.spinerMyLesson.setOnSpinnerItemSelectedListener(
            OnSpinnerItemSelectedListener<String> { _, _, _, _ ->

            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}