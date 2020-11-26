Retrofit
========

A type-safe HTTP client for Android and Java.

For more information please see [the website][1].

添加post json支持 基于retrofit 2.9.0

```java
  Retrofit.Builder()
                .client(createOkHttpClient())
                .addConverterFactory(null != factory ? factory : GsonConverterFactory.create())
                .baseUrl(TextUtils.isEmpty(baseUrl) ? RetrofitClient.baseUrl : baseUrl)
                .jsonParse(object -> new Gson().toJson(object))
                .build();

    @JsonEncoded
    @POST(UrlConfig.LOGIN_CHECK)
    suspend fun loginCheck(
        @Header("token") token: String?,
        @JsonField("hid") hid: String,
        @JsonField("versionCode") versionCode: String,
        @JsonField("deviceModel") deviceModel: String?,
        @JsonField("os") os: String = "android",
        @JsonField("oldHid") oldHid: String?,
        @JsonField("mandatoryUpLearnHd") mandatoryUpLearnHd: Int = 0,
        @JsonField("pctype") pcType: String = "3"
    ): DataNull
```

Download

--------

Gradle:
```groovy
compile 'com.jiandan.retrofit2:1.0.0'
```

Retrofit requires at minimum Java 8+ or Android API 21+.


R8 / ProGuard
-------------

If you are using R8 the shrinking and obfuscation rules are included automatically.

ProGuard users must manually add the options from
[retrofit2.pro][proguard file].
You might also need [rules for OkHttp][okhttp proguard] and [Okio][okio proguard] which are dependencies of this library.


License
=======

    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: https://square.github.io/retrofit/
 [2]: https://search.maven.org/remote_content?g=com.squareup.retrofit2&a=retrofit&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 [proguard file]: https://github.com/square/retrofit/blob/master/retrofit/src/main/resources/META-INF/proguard/retrofit2.pro
 [okhttp proguard]: https://square.github.io/okhttp/#r8-proguard
 [okio proguard]: https://square.github.io/okio/#r8-proguard
