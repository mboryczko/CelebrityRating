package pl.michalboryczko.bodyrating.di.modules

import dagger.Module
import dagger.Provides
import pl.michalboryczko.bodyrating.executor.PostExecutionThread
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.interactor.GetGirlsUseCase
import pl.michalboryczko.bodyrating.network.Repository
import javax.inject.Singleton

/**
 * Created on 16.08.2018.
 */

@Module
class ExecutorModule {

    @Provides
    @Singleton
    internal fun provideGetGirlsUseCase(
            repository: Repository,
            threadExecutor: ThreadExecutor,
            postExecutionThread: PostExecutionThread
    ) = GetGirlsUseCase(repository, threadExecutor, postExecutionThread)

}