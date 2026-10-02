package lab3MobDev

open class Employee(val name: String, val baseSalary: Int){ // Базовый класс для всех сотрудников с primary-конструктором
    init {require(name.isNotBlank()) // Единый блок инициализации с валидацией входных данных
        require(baseSalary > 0)}
    open fun pay(): Int = baseSalary // Базовый метод расчета выплаты, возвращающий установленный оклад
    open fun describe(): String = "$name: ${pay()}" // Метод вывода информации, использующий результат вызова динамического метода pay()
}
class Accountant(name: String, baseSalary: Int, val bonusPercent: Int) : Employee(name, baseSalary){ // Класс бухгалтера, расширяющий базовый класс Employee
    init {require(bonusPercent in 0..100)} // Валидация: процент бонуса должен быть в допустимом диапазоне от 0 до 100%
    override fun pay() = super.pay() + (super.pay() * bonusPercent / 100) // Переопределение метода pay(): берет базовую выплату из super.pay() и прибавляет к ней бонус
    override fun describe() = "Accountant " + super.describe()
}
class Intern(name: String, baseSalary: Int, val mentor: String): Employee(name, baseSalary){
    init{require(mentor.isNotBlank())} // Валидация: имя наставника не должно быть пустым
    override fun pay() = super.pay() / 2 // Переопределение метода pay(): вычисляет ровно половину от результата вызова super.pay()
}

fun main(){
    val employees: List<Employee> = listOf(
        Employee("Vasya", 90_000),
        Accountant("Stepan", 100_000, 15),
        Intern("Petro", 45_000, "Yaroslav")
    )
    val totalPay = employees.sumOf { it.pay() } // Вычисление общей суммы выплат по всему списку сотрудников с помощью sumOf

    for (e in employees) { // Демонстрация полиморфизма: для каждого объекта автоматически вызывается своя версия describe() и pay()
        println(e.describe())
    }
    println("Total payroll: $totalPay")
}