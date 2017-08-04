package testco.kotlin.domain.interactor

import com.fernandocejas.sample.framework.executor.ExecutionThread
import com.fernandocejas.sample.framework.executor.ThreadExecutor
import com.fernandocejas.sample.framework.interactor.UseCase
import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.domain.repository.DataRepository

/**
 * Created by Concaro on 8/3/2017.
 */
class GetAlbumsUsecase(threadExecutor: ThreadExecutor, executionThread: ExecutionThread,
                       val repository: DataRepository)
    : UseCase<List<AlbumEntity>, GetAlbumsUsecase.Param>(threadExecutor, executionThread) {

    override fun buildObservable(params: Param): Observable<List<AlbumEntity>> {
        return repository.requestAlbums(params.refresh, params.id, params.artist)
    }

    class Param private constructor(val refresh: Boolean, val id: String, val artist: String) {
        companion object {
            fun initValue(refresh: Boolean, id: String, artist: String): Param {
                return Param(refresh, id, artist)
            }
        }
    }

}