package com.project.latitudetechnolabs

import android.app.Application
import com.project.latitudetechnolabs.data.network.MyApi
import com.project.latitudetechnolabs.data.network.NetworkConnectionInterceptor
import com.project.latitudetechnolabs.data.repositories.UserRepository
import com.project.latitudetechnolabs.ui.auth.AuthViewModelFactory
import com.project.latitudetechnolabs.data.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class LATITUDETECHNOLABSApplication : Application(), KodeinAware {


    override val kodein = Kodein.lazy {

        import(androidXModule(this@LATITUDETECHNOLABSApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance()) }
        bind() from singleton { AuthViewModelFactory(instance()) }

    }


}