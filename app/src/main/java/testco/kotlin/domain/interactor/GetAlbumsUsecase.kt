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
class GetAlbumsUsecase @Inject constructor(threadExecutor: ThreadExecutor, executionThread: ExecutionThread,
                                           val repository: DataRepository)
    : UseCase<List<AlbumModel>, GetAlbumsUsecase.Param>(threadExecutor, executionThread) {

    override fun buildObservable(params: Param): Observable<List<AlbumModel>> {
        return repository.requestAlbums(params.dataStatus,  params.refresh, params.id, params.artist)
    }

    class Param private constructor(val dataStatus: DataStatus, val refresh: Boolean, val id: String, val artist: String) {
        companion object {
            fun initValue(dataStatus: DataStatus,refresh: Boolean, id: String, artist: String): Param {
                return Param(dataStatus, refresh, id, artist)
            }
        }
    }

}