import java.text.SimpleDateFormat
import java.util.*

object AndroidConfig {
    const val minSdk = 26
    const val targetSdk = 33
    const val compileSdk = 33
    const val appId = "com.boreal.allen"
    const val versionCode = 1
    val versionName = "1.1.0-${SimpleDateFormat("yyyyMMdd", Locale.US).format(Date())}"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}