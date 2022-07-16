package salenko.vsevolod.presentation.view_models.base

sealed interface SingleDataViewModelState<T> {
    class Empty<T> : SingleDataViewModelState<T>
    class Loading<T> : SingleDataViewModelState<T>
    class Error<T>(val error: Throwable?) : SingleDataViewModelState<T>
    class Data<T>(val data: T) : SingleDataViewModelState<T>

    fun isLoading() =
        this is Loading

    fun isError() =
        this is Error

    fun getErrorOrNull() =
        if (this is Error) {
            error
        } else null

    fun getErrorTextOrNull() =
        getErrorOrNull()?.stackTraceToString()

    fun getDataOrNull() =
        if (this is Data) {
            data
        } else null

    fun hasData() =
        this is Data
}

fun <T> Result<T>.toSingleDataViewModelState(supportEmptyResult: Boolean = false): SingleDataViewModelState<T> =
    when {
        isSuccess -> {
            val data = getOrNull()
            when {
                data != null -> SingleDataViewModelState.Data(data)
                supportEmptyResult -> SingleDataViewModelState.Empty()
                else -> throw IllegalStateException("success result with no data")
            }
        }

        isFailure ->
            SingleDataViewModelState.Error(exceptionOrNull())

        else -> throw IllegalStateException("not success and not failure result")
    }