package pl.michalboryczko.bodyrating.di.modules

/**
 * Created on 16.08.2018.
 */
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michalboryczko.bodyrating.di.DaggerNames
import pl.michalboryczko.bodyrating.di.scopes.ActivityScope
import javax.inject.Named

@Module
class ActivityModule(private val activityContext: Context) {

	@Provides
	@Named(DaggerNames.ACTIVITY_CONTEXT)
	@ActivityScope
	internal fun provideActivityContext(): Context = activityContext

}