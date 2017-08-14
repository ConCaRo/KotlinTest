package testco.kotlin.ui.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.util.Log
import com.fernandocejas.sample.framework.interactor.UseCaseObserver
import testco.kotlin.data.DummyData
import testco.kotlin.domain.interactor.GetAlbumUsecase
import testco.kotlin.domain.model.AlbumModel
import javax.inject.Inject

/**
 * Created by Concaro on 8/7/2017.
 */
class DetailMusicViewModel @Inject constructor(var context: Context) : BaseObservable() {

    var album: AlbumModel = DummyData.getListAlbumModel().get(0)
    lateinit @Inject var getAlbumUsecase: GetAlbumUsecase

    fun loadData() {
        getAlbumUsecase.execute(AlbumObserver(), GetAlbumUsecase.Params.init(true, ""))
    }

    inner class AlbumObserver : UseCaseObserver<AlbumModel>() {

        override fun onNext(value: AlbumModel) {
            super.onNext(value)
            album = value
            Log.d("Trong", value.toString())
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            Log.d("Trong", e.printStackTrace().toString())
        }
    }

    fun toStringListSongs(): String {
        var s: String = "Songs: \n"
        album?.songs?.forEach { s += it.name + "\n" }
        return s
    }

    fun toStringListArtists(): String {
        var s: String = "Artists: \n"
        album?.artists?.forEach { s += it.name + "\n" }
        return s
    }

}