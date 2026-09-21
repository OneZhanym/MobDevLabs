package com.example.lib



fun main() { // Karyaka Nikita
    // 1.	Создать массив из 5 целых чисел и вывести все элементы.
    val intArray = intArrayOf(52, 60, 77, 103, 10)
    println(intArray.contentToString())

    //2.	Найти сумму элементов массива.
    val SumOfNums = intArray.sum()
    println(SumOfNums)

    // 3.	Найти максимальный элемент массива.
    val MaxElement = intArray.max()
    println(MaxElement)

    //4.	Посчитать количество чётных чисел в массиве.
    val EvenNums = intArray.count {it % 2 == 0}
    println(EvenNums)

    //5.	Развернуть массив (вывести в обратном порядке).
    val ReversList = intArray.reversed()
    println(ReversList)

    //6.	Проверить, содержит ли массив заданное число.
    val FindNum = intArray.find { it == 1 }
    println(FindNum)

    //7.	Отсортировать массив по возрастанию.
    val SortList = intArray.sorted()
    println(SortList)

    //8.	Создать массив строк и найти самую длинную строку.
    val ProgLang = arrayOf("Kotlin", "Java", "Flutter", "Swift")
    val MaxStr = ProgLang.maxBy { it.length }
    println(MaxStr)

    //9.	Найти индекс минимального элемента массива.
    val MinElement = ProgLang.minOrNull()
    val MinIndex = ProgLang.indexOf(MinElement)
    println(MinIndex)

    //10.	Умножить каждый элемент массива на 2.
    val MultElement = intArray.map { it * 2}
    println(MultElement)

    //ArrayList
    //1.	Создать список целых чисел и добавить в него 10 элементов.
    val ArrListOfNums = arrayListOf<Int>()
    val TestListOfNums = arrayListOf(90, 20, 18, 100, 51, 66, 0, 8, 9, 3)
    ArrListOfNums.addAll(TestListOfNums)
    println(ArrListOfNums)

    //2.	Удалить элемент из списка по индексу.
    ArrListOfNums.removeAt(3)
    println(ArrListOfNums)
    ArrListOfNums.add(100)

    //3.	Найти среднее значение элементов списка.
    println(ArrListOfNums.average())

    //4.	Проверить, пустой ли список.
    println(ArrListOfNums.isEmpty())

    //5.	Заменить элемент списка на другой.
    ArrListOfNums.set(9, 91)
    println(ArrListOfNums)

    //6.	Перевести список строк в верхний регистр.
    val StrList = arrayListOf("cocojambo", "intrenational", "boiled chicken", "puppies")
    val UpStrList = StrList.map { it.uppercase() }
    println(UpStrList)

    //7.	Создать список чисел и удалить все чётные.
    val EvenNumList = arrayListOf(2, 4, 6, 8, 1, 9, 11, 3, 90, 45)
    val DelEvenNums = EvenNumList.removeIf { it % 2 == 0}
    println(EvenNumList)

    //8.	Объединить два списка в один.
    val UnList = StrList.union(EvenNumList)
    println(UnList)

    //9.	Найти второй по величине элемент списка.
    val SecndElem = EvenNumList.sortedDescending().get(1)
    println(SecndElem)

    //10.	Преобразовать список чисел в множество (Set).
    val TList = arrayListOf(1, 1, 5, 6, 1, 2, 4, 3, 2)
    val TListToSet = TList.toSet()
    println(TListToSet)

    //Set
    //1.	Создать множество из чисел и вывести его.
    val SetOfNums: MutableSet<Int> = mutableSetOf(-1, 2, 3, 18, 10, 15)
    println(SetOfNums)

    //2.	Добавить в множество повторяющиеся элементы и проверить результат.
    SetOfNums.add(-1)
    SetOfNums.add(2)
    SetOfNums.add(3)
    SetOfNums.add(10)
    println(SetOfNums)

    //3.	Найти пересечение двух множеств.
    val TSetOfNums: MutableSet<Int> = mutableSetOf(-1, 19, 50, 40, 3, 20, 99)
    val common = SetOfNums.intersect(TSetOfNums)
    println(common)

    //4.	Найти объединение двух множеств.
    val UnSets = SetOfNums.union(TSetOfNums)
    println(UnSets)

    //5.	Найти разность двух множеств.
    val SubsSets = SetOfNums.subtract(TSetOfNums)
    println(SubsSets)
    //6.	Проверить, содержится ли элемент в множестве.
    val FindElement = SetOfNums.find { it == -1 }
    println(FindElement)
    //7.	Подсчитать количество уникальных символов в строке.
    val TestStr: String = "leetcode"
    val UniqChars = TestStr.toSet().size
    println(UniqChars)
    //8.	Преобразовать список в множество для удаления дубликатов.
    val ListOfDupl = listOf("java", "java", "kotlin", "swift", "rust")
    val LstToSet = ListOfDupl.toSet()
    println(LstToSet)
    //9.	Найти симметрическую разность двух множеств.
    val ASet = setOf(3, 2, 1, 5)
    val BSet = setOf(3, 5, 7, 10)
    val SymDiff = (ASet - BSet) + (BSet - ASet)
    println(SymDiff)
    //10.	Создать множество строк и проверить, есть ли там слово "Kotlin".
    val ListOfSmth = setOf("java", "kotlin", "swift", "rust")
    val FindKotln = "Kotlin" in ListOfSmth
    println(FindKotln)
}


