package com.zak.rickandmorty.di

import com.zak.rickandmorty.repository.RemoteDataRepository
import com.zak.rickandmorty.repository.RemoteDataRepositoryImpl
import com.zak.rickandmorty.service.RickMortyApiService
import com.zak.rickandmorty.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
	viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
	single<RemoteDataRepository> {
		RemoteDataRepositoryImpl(get())
	}
}

val apiModule = module {
	fun provideUseApi(retrofit: Retrofit): RickMortyApiService {
		return retrofit.create(RickMortyApiService::class.java)
	}

	single { provideUseApi(get()) }
}

val retrofitModule = module {

	fun provideRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl("https://rickandmortyapi.com/api/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	single { provideRetrofit() }
}