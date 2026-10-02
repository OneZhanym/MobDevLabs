package lab3MobDev

open class Vehicle(val brand: String){  // Базовый класс "Транспортное средство", открытый для наследования
    init{ require(brand.isNotBlank()) } // Валидация: название бренда не должно быть пустым или состоять из одних пробелов
    open fun info(): String { // Открытый метод для переопределения в дочерних классах
        return "Vehicle $brand"
    }
    open fun maxSpeedKmh(): Int { // Открытый метод возврата максимальной скорости по умолчанию
        return 0
    }
}
class Car(brand: String, val doors: Int) : Vehicle(brand) { // Дочерний класс "Автомобиль", наследующий Vehicle
    init {require(doors >= 2)} // Валидация: количество дверей должно быть не менее 2
    override fun info(): String{ // Переопределение текстовой информации об автомобиле
        return "Car $brand with $doors doors"
    }
    override fun maxSpeedKmh(): Int { // Переопределение максимальной скорости для автомобиля
        return 220
    }
}

class Bike(brand: String, val gears: Int) : Vehicle(brand){ // Дочерний класс "Велосипед / Мотоцикл", наследующий Vehicle
    init {require(gears >= 1)} // Валидация: количество передач должно быть не менее 1
    override fun info(): String {
        return "Bike $brand with $gears gears"
    }
    override fun maxSpeedKmh(): Int {
        return 370
    }
}

fun main(){
    val car1 = Car("McLaren", 2)
    val bike1 = Bike("Harley Davidson", 6)
    println("${car1.info()} - max speed ${car1.maxSpeedKmh()}, ${bike1.info()}, max speed ${bike1.maxSpeedKmh()}")
    val car2 = Car("  ", 1) // Передаём не валидные данные в переменные car2, bike2 и получаем IllegalArgumentException
    val bike2 = Bike("", 0)
    println("${car2.info()} - max speed ${car2.maxSpeedKmh()}, ${bike2.info()}, max speed ${bike2.maxSpeedKmh()}")
}