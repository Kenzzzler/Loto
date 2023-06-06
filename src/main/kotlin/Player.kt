import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Player {
    val name: String

    constructor(name: String) {
        this.name = name
        this.card = LotoCard()
    }

    val card: LotoCard

    fun createLotoCard() {
        println("Карта игрока: $name")
        card.addNum()
        card.show()
    }
//    suspend fun checkWin() {
//        card.check()
//    }
    suspend fun check() = runBlocking {
        launch { Host.generateRandomNum()
            .collect { randomNumber: Int ->
                card.numList.forEachIndexed { index, ints ->
                    for (i in ints.indices) {
                        if (ints[i] == randomNumber) {
                            ints[i] = 0
                            cancel()
                        }
                    }
                }
                card.show()
//                if (numList[0].all { it == 0 }) {
//
//                }
            } }
    }

}


