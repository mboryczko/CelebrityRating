package pl.michalboryczko.bodyrating.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import pl.michalboryczko.bodyrating.di.DaggerNames
import pl.michalboryczko.bodyrating.network.NetworkService
import pl.michalboryczko.bodyrating.network.Repository
import pl.michalboryczko.bodyrating.network.RepositoryImpl
import pl.michalboryczko.bodyrating.storage.UserPreferences
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created on 16.08.2018.
 */

@Module
class InteractorModule {

	@Provides
	@Singleton
	internal fun provideProductRepository(service: NetworkService,
										  @Named(DaggerNames.APPLICATION_CONTEXT) context: Context,
										  preferences: UserPreferences):
			Repository = RepositoryImpl(service, context, preferences)



}