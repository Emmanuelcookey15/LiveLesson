package com.ulesson.livelesson.presentation.features.mylesson.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulesson.data.repo.Repository
import com.ulesson.domain.models.Resource
import com.ulesson.livelesson.presentation.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyLessonViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val repository: Repository
) : ViewModel() {



}