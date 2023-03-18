package com.zak.rickandmorty

import android.app.Application
import com.zak.rickandmorty.di.apiModule
import com.zak.rickandmorty.di.repositoryModule
import com.zak.rickandmorty.di.retrofitModule
import com.zak.rickandmorty.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger(Level.DEBUG)
			androidContext(this@BaseApplication)
			modules(listOf(repositoryModule, retrofitModule, apiModule, viewModelModule))
		}
	}

}