package com.ulesson.livelesson.presentation.features.livelesson.ui

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener
import com.ulesson.domain.models.Lesson
import com.ulesson.domain.models.Resource
import com.ulesson.livelesson.R
import com.ulesson.livelesson.databinding.FragmentLiveLessonBinding
import com.ulesson.livelesson.presentation.adapter.LiveLessonAdapter
import com.ulesson.livelesson.presentation.adapter.PromoteLessonPagerAdapter
import com.ulesson.livelesson.presentation.features.livelesson.viewmodel.LiveLessonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveLessonFragment : Fragment() {

    private var _binding: FragmentLiveLessonBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: LiveLessonViewModel by viewModels()


    private val adapterLiveLesson = LiveLessonAdapter(mutableListOf())
    private val adapterPromoteLesson = PromoteLessonPagerAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLiveLessonBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        InitializeViews()
        viewModel.loadLiveLessons()


        binding.fabMyLesson.setOnClickListener {
            view.findNavController().navigate(R.id.action_liveLessonFragment_to_myLessonFragment)
        }


    }

    private fun InitializeViews() {
        binding.liveLessonRv.apply {
            adapter = adapterLiveLesson
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        binding.pager.adapter = adapterPromoteLesson
        binding.tabLayout.setupWithViewPager(binding.pager, true)

        binding.spinerLiveLesson.setOnSpinnerItemSelectedListener(
            OnSpinnerItemSelectedListener<String> { _, _, _, _ ->

            })

        binding.swipeRefreshLayout.setOnRefreshListener {
            refresh()
        }
    }


    fun refresh(){
        viewModel.refreshLive.observe(viewLifecycleOwner, Observer {
            if (it){
                setUpObservers()
            }
        })
    }


    private fun setUpObservers(){
        viewModel.listLiveLesson.observe(viewLifecycleOwner, Observer {
            when(it.data){
                null ->{
                    binding.liveLessonRv.visibility = View.GONE
                    binding.imgViewError.visibility = View.VISIBLE
                    viewModel.noNetworkConnectivity()
                }
                else ->{
                    binding.liveLessonRv.visibility = View.VISIBLE
                    binding.imgViewError.visibility = View.GONE
                    it.data?.let { it1 -> adapterLiveLesson.setLesson(it1) }
                }
            }

        })


        viewModel.listPromotedLesson.observe(viewLifecycleOwner, Observer {

            when(it.data){
                null ->{
                    viewModel.noNetworkConnectivityForPromoted()
                }
                else ->{
                    it.data?.let { it1 -> adapterPromoteLesson.setLesson(it1) }
                }
            }
            if (it != null){
                it.data?.let { it1 -> adapterPromoteLesson.setLesson(it1) }
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}