package com.ulesson.livelesson.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ulesson.domain.models.Lesson
import com.ulesson.livelesson.databinding.ItemLiveLessonBinding

class LiveLessonAdapter(private val lessons: MutableList<Lesson>):
    RecyclerView.Adapter<LiveLessonAdapter.LiveLessonHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveLessonHolder {
        val view = ItemLiveLessonBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return LiveLessonHolder(view)
    }

    override fun onBindViewHolder(holder: LiveLessonHolder, position: Int) {
        holder.bind(lessons[position])
    }

    override fun getItemCount(): Int {
        return lessons.size
    }


    fun setLesson(lessonsList: List<Lesson>) {
        this.lessons.clear()
        this.lessons.addAll(lessonsList)
        notifyDataSetChanged()
    }


    inner class LiveLessonHolder(val view: ItemLiveLessonBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(lesson: Lesson) = with(view) {


            view.itemLlTutor.text = lesson.tutor
            view.itemLlTopic.text = lesson.topic
            view.itemLlStartAt.text = lesson.start_at
            view.itemLlSubject.text = lesson.subject
            Glide.with(view.root)
                .load(lesson.image_url)
                .into(view.imgItemLl)

        }
    }
}