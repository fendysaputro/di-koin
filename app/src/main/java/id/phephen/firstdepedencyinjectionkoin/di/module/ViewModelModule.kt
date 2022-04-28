package id.phephen.firstdepedencyinjectionkoin.di.module

import id.phephen.firstdepedencyinjectionkoin.ui.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Phephen on 25/01/2022.
 */

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}