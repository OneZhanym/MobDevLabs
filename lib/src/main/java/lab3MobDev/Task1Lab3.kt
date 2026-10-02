package com.example.lib

class Sensor(val id: String, var reading: Double){ //Объявляем класс Sensor с первичным конструктором, два свойства
    init { require(id.isNotBlank()) } //блок инициализации с проверкой на Null и строку состоящую из одних пробелов
    fun update(reading: Double){ //Функция для обновления значения reading
        require(reading.isFinite()) //Проверка значения на Double
        this.reading = reading // Обновляем значение свойства reading
    }
    override fun toString(): String = "Sensor(id = $id, reading = $reading)"
}

fun main (){
    val senA = Sensor("192", 9.19)
    val senB = Sensor("196", 18.1)
    senA.update(10.0) // Вызов метода update
    println("$senA\n$senB")

    val senC = Sensor("  ", 1.2) //Кейс с заведомо неверными значениями параметра id
    println(senC)
}