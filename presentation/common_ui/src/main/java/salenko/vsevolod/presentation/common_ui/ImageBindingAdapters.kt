package salenko.vsevolod.presentation.common_ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("imageUrlOrInvisible")
fun bindImageUrl(imageView: ImageView, url: String?) {
    if (url != null) {
        imageView.visibility = View.VISIBLE
        Glide.with(imageView.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .optionalFitCenter()
            .into(imageView)
    } else {
        imageView.visibility = View.INVISIBLE
    }
}