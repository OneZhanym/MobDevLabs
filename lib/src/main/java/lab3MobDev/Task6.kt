package lab3MobDev

// Функция, принимающая список элементов типа базового класса Vehicle (полиморфизм)
fun printFleet(fleet: List<Vehicle>){
    for (vehicle in fleet){
        println( vehicle.info())
    }
}
fun main(){
    // Список объектов дочерних классов, приведенных к базовому типу Vehicle
    val fleet: List<Vehicle> = listOf(
        Car("Volvo", 4),
        Bike("Trek", 18)
    )
    // Явный Upcast: тип переменной — Vehicle, а объект — Car
    val v: Vehicle = Car("Volvo", 4)
    println(v.info())
    printFleet(fleet)
}