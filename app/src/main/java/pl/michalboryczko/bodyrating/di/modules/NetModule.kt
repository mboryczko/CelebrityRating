package pl.michalboryczko.bodyrating.di.modules

/**
 * Created on 16.08.2018.
 */

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import pl.michalboryczko.bodyrating.AndroidApplication
import pl.michalboryczko.bodyrating.BuildConfig
import pl.michalboryczko.bodyrating.di.DaggerNames
import pl.michalboryczko.bodyrating.network.CustomLoggingInterceptor
import pl.michalboryczko.bodyrating.network.NetworkService
import pl.michalboryczko.bodyrating.network.SmayApiProvider
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import java.net.CookieHandler

private const val CACHE_SIZE = 36 * 1024 * 1024L
private const val CACHE_TIME = 0 //minuta

@Module
class NetModule(private val application: AndroidApplication) {

	@Provides
	@Singleton
	internal fun provideGson2(): Gson = GsonBuilder()
			.create()

	@Provides
	@Singleton
	@Named(DaggerNames.DESERIALIZER_GSON)
	internal fun provideDeserializerGson(): Gson = GsonBuilder()
			.create()

	@Provides
	@Singleton
	@Named(DaggerNames.RETROFIT_GSON)
	internal fun provideGson(): Gson = GsonBuilder()
			.create()

	@Provides
	@Singleton
	internal fun provideInterceptor(): Interceptor {
		val interceptor = CustomLoggingInterceptor()
		interceptor.level = CustomLoggingInterceptor.Level.BODY
		return interceptor
	}


	@Provides
	@Singleton
	internal fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {

		return OkHttpClient().newBuilder()
				.readTimeout(30, TimeUnit.SECONDS)
				.connectTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(interceptor)
				.build()

	}

	@Provides
	@Singleton
	internal fun provideRetrofit(@Named(DaggerNames.RETROFIT_GSON) gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
			.baseUrl(BuildConfig.API_ENDPOINT)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.client(okHttpClient)
			.build()




	@Provides
	@Singleton
	internal fun provideService(retrofit: Retrofit): NetworkService = retrofit.create(NetworkService::class.java)


}