package testco.kotlin.ui.viewmodel

import android.content.Context
import android.databinding.ObservableField
import android.util.Log
import android.widget.Toast
import com.fernandocejas.sample.framework.interactor.UseCaseObserver
import testco.kotlin.data.DataStatus
import testco.kotlin.domain.interactor.GetAlbumUsecase
import testco.kotlin.domain.model.AlbumModel
import javax.inject.Inject

/**
 * Created by Concaro on 8/7/2017.
 */
class DetailMusicViewModel @Inject constructor(context: Context) : BaseViewModel(context) {
    override fun onActivityCreated() {
    }

    override fun onActivityResume() {
    }

    override fun onActivityDestroy() {
        getAlbumUsecase.dispose()
    }

    var album: ObservableField<AlbumModel> = ObservableField<AlbumModel>()
    var songs: ObservableField<String> = ObservableField<String>()
    var artists: ObservableField<String> = ObservableField<String>()

    lateinit @Inject var getAlbumUsecase: GetAlbumUsecase

    var id: Int = -1
    fun initData(id: Int) {
        this.id = id
    }

    fun loadData() {
        getAlbumUsecase.execute(AlbumObserver(), GetAlbumUsecase.Params.init(DataStatus.CACHE, true, id.toString()))
        //getAlbumUsecase.execute(AlbumObserver(), GetAlbumUsecase.Params.init(DataStatus.CLOUD, true, id.toString()))

        /*album.addOnPropertyChangedCallback()*/
    }

    inner class AlbumObserver : UseCaseObserver<AlbumModel>() {

        override fun onNext(value: AlbumModel) {
            super.onNext(value)
            album.set(value)
            toStringListSongs()
            toStringListArtists()

            Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show()
            Log.d("Trong", value.toString())
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            showErrorMessage(e)
        }
    }

    fun toStringListSongs() {
        var s: String = "Songs: \n"
        album?.get()?.songs?.forEach { s += it.name + "\n" }
        songs.set(s)
    }

    fun toStringListArtists() {
        var s: String = "Artists: \n"
        album?.get()?.artists?.forEach { s += it.name + "\n" }
        artists.set(s)
    }

}

