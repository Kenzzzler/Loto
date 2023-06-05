import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Host {
    suspend fun generateRandomNum(): Flow<Int> = flow {
        for (i in 1..100) {// зачем генерить числа 100 раз, если боченков всего 90
            emit((1..90).random())// возможно повторение боченков
        }

    }
}