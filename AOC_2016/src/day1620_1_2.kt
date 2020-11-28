import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {

	var blockedIP = mutableMapOf<Long, Long>()
	var EndReached: Boolean = false
	var i: Int = 0
	var key: Long
	var value: Long
	var keynext: Long
	var valuenext: Long

// lese Input ein
	File("day1620_puzzle_input.txt").forEachLine {
		var instruction = it.split("-")
		blockedIP.put(instruction[0].toLong(), instruction[1].toLong())
	}

// sortiere Input
	var sortedIP = blockedIP.toSortedMap()

// Ereuge Liste aus Keys um index zu ermiteln
	var IPList: List<Long> = sortedIP.keys.toList()

	println(blockedIP.size)

	for (j in 0..6) {
		while (!EndReached) {
			key = IPList[i]
			value = blockedIP.getValue(IPList[i])
			keynext = IPList[i+1]
			valuenext = blockedIP.getValue(IPList[i+1])
						
			if (keynext <= value + 1 && value <= valuenext) {
				blockedIP.put(key, valuenext)
				blockedIP.keys.remove(keynext)
				i = i + 2
			} else if (keynext <= value + 1 && value > valuenext){
				blockedIP.put(key, value)
				blockedIP.keys.remove(keynext)
				i = i + 2			
			}else {
				i = i + 1
			}
			if (i > IPList.size - 2) {
				EndReached = true
			}

		}
		println(" after Red: ${blockedIP.size}")
		i = 0
		EndReached = false
		sortedIP = blockedIP.toSortedMap()

		IPList = sortedIP.keys.toList()
	}
	
	sortedIP.forEach {
		println(it)
	}
	
	println()
	println(sortedIP.size)
	println(IPList.size)

	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("  the lowest valued IP is   ${blockedIP.getValue(0)+1}  ")
	println()

	// part 2
	
	var IPcount: Int = 0
	
	for(i in 0.. IPList.size-2) {
		
			key = IPList[i]
			value = blockedIP.getValue(IPList[i])
			keynext = IPList[i+1]
			valuenext = blockedIP.getValue(IPList[i+1])
		println("Key-Value:         $key - $value")
		println("Keynext-Valuenext: $keynext - $valuenext")		
		IPcount = IPcount +(keynext - (value+1)).toInt()	
		println("   $IPcount")
		println()
	}
	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("   ${IPcount} IP numbers are allowed ")
	println()  
}