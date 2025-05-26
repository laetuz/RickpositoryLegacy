package id.neotica.rickpositorylegacy.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import id.neotica.rickpositorylegacy.MainActivity;
import id.neotica.rickpositorylegacy.fragment.MainFragment;

@Module
public abstract class ViewBindingModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract MainFragment bindMainFragment();
}
