package com.example.albumcreation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumcreation.model.Album
import com.example.albumcreation.model.AlbumService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel:ViewModel() {

    private val albumService = AlbumService()
    private val disposable = CompositeDisposable()

    val album = MutableLiveData<List<Album>>()
    val albumLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchAffirmation()
    }

    private fun fetchAffirmation() {
        loading.value = true
        disposable.add(
            albumService.getAlbums()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Album>>(){
                    override fun onSuccess(value: List<Album>?) {
                        album.value = value
                        albumLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        albumLoadError.value = true
                        loading.value = false
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}