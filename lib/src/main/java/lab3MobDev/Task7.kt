package lab3MobDev

fun doorsOrZero(v: Vehicle): Int{
    if(v is Car){
        return v.doors
    }
    return 0
}

fun main(){
    //Проверка работы doorsOrZero с разными объектами
    val car: Vehicle = Car("Toyota", 4)
    val bike: Vehicle = Bike("Yamaha", 6)

    println("Car doors: ${doorsOrZero(car)}")
    println("Bike doors: ${doorsOrZero(bike)}")

    // 2. Безопасное приведение типов с помощью 'as?' (Safe Cast)
    // Если приведение невозможно, 'as?' не выбрасывает исключение, а возвращает null
    val c = (Bike("X", 3) as? Car)
    println("Safe cast result (Bike as? Car): $c")

    // 3. Небезопасное приведение типов с помощью 'as' (Unsafe Cast)
    // Строка закомментирована, так как приведение Bike к Car вызовет java.lang.ClassCastException
    // val unsafeCar = Bike("X", 3) as Car

}