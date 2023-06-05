class Player {
    val name: String

    constructor(name: String) {
        this.name = name
        this.card = LotoCard()
    }

    val card: LotoCard

    fun createLotoCard() { //используй блок init { }, он вызывается один раз всегда при создании экземпляра класса
        println("Карта игрока: $name") // не надо будет в мэйн вызывать эту функцию
        card.addNum() // то же самое тут, функционал этого метода закинь в инит блок карточки
        card.show()
    }
    suspend fun checkWin() {//этот метод должен принимать число от генератора и взвращать булеан
        card.check()
    }

}


