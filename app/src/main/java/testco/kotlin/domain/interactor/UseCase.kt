package com.fernandocejas.sample.framework.interactor

import com.fernandocejas.sample.framework.executor.ExecutionThread
import com.fernandocejas.sample.framework.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, in Params> constructor(val threadExecutor: ThreadExecutor,
                                                 val executionThread: ExecutionThread) {

    private val disposables = CompositeDisposable()

    abstract fun buildObservable(params: Params): Observable<T>

    fun execute(observer: UseCaseObserver<T>, params: Params = null!!) {
        buildObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(executionThread.scheduler())
                .subscribeWith(observer)
    }

    fun dispose() = disposables.dispose()
}
