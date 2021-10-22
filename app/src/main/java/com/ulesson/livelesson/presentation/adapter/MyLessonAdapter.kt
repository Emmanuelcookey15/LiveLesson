package com.ulesson.livelesson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ulesson.data.db.LessonEntity
import com.ulesson.livelesson.databinding.ItemMyLessonBinding

class MyLessonAdapter (private val lesson: MutableList<LessonEntity>):
    RecyclerView.Adapter<MyLessonAdapter.MyLessonHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLessonHolder {
        val view = ItemMyLessonBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyLessonHolder(view)
    }


    override fun onBindViewHolder(holder: MyLessonHolder, position: Int) {
        holder.bind(lesson[position])
    }

    override fun getItemCount(): Int {
        return lesson.size
    }


    fun setLessonEntities(lessonsList: List<LessonEntity>) {
        this.lesson.clear()
        this.lesson.addAll(lessonsList)
        notifyDataSetChanged()
    }


    inner class MyLessonHolder(val view: ItemMyLessonBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(lessonEntity: LessonEntity) = with(view) {


            view.itemMlSubject.text = lessonEntity.subject
            view.itemMlTopic.text = lessonEntity.topic
            view.itemMlStartedAt.text = lessonEntity.start_at
            Glide.with(view.root)
                .load(lessonEntity.image_url)
                .into(view.imgItemMl)

        }
    }


}