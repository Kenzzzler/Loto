import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LotoCard {
    val numList : MutableList<MutableList<Int>> = mutableListOf(
        mutableListOf(),
        mutableListOf(),
        mutableListOf()
    )
    val escape = MutableList(4) { 0 }

    fun addNum() {
        numList.forEachIndexed { index, _ ->
            val availableNums = (1..90).toMutableList()
            for (a in 1..5) {
                val randomIndex = (0 until availableNums.size).random()
                val randomNum = availableNums.removeAt(randomIndex)
                numList[index].add(randomNum)
            }
            numList[index].addAll(escape)
            numList[index].shuffle()
        }
    }

    fun show() {
        println("╔═════════════════════════════════════════════════════╗")
        numList.forEach { row ->
            print("║")
            row.forEach { num ->
                print(if (num == 0)
                        "   ".padEnd(5, ' ')
//                    else if(num == 100)
//                        " X ".padEnd(5, ' ')
                    else
                        " $num ".padEnd(5, ' '))
                print("║")
            }
            println()
        }
        println("╚═════════════════════════════════════════════════════╝")

    }

    suspend fun check() = runBlocking {
        launch { Host.generateRandomNum()
            .collect { randomNumber: Int ->
                numList.forEachIndexed { index, ints ->
                    for (i in ints.indices) {
                        if (ints[i] == randomNumber) {
                            ints[i] = 0
                        }
                    }
                }
                show()
                if (numList[0].all { it == 0 }) {
                    cancel()
                }
            } }
    }



}

