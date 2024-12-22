package com.krishna.ktor_android.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishna.ktor_android.data.model.SearchResults
import com.krishna.ktor_android.domain.SEARCH_MOVIES
import com.krishna.ktor_android.domain.network.client
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _searchResults = MutableLiveData<SearchResults>()
    var searchResults: LiveData<SearchResults> = _searchResults

    fun getSearchMoviesResult() {
        viewModelScope.launch {
            getSearchResult()
        }
    }

    private suspend fun getSearchResult() {
        val response = client.get(SEARCH_MOVIES)
        _searchResults.postValue(response.body<SearchResults>())
    }
}