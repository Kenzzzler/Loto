suspend fun main(args: Array<String>) {
    println("Введите имя первого игрока")
    var _name: String = readln()
    val player1 = Player(_name)
    println("Введите имя второго игрока")
    _name = readln()
    val player2 = Player(_name)

    player1.createLotoCard()
    player2.createLotoCard()

    player1.checkWin()
    player2.checkWin()

}

