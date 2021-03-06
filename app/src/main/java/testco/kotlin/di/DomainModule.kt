package testco.kotlin.di

import com.fernandocejas.sample.framework.executor.ExecutionThread
import com.fernandocejas.sample.framework.executor.ThreadExecutor
import com.jota.sunshine.UIThread
import com.jota.sunshine.data.executor.JobExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideExecutionThread(uiThread: UIThread): ExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    /*@Provides
    @Singleton
    fun provideGetAlbumsUsecase(threadExecutor: ThreadExecutor, executionThread: ExecutionThread,
                                repository: DataRepository) : GetAlbumsUsecase {
        return GetAlbumsUsecase(threadExecutor, executionThread, repository)
    }*/
}