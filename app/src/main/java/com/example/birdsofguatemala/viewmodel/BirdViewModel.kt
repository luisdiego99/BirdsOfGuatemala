package com.example.birdsofguatemala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.birdsofguatemala.model.BirdItem
import com.example.birdsofguatemala.repository.BirdRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BirdViewModel : ViewModel() {

    private val repository = BirdRepository()

    private val _birds = MutableStateFlow<List<BirdItem>>(emptyList())
    val birds: StateFlow<List<BirdItem>> = _birds

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    init { loadBirds() }

    fun loadBirds() {
        viewModelScope.launch {
            _loading.value = true
            val data = repository.fetchBirds()
            _birds.value = data
            _loading.value = false
        }
    }
}
