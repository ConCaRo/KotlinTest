package com.jota.sunshine

import com.fernandocejas.sample.framework.executor.ExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject constructor() : ExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()


}
