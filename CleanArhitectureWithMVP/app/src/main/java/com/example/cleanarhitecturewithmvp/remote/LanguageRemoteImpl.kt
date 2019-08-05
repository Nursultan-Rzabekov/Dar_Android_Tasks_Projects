package com.example.cleanarhitecturewithmvp.remote

import com.example.cleanarhitecturewithmvp.data.model.LanguageEntity
import com.example.cleanarhitecturewithmvp.data.repository.LanguageRemote
import com.example.cleanarhitecturewithmvp.remote.api.RetrofitApiInterfaceNetwork
import com.example.cleanarhitecturewithmvp.remote.mapper.RemoteEntityMapper


class LanguageRemoteImpl (private val retrofitApiInterfaceNetwork: RetrofitApiInterfaceNetwork,
                          private val remoteEntityMapper: RemoteEntityMapper) : LanguageRemote {


    override suspend fun getAllPosts(): List<LanguageEntity> {
        return  retrofitApiInterfaceNetwork.getAllLanguage()
            .map { listItem ->
                remoteEntityMapper.mapFromRemote(listItem)
            }
    }

}