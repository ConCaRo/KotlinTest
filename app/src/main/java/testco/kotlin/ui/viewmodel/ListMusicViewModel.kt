package testco.kotlin.ui.viewmodel

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.util.Log
import com.fernandocejas.sample.framework.interactor.UseCaseObserver
import testco.kotlin.data.DataStatus
import testco.kotlin.domain.interactor.GetAlbumsUsecase
import testco.kotlin.domain.model.AlbumModel
import javax.inject.Inject

/**
 * Created by Concaro on 8/7/2017.
 */
class ListMusicViewModel @Inject constructor(context: Context) : BaseViewModel(context) {

    override fun onActivityCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityDestroy() {
        getAlbumsUsecase.dispose()
    }

    var items: ObservableList<AlbumModel> = ObservableArrayList<AlbumModel>()
    lateinit @Inject var getAlbumsUsecase: GetAlbumsUsecase

    fun loadData() {
        getAlbumsUsecase.execute(AlbumsObserver(), GetAlbumsUsecase.Param.initValue(DataStatus.CACHE, true, "", ""))
        getAlbumsUsecase.execute(AlbumsObserver(), GetAlbumsUsecase.Param.initValue(DataStatus.CLOUD, true, "", ""))
    }

    inner class AlbumsObserver : UseCaseObserver<List<AlbumModel>>() {

        override fun onNext(value: List<AlbumModel>) {
            super.onNext(value)
            updateData(value)
            Log.d("Trong", value.toString())
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            showErrorMessage(e)
        }
    }

    fun updateData(_items: List<AlbumModel>) {
        items.clear()
        items.addAll(_items)
    }
}