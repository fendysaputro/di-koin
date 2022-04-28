package id.phephen.firstdepedencyinjectionkoin.di.module

import id.phephen.firstdepedencyinjectionkoin.data.repository.MainRepository
import org.koin.dsl.module

/**
 * Created by Phephen on 25/01/2022.
 */

val repoModule = module {
    single {
        MainRepository(get())
    }
}