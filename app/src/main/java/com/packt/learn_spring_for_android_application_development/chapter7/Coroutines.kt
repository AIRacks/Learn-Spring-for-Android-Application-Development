package com.packt.learn_spring_for_android_application_development.chapter7

import android.os.Bundle
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

class Image

fun loadImage() : Image {
    Thread.sleep(3000)
    return Image()
}

fun main(args: Array<String>) = runBlocking {
    val subTask1 = GlobalScope.async { loadImage() }
    val subTask2 = GlobalScope.async { loadImage() }
    val subTask3 = GlobalScope.async { loadImage() }

    showImages(subTask1.await(), subTask2.await(), subTask3.await())
}

fun showImages(image1: Image, image2: Image, image3: Image) {
    // .......
}

//class Component: CoroutineScope {
//    lateinit var job: Job
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        job = Job()
//    }
//
//    fun loadProfile() = launch {
//        val image = async(Dispatchers.IO) { loadImage() }.await()
//        showImage(image)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        job.cancel()
//    }
//}
