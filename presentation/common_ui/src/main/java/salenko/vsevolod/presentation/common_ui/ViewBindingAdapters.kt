package salenko.vsevolod.presentation.common_ui

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("textOrInvisible")
fun bindTextOrInvisible(textView: TextView, text: String?) {
    textView.visibility =
        if (text != null) {
            textView.text = text
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
}

@BindingAdapter("textOrGone")
fun bindTextOrGone(textView: TextView, text: String?) {
    textView.visibility =
        if (text != null) {
            textView.text = text
            View.VISIBLE
        } else {
            View.GONE
        }
}

@BindingAdapter("visibleOrInvisible")
fun bindVisibleOrInvisible(view: View, flag: Boolean) {
    view.visibility =
        if (flag) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
}

@BindingAdapter("visibleOrGone")
fun bindVisibleOrGone(view: View, flag: Boolean) {
    view.visibility =
        if (flag) {
            View.VISIBLE
        } else {
            View.GONE
        }
}

@BindingAdapter("fabVisible")
fun bindFabVisibility(fab: FloatingActionButton, flag: Boolean) {
    if (flag) {
        fab.show()
    } else {
        fab.hide()
    }
}

@BindingAdapter("setSelected")
fun bindSelected(view: View, selected: Boolean) {
    view.isSelected = selected
}