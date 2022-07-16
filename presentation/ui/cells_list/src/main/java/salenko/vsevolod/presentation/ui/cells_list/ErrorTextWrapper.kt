package salenko.vsevolod.presentation.ui.cells_list

import android.content.Context

object ErrorTextWrapper {
    fun wrapError(context: Context, throwable: Throwable? = null): String? =
        throwable?.let {
            context.getString(R.string.error, throwable.stackTraceToString())
        }

}