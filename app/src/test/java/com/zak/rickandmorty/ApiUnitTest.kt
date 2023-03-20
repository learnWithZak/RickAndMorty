package com.zak.rickandmorty

import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.service.RickMortyApiService
import org.junit.Test
import com.zak.rickandmorty.model.Character
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import retrofit2.HttpException
import retrofit2.Response
import com.zak.rickandmorty.service.handleApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.mockito.MockitoAnnotations
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.test.runTest

@ExperimentalCoroutinesApi
class ApiUnitTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockApiService: RickMortyApiService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `handleApiResponse should return success when response is successful and has body`() =
        runTest {
            // Given
            val expectedBody = Character(1, "Rick Sanchez", "", "", "", "", "", listOf(""), "", "")
            val response = Response.success(expectedBody)

            // When
            val result = handleApiResponse { response }

            // Then
            assertEquals(ApiResponse.success(expectedBody).data?.name, result.data?.name)
        }

    @Test
    fun `handleApiResponse should return error when response is not successful`() =
        runTest {
            // Given
            val response = Response.error<Character>(400, "".toResponseBody(null))

            // When
            val result = handleApiResponse { response }

            // Then
            assertEquals(response.code(), result.errorCode)
            assertEquals(response.message(), result.errorMessage)
        }

    @Test
    fun `handleApiResponse should return error when response is successful but body is null`() =
        runTest {
            // Given
            val response = Response.success<Character>(null)

            // When
            val result = handleApiResponse { response }

            // Then
            assertEquals(response.body(), result.data)
        }

    @Test
    fun `handleApiResponse should return error when HttpException is thrown`() =
        runTest {
            // Given
            val message = "Response.error()"
            val code = 401
            val exception = HttpException(Response.error<Character>(code, message.toResponseBody("text/plain".toMediaTypeOrNull())))
            `when`(mockApiService.getAllCharacters()).thenThrow(exception)

            // When
            val result = handleApiResponse { mockApiService.getAllCharacters() }

            // Then
            assertEquals(message, result.errorMessage)
            assertEquals(code, result.errorCode)
        }
}