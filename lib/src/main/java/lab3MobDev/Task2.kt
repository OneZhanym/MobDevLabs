package lab3MobDev

class Counter(start: Int = 0){ // Класс счетчика с начальным значением по умолчанию start = 0
    private var current = start //Инкапсулированное свойство для хранения текущего значения
    fun value(): Int{ //Метод для безопасного чтения текущего значения счетчика
        return current
    }
    fun inc(step: Int = 1){
        require(step > 0) //Проверка на шаг (строго больше 0)
        current += step
    }

    fun reset() { //Метод сброса счётчика
        current = 0
    }
}

fun main(){
    val count1 = Counter(0)
    println(count1.value())
    //Создание счетчика со стартом 3, прибавление 2 (выведет 5)
    val count2 = Counter(3)
    count2.inc(2)
    println(count2.value())
    //Создание счетчика со стартом 3, вызов метода inc с неверным значением выведет ошибку IllegalArgumentException
    val count3 = Counter(3)
    count3.inc(-1)
    println(count3.value())
}