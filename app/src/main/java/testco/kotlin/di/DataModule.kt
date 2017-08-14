package testco.kotlin.di

import android.content.Context
import com.antonioleiva.bandhookkotlin.data.lastfm.RequestInterceptor
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmObject
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import testco.kotlin.BuildConfig
import testco.kotlin.R
import testco.kotlin.data.rest.RestApi
import testco.kotlin.data.rest.RestApiImpl
import testco.kotlin.data.rest.RestConstant
import testco.kotlin.data.rest.RestService
import testco.kotlin.domain.repository.DataRepository
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Concaro on 8/9/2017.
 */
@Module
class DataModule {

    val BASE_URL = RestConstant.BASE_URL

    @Provides
    @Singleton
    fun provideRealm(): Realm = Realm.getDefaultInstance()

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    @Named("CacheDuration")
    fun provideCacheDuration(context: Context) = context.resources.getInteger(R.integer.cache_duration)

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setExclusionStrategies(object : ExclusionStrategy {
                    override fun shouldSkipField(f: FieldAttributes): Boolean {
                        return f.declaringClass == RealmObject::class.java
                    }

                    override fun shouldSkipClass(clazz: Class<*>): Boolean {
                        return false
                    }
                })
                .create();
    }

    @Provides
    @Singleton
    @Named("loggingIntercepter")
    fun provideIntercepter(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    @Named("requestInterceptor")
    fun provideRequestInterceptor(@Named("CacheDuration") cacheDuration: Int): Interceptor
            = RequestInterceptor(cacheDuration)

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named("loggingIntercepter") loggingInterceptor: Interceptor,
                            @Named("requestInterceptor") requestInterceptor: Interceptor)
            : OkHttpClient {
        return OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(requestInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitAdapter(@Named("baseUrl") baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideRestService(retrofit: Retrofit): RestService = retrofit.create(RestService::class.java)

    @Provides
    @Singleton
    fun providRestApi(restApiImpl: RestApiImpl) : RestApi = restApiImpl


    @Provides
    @Singleton
    fun provideDataReposity(dataRepository: testco.kotlin.data.repository.DataRepository) : DataRepository {
        return dataRepository
    }
}