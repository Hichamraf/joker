package com.example.joker.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.joker.R


@BindingAdapter("visibleGone")
fun setVisibleGone(view : View, isVisible : Boolean){
    view.visibility=if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageSrc")
fun loadImage(imageView: ImageView, url : String?){
    url?.let {
        val ro=RequestOptions
            .placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        Glide.with(imageView.context)
            .setDefaultRequestOptions(ro)
            .load(url).into(imageView)
    }
}