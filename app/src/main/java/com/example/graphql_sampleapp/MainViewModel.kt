package com.example.graphql_sampleapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.example.graphql.GetCharacterQuery
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel : ViewModel() {

    private val apolloClient: ApolloClient = ApolloClient.builder()
        .serverUrl("https://rickandmortyapi.com/graphql")
        .build()

    private val _characterDetail = MutableLiveData<Character>()
    val characterResult: LiveData<Character> = _characterDetail

    fun searchByCharacterId(Id: String) {
        viewModelScope.launch {
            val response = apolloClient.query(GetCharacterQuery(Id)).await()
            val resCharacter = response.data?.character
            resCharacter?.let {
                _characterDetail.value = Character(
                    it.id.toString(),
                    it.name.toString(),
                    it.image.toString(),
                    it.gender.toString()
                )
            }
        }
    }

    data class Character(var id: String, var name: String, var image: String, var gender: String)
}