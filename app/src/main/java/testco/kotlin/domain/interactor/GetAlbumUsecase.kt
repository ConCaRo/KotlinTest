package testco.kotlin.domain.interactor

import com.fernandocejas.sample.framework.executor.ExecutionThread
import com.fernandocejas.sample.framework.executor.ThreadExecutor
import com.fernandocejas.sample.framework.interactor.UseCase
import io.reactivex.Observable
import testco.kotlin.data.model.AlbumEntity
import testco.kotlin.domain.repository.DataRepository

/**
 * Created by Concaro on 8/3/2017.
 */
class GetAlbumUsecase(threadExecutor: ThreadExecutor, executionThread: ExecutionThread,
                      val repository: DataRepository)
    : UseCase<AlbumEntity, GetAlbumUsecase.Params>(threadExecutor, executionThread) {

    override fun buildObservable(params: Params): Observable<AlbumEntity> {
        return repository.requestAlbum(params.refresh, params.id)
    }

    class Params constructor(val refresh: Boolean, val id: String) {
        companion object {
            fun init(refresh: Boolean, id: String): Params {
                return Params(refresh, id)
            }
        }
    }
}

