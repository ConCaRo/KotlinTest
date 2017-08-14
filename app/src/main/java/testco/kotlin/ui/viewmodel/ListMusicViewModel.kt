package testco.kotlin.ui.viewmodel

import android.content.Context
import android.util.Log
import com.fernandocejas.sample.framework.interactor.UseCaseObserver
import testco.kotlin.domain.interactor.GetAlbumsUsecase
import testco.kotlin.domain.model.AlbumModel
import javax.inject.Inject

/**
 * Created by Concaro on 8/7/2017.
 */
class ListMusicViewModel @Inject constructor(context: Context) {

    var items: MutableList<AlbumModel> = ArrayList()
    lateinit @Inject var getAlbumsUsecase: GetAlbumsUsecase

    fun loadData() {
        getAlbumsUsecase.execute(AlbumsObserver(), GetAlbumsUsecase.Param.initValue(true, "", ""))
    }

    inner class AlbumsObserver : UseCaseObserver<List<AlbumModel>>() {

        override fun onNext(value: List<AlbumModel>) {
            super.onNext(value)
            updateData(value)
            Log.d("Trong", value.toString())
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            Log.d("Trong", e.printStackTrace().toString())
        }
    }

    fun updateData(_items: List<AlbumModel>) {
        items.clear()
        items.addAll(_items)
    }
}