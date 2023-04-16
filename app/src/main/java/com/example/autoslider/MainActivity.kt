package com.example.autoslider

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.autoslider.databinding.ActivityMainBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SliderAdapter(this)
        binding.imageSlider.setSliderAdapter(this.adapter)

        val list: ArrayList<SliderItem> = ArrayList()
        list.add(SliderItem("http://techslides.com/demos/sample-videos/small.mp4", "video"))
        list.add(SliderItem("https://cdn.pixabay.com/photo/2014/02/27/16/10/flowers-276014__480.jpg", "image"))
        list.add(SliderItem("https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823__480.jpg", "image"))
        list.add(SliderItem("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg", "image"))
        list.add(SliderItem("https://cdn.pixabay.com/photo/2014/04/14/20/11/pink-324175__480.jpg", "image"))
        list.add(SliderItem("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "video"))

        adapter.updateAllSlides(list)

        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.startAutoCycle();

    }
}