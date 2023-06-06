import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Host {
    suspend fun generateRandomNum() = flow {
//        for (i in 1..100) {
//            emit((1..90).random())
//        }
        while (true) {
            emit((1..90).random())
            delay(200)
        }

    }
}