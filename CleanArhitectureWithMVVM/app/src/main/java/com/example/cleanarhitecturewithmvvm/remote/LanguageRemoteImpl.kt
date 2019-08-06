package com.example.cleanarhitecturewithmvvm.remote

import com.example.cleanarhitecturewithmvvm.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvvm.data.repository.LanguageRemote
import com.example.cleanarhitecturewithmvvm.remote.api.RetrofitApiInterfaceNetwork
import com.example.cleanarhitecturewithmvvm.remote.mapper.RemoteEntityMapper


class LanguageRemoteImpl (private val retrofitApiInterfaceNetwork: RetrofitApiInterfaceNetwork,
                          private val remoteEntityMapper: RemoteEntityMapper) : LanguageRemote {


    override suspend fun getAllPosts(): List<LanguageEntity> {
        return  retrofitApiInterfaceNetwork.getAllLanguage()
            .map { listItem ->
                remoteEntityMapper.mapFromRemote(listItem)
            }
    }

}