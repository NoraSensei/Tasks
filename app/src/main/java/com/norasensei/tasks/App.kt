package com.norasensei.tasks

import android.app.Application
import com.norasensei.tasks.di.Dependencies

class App:Application() {
	override fun onCreate() {
		super.onCreate()
		Dependencies.init(applicationContext)
	}
}