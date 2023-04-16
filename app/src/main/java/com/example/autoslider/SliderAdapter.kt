package com.example.autoslider

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(private val context: Context) : SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    private val allSliderItems : ArrayList<SliderItem> = ArrayList()

    inner class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView){
        val slideImage: ImageView = itemView.findViewById(R.id.slideImage)
        val slideVideo : VideoView = itemView.findViewById(R.id.slideVideo)
    }

    override fun getCount(): Int {
        return allSliderItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        return SliderViewHolder(LayoutInflater.from(context).inflate(R.layout.slider_viewholder, parent, false))
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        val currentSlide = allSliderItems[position]

        if (currentSlide.type == "image"){
            viewHolder?.slideVideo?.visibility = View.GONE

            viewHolder?.slideImage?.let {
                it.visibility =View.VISIBLE
                Glide.with(context).load(currentSlide.imageUrl).into(it)
            }
        }else{
            viewHolder?.slideImage?.visibility = View.GONE
            viewHolder?.slideVideo?.let {
                it.visibility = View.VISIBLE

                val uri: Uri = Uri.parse(currentSlide.imageUrl)
                it.setVideoURI(uri)
//                val mediaController = MediaController(context)
//                mediaController.setAnchorView(it)
//                mediaController.setMediaPlayer(it)
//                it.setMediaController(mediaController)
                it.start()
            }
        }

    }

    fun updateAllSlides(list : List<SliderItem>){
        allSliderItems.clear()
        allSliderItems.addAll(list)
        this.notifyDataSetChanged()
    }
}