package id.phephen.firstdepedencyinjectionkoin

import android.app.Application
import id.phephen.firstdepedencyinjectionkoin.di.module.appModule
import id.phephen.firstdepedencyinjectionkoin.di.module.repoModule
import id.phephen.firstdepedencyinjectionkoin.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Phephen on 25/01/2022.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}