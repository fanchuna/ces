package me.rerere.rikkahub.data.ai

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import okhttp3.Interceptor
import okhttp3.Response

class AIRequestInterceptor(private val remoteConfig: FirebaseRemoteConfig) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}
