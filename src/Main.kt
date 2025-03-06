import java.io.File
import kotlin.math.absoluteValue

fun main() {    // main är main
    val data: List<String> = File("src/listOfNumbers.txt").readLines()      // Sigruns kod

    val leftList = mutableListOf<Int>()             //skapar två listor av Ints som ska användas senare
    val rightList = mutableListOf<Int>()            //mutable är så vi kan ända i dem har jag förmig

    fun getSumOfSortedList (nums: List<String>):Int {             // funktionen löser problem 1

        for (num in nums) {
            val listnum = num.split("   ".toRegex())   //behöver splita listan i 2
            leftList.add(listnum[0].toInt())            //toInt för att mate och Strings är svårt
            rightList.add(listnum[1].toInt())           // änu jobbigare för int listan att ta in Strings
        }
        leftList.sort()                                 // sorterar listan utanför för att den inte lätt mig göra det inuti loopen
        rightList.sort()                                //förmodligen för att man inte kan sortera medans man lägger in ints i listan eller något

        var sum = 0
        for (i in 0 until leftList.size) {                           // for loop tills en ifrån vänstralistan är upp nåd
            sum += (leftList[i] - rightList[i]).absoluteValue              //  += = (sum + leftList[i] - rightList[i]) där sum är 0
        }                                                                  // absoluteValue == absolute falskärm
        return sum
    }

    fun similarityScore (num: List<String>) {                               // löser problem 2
        for (nu in num) {                                                   // forloop som splitar listan i 2 som tidigare
            val litsnum = nu.split("   ".toRegex())
            leftList.add(litsnum[0].toInt())
            rightList.add(litsnum[1].toInt())

        }                                                                   // behöver inte sortas

        val frequenies = mutableMapOf<Int, Int>()                           // ändringsbar map av Int och Int
        for (i in rightList) {                                              // forloop
            if (frequenies.containsKey(i)) {                                // containsKey kollar om nyckeln i redan finns eller ej
                frequenies[i] = frequenies[i]!! + 1                         // uppdaterar värdet genom att lägga till +1
            }
            else {
                frequenies[i] = 1                                           // annars om vi inte hittar i i frequenies
            }
        }

        var math = 0
        for (i in leftList) {
            val frequenies = frequenies[i] ?: 0                             // hämtar frequenies för talet i ger 0 om talet inte finns
            math += i * frequenies                                          // mate
        }
        println(math)
    }

    println(getSumOfSortedList(data)) //print är print
    println(similarityScore(data))

    // på börjad 9 marsh 2025

    // avslutad 11 marsh 2025

    // dag 1 av AOT 2025 Historian_Hysteria

    // Todd Ginsberg gjorde detta väldigt mycket snyggare https://todd.ginsberg.com/post/advent-of-code/2024/day1/


    // fun solvePart1(): Int =
       //  parse(input).let { (left, right) ->
          //   left.sorted()
             //    .zip(right.sorted())
             //   .sumOf { (it.first - it.second).absoluteValue }
    //}

    //fun solvePart2(): Int =
      //  parse(input).let { (left, right) ->
        //    val frequencies = right.groupingBy { it }.eachCount()
          //  left.sumOf { it * frequencies.getOrDefault(it, 0) }
    // }

    // zip hade varit trevligt att veta om tidigare
    // zip fungerar som en dragkedja för att sätta i-hop två listor
}