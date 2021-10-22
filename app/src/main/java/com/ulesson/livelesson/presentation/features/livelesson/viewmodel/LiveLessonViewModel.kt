package com.ulesson.livelesson.presentation.features.livelesson.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulesson.data.repo.Repository
import com.ulesson.domain.models.Lesson
import com.ulesson.domain.models.Resource
import com.ulesson.livelesson.presentation.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class LiveLessonViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val repository: Repository
) : ViewModel() {


    private val _listPromotedLesson = MutableLiveData<Resource<List<Lesson>>>()
    private val _listLiveLesson = MutableLiveData<Resource<List<Lesson>>>()
    private val _refreshLive = MutableLiveData<Boolean>()
    private var _showRecyclerView = MutableLiveData(true)


    var listPromotedLesson: LiveData<Resource<List<Lesson>>> = _listPromotedLesson
    var listLiveLesson: LiveData<Resource<List<Lesson>>> = _listLiveLesson
    var refreshLive: LiveData<Boolean> = _refreshLive
    var showRecyclerView :LiveData<Boolean> = _showRecyclerView



    fun loadLiveLessons(){
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                _listLiveLesson.postValue(Resource.Loading(null))

                try {
                    repository.getLessonsData().getLiveLessons.let {
                        _listLiveLesson.postValue(
                            Resource.Success(it)
                                    as Resource<List<Lesson>>
                        )
                    }
                    _refreshLive.value = false
                } catch (exception: Exception) {
                    if (exception is IOException)
                        _listLiveLesson.postValue(
                            Resource.Error(exception)
                        )
                    Log.i("HSVM", "getCampaign exception $exception")
                }
            }
        } else {
            noNetworkConnectivity()
        }
    }

    fun noNetworkConnectivity() {
        _refreshLive.value = true
        _showRecyclerView.value = false
    }



    fun loadPromotedLessons(){
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                _listPromotedLesson.postValue(Resource.Loading(null))
                try {
                    repository.getLessonsData().getPromotedLessons.let {
                        _listPromotedLesson.postValue(
                            Resource.Success(it)
                                    as Resource<List<Lesson>>
                        )
                    }
                } catch (exception: Exception) {
                    if (exception is IOException)
                        _listPromotedLesson.postValue(
                            Resource.Error(exception)
                        )
                    Log.i("HSVM", "getCampaign exception $exception")
                }
            }
        } else {
            noNetworkConnectivityForPromoted()
        }
    }

    fun noNetworkConnectivityForPromoted() {
        _refreshLive.value = true
    }


}