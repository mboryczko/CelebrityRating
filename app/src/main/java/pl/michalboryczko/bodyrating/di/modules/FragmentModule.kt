package pl.michalboryczko.bodyrating.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michalboryczko.bodyrating.di.DaggerNames
import pl.michalboryczko.bodyrating.di.scopes.FragmentScope
import javax.inject.Named

/**
 * Created on 16.08.2018.
 */

@Module
class FragmentModule(private val fragmentContext: Context) {

	@Provides
	@FragmentScope
	@Named(DaggerNames.FRAGMENT_CONTEXT)
	internal fun provideFragmentContext(): Context = fragmentContext

}