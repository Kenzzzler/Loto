import kotlinx.coroutines.flow.Flow

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
                    else if(num == 100)
                        " X ".padEnd(5, ' ')
                    else
                        " $num ".padEnd(5, ' '))
                print("║")
            }
            println()
        }
        println("╚═════════════════════════════════════════════════════╝")

    }

    suspend fun check() {
        Host.generateRandomNum().collect { randomNumber: Int ->
            numList.forEachIndexed { index, ints ->
                for (i in ints.indices) {
                    if (ints[i] == randomNumber){
                        ints[i] = 100
                    }
                }
            }
            numList.forEachIndexed { index, ints ->
                if (ints.all { it == 0 && it == 100 }) {

                }
            }
        }


        show()

    }


}
