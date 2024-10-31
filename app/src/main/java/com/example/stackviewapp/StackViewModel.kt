package com.example.stackviewapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stackviewapp.network.ApiClient
import com.example.stackviewapp.network.StackItemResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class StackItemData(val id: Int, val title: String, var isExpanded: Boolean = false)

class StackViewModel : ViewModel() {
    private val _stackItems = MutableStateFlow<List<StackItemData>>(emptyList())
    val stackItems: StateFlow<List<StackItemData>> = _stackItems

    init {
        fetchStackItems()
    }

    private fun fetchStackItems() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getStackItems()
                _stackItems.value = response.map {
                    StackItemData(id = it.id, title = it.title)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onItemClicked(itemId: Int) {
        _stackItems.update { list ->
            list.map { item ->
                if (item.id == itemId) item.copy(isExpanded = !item.isExpanded) else item.copy(isExpanded = false)
            }
        }
    }
}
