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
    suspend fun checkWin() {
        card.check()
    }

}


