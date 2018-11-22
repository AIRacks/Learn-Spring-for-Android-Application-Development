package springforandroid.pactpub.sunnat629.basicauthinkotlin.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import springforandroid.pactpub.sunnat629.basicauthinkotlin.basicauth.BasicAuthInterceptor


class UserServiceImpl{
   fun getGithubServiceImpl(username:String, password:String): UserService {
        val retrofit = Retrofit.Builder()
                .client(getOkhttpClient(username, password))
                .baseUrl("http://e92a19d6.ngrok.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(UserService::class.java)
    }

    private fun getOkhttpClient(username:String, password:String): OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(BasicAuthInterceptor(username, password))
                .build()
    }
}