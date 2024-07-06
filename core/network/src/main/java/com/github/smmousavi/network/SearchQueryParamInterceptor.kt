package com.github.smmousavi.network

import okhttp3.Interceptor
import okhttp3.Response

class SearchQueryParamInterceptor : Interceptor {
    @Volatile
    var searchTerm: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val originalHttpUrl = request.url
        if (searchTerm.isNullOrEmpty().not() && request.url.toString().contains("graphql")) {
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("search", searchTerm)
                .build()
            request = request.newBuilder()
                .url(url)
                .build()
        }
        return chain.proceed(request)
    }
}