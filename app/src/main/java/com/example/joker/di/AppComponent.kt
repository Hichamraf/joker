package hicham.com.bonialnews.di

import com.example.joker.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import com.example.joker.di.modules.DataModule
import hicham.com.bonialnews.di.modules.ViewModelModule
import com.example.joker.di.modules.home.MainActivityModule
import com.example.joker.ui.BaseApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, DataModule::class, AppModule::class, ViewModelModule::class, MainActivityModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {


    @Component.Builder
    interface Builder{
        @BindsInstance
       fun application(baseApplication: BaseApplication) : Builder
        fun build() : AppComponent
    }

}