package id.neotica.rickpositorylegacy.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import id.neotica.rickpositorylegacy.MyApp;
import id.neotica.rickpositorylegacy.data.NetworkModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ViewModelModule.class,
                NetworkModule.class,
                ViewBindingModule.class
        }
)
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
