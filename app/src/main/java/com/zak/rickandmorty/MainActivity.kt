package com.zak.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.databinding.ActivityMainBinding
import com.zak.rickandmorty.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private val TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.charactersLiveData.observe(this) { characters ->
            when (characters.status) {
                ApiResponse.Status.SUCCESS -> {
                    Log.d(TAG, "all episodes" + characters.data?.results.toString())
                }
                ApiResponse.Status.ERROR -> {
                    Log.d(TAG, "An error" + characters.errorCode + characters.errorMessage)
                }
                ApiResponse.Status.LOADING -> {
                    Log.d(TAG, "Loading")
                }
            }
        }

        viewModel.uniqueCharacterLiveData.observe(this) { character ->
            when (character.status) {
                ApiResponse.Status.SUCCESS -> {
                    Log.d(TAG, "all episodes" + character.data?.toString())
                }
                ApiResponse.Status.ERROR -> {
                    Log.d(TAG, "An error" + character.errorCode + character.errorMessage)
                }
                ApiResponse.Status.LOADING -> {
                    Log.d(TAG, "Loading")
                }
            }
        }

        viewModel.locationsLiveData.observe(this) { locations ->
            when (locations.status) {
                ApiResponse.Status.SUCCESS -> {
                    Log.d(TAG, "all episodes" + locations.data?.results.toString())
                }
                ApiResponse.Status.ERROR -> {
                    Log.d(TAG, "An error" + locations.errorCode + locations.errorMessage)
                }
                ApiResponse.Status.LOADING -> {
                    Log.d(TAG, "Loading")
                }
            }
        }

        viewModel.episodesLiveData.observe(this) { episodes ->
            when (episodes.status) {
                ApiResponse.Status.SUCCESS -> {
                    Log.d(TAG, "all episodes" + episodes.data?.results.toString())
                }
                ApiResponse.Status.ERROR -> {
                    Log.d(TAG, "An error" + episodes.errorCode + episodes.errorMessage + episodes)
                }
                ApiResponse.Status.LOADING -> {
                    Log.d(TAG, "Loading")
                }
            }
        }
    }
}