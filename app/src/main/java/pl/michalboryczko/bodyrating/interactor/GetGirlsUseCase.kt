package pl.michalboryczko.bodyrating.interactor

import io.reactivex.Single
import pl.michalboryczko.bodyrating.executor.PostExecutionThread
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.model.Person
import pl.michalboryczko.bodyrating.network.Repository
import pl.michalboryczko.bodyrating.network.wrapper.SingleVoidUseCase
import javax.inject.Inject

class GetGirlsUseCase @Inject constructor(
        private val repository: Repository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread) : SingleVoidUseCase<List<Person>>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(): Single<List<Person>>
            = repository.getGirls()

}