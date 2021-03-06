package testco.kotlin.domain.interactor

import com.fernandocejas.sample.framework.executor.ExecutionThread
import com.fernandocejas.sample.framework.executor.ThreadExecutor
import com.fernandocejas.sample.framework.interactor.UseCase
import io.reactivex.Observable
import testco.kotlin.data.DataStatus
import testco.kotlin.domain.model.AlbumModel
import testco.kotlin.domain.repository.DataRepository
import javax.inject.Inject

/**
 * Created by Concaro on 8/3/2017.
 */
class GetAlbumUsecase @Inject constructor(threadExecutor: ThreadExecutor, executionThread: ExecutionThread,
                                         val repository: DataRepository)
    : UseCase<AlbumModel, GetAlbumUsecase.Params>(threadExecutor, executionThread) {

    override fun buildObservable(params: Params): Observable<AlbumModel> {
        return repository.requestAlbum(params.dataStatus, params.refresh, params.id)
    }

    class Params constructor(val dataStatus: DataStatus, val refresh: Boolean, val id: String) {
        companion object {
            fun init(dataStatus: DataStatus, refresh: Boolean, id: String): Params {
                return Params(dataStatus, refresh, id)
            }
        }
    }
}

