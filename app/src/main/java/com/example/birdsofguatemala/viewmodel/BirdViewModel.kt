package com.example.birdsofguatemala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.birdsofguatemala.data.model.BirdItem
import com.example.birdsofguatemala.data.repository.BirdRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BirdViewModel : ViewModel() {

    private val repo = BirdRepository()

    private val _birds = MutableStateFlow<List<BirdItem>>(emptyList())
    val birds: StateFlow<List<BirdItem>> get() = _birds

    init { fetchBirds() }

    fun fetchBirds() {
        viewModelScope.launch {
            _birds.value = repo.loadBirds()
        }
    }
}
