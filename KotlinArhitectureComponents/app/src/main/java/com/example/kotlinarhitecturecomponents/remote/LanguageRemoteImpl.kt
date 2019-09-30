package com.example.kotlinarhitecturecomponents.remote


import com.example.kotlinarhitecturecomponents.data.model.LanguageEntity
import com.example.kotlinarhitecturecomponents.data.repository.LanguageRemote
import com.example.kotlinarhitecturecomponents.remote.api.RetrofitApiInterfaceNetwork
import com.example.kotlinarhitecturecomponents.remote.mapper.RemoteEntityMapper
import io.reactivex.Single

class LanguageRemoteImpl (private val retrofitApiInterfaceNetwork: RetrofitApiInterfaceNetwork,
                          private val remoteEntityMapper: RemoteEntityMapper) : LanguageRemote{

    override fun getAllPosts(i:Int,k:Int): Single<List<LanguageEntity>> {
        return  retrofitApiInterfaceNetwork.getAllLanguage(i,k)
            .map { it.map {listItem ->
                remoteEntityMapper.mapFromRemote(listItem)
                }
            }
    }
}