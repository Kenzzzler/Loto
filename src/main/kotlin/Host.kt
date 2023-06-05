import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Host {
    suspend fun generateRandomNum(): Flow<Int> = flow {
        for (i in 1..100) {
            emit((1..90).random())
        }

    }
}