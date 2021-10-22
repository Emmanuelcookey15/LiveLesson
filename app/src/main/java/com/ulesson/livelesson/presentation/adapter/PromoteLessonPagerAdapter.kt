package com.ulesson.livelesson.presentation.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.ulesson.domain.models.Lesson
import com.ulesson.livelesson.R
import com.ulesson.livelesson.databinding.ItemLiveLessonBinding
import com.ulesson.livelesson.databinding.ItemPromotedLessonBinding

class PromoteLessonPagerAdapter( private val list: MutableList<Lesson>) : PagerAdapter() {

    fun setLesson(lessonsList: List<Lesson>) {
        this.list.clear()
        this.list.addAll(lessonsList)
        notifyDataSetChanged()
    }


    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemView = ItemPromotedLessonBinding.inflate(LayoutInflater.from(container.context), container, false)

//        val circularProgressDrawable = CircularProgressDrawable(ctx)
//        circularProgressDrawable.strokeWidth = 5f
//        circularProgressDrawable.centerRadius = 30f
//        circularProgressDrawable.start()

        itemView.itemPlTutor.text = list[position].tutor
        itemView.itemPlTopic.text = list[position].topic
        itemView.itemPlStartAt.text = list[position].start_at

        Glide.with(itemView.root)
            .asBitmap()
            .load(list[position].image_url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(object : CustomTarget<Bitmap?>() {

                override fun onLoadCleared(placeholder: Drawable?) {}
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?
                ) {
                    val bitmapDrawable = BitmapDrawable(container.context.resources, resource)
                    itemView.itemPlCardView.background = bitmapDrawable
                }
            })

        container.addView(itemView.root)
        return itemView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as CardView)
    }


}

