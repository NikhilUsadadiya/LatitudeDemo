package com.project.latitudetechnolabs.ui.offerlist

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.project.latitudetechnolabs.R
import com.project.latitudetechnolabs.data.AppDatabase
import com.project.latitudetechnolabs.ui.BaseNewActivity


class OfferListActivity : BaseNewActivity() {

    private var db: AppDatabase? = null
    private var screenMoved: Boolean?= false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offerlist)
        db = AppDatabase.invoke(this)


    }
}
