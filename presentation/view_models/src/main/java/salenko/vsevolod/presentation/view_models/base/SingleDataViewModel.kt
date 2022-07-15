package salenko.vsevolod.presentation.view_models.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class SingleDataViewModel<T> : ViewModel() {

    private var refreshingJob: Job? = null

    protected val mutableState =
        MutableStateFlow<SingleDataViewModelState<T>>(SingleDataViewModelState.Empty())

    protected open val isEmptyResultSupported = false

    val state: StateFlow<SingleDataViewModelState<T>> = mutableState

    fun refresh() {
        mutableState.value = SingleDataViewModelState.Loading()
        refreshingJob = viewModelScope.launch(Dispatchers.IO) {
            val result = suspendingRefresh()
            mutableState.value = result.toSingleDataViewModelState(isEmptyResultSupported)
        }
    }

    fun refreshIfRequired() {
        if (state.value !is SingleDataViewModelState.Data) {
            refresh()
        }
    }

    override fun onCleared() {
        super.onCleared()
        refreshingJob?.cancel()
        refreshingJob = null
        mutableState.value = SingleDataViewModelState.Empty()
    }

    protected abstract suspend fun suspendingRefresh(): Result<T>
}