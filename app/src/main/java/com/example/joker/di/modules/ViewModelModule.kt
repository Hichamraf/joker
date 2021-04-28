package hicham.com.bonialnews.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.joker.ui.home.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hicham.com.bonialnews.di.viewmodel.ViewModelFactory
import hicham.com.bonialnews.di.viewmodel.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
     abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
     abstract fun providesAuthViewModel(authViewModel: MainViewModel): ViewModel

}