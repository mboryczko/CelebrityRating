package pl.michalboryczko.bodyrating.network.wrapper

/**
 * Created on 16.08.2018.
 */
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.executor.PostExecutionThread

/**
 * Simple wrapper for [SingleUseCase] to omit input type parameter
 *
 * @param R the output value type
 */
abstract class SingleVoidUseCase<R> protected constructor(
		threadExecutor: ThreadExecutor,
		postExecutionThread: PostExecutionThread) : SingleUseCase<Unit, R>(threadExecutor, postExecutionThread) {

	fun execute(observer: DisposableSingleObserver<R>) = super.execute(observer, Unit)

	override fun buildUseCaseSingle(unit: Unit): Single<R> = buildUseCaseSingle()

	protected abstract fun buildUseCaseSingle(): Single<R>

	internal fun single(): Single<R> = buildUseCaseSingle()
}