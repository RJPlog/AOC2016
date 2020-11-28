import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
	
var ElvesRound = mutableMapOf<Int, Int>()
var LastTurn: Boolean = false
var Hilf1 : Int
val NumOfElves: Int = 3004953
	
	
	
for(i in 1..NumOfElves){
	ElvesRound.put(i,1)
}

//	println("Erster Turn: $ElvesRound")	

	
		
while (!LastTurn) {	
	var KeysList: List<Int> = ElvesRound.keys.toList()
//	println("Keylist: $KeysList, KeyList[0]: ${KeysList[0]}")
    for(i in 0..KeysList.size-1) {
//		KeysList.forEach{
	if (ElvesRound.getValue(KeysList[i]) != 0 ) {
		if (i+1 > ElvesRound.size-1) {
			Hilf1 = KeysList[0]
		} else  {Hilf1 = KeysList[i+1]}
//		println("  i: $i, Hilf1: $Hilf1")
		ElvesRound.put(KeysList[i], ElvesRound.getValue(KeysList[i])+ElvesRound.getValue(Hilf1))
		ElvesRound.put(Hilf1, 0)
	
	} 
}
	
var filteredElvesRound = ElvesRound.filterValues {it != 0}
	
ElvesRound.clear()
filteredElvesRound.forEach {
//	println(" Inhalt: $it")
	val instruction = it.toString().split("=")
	ElvesRound.put(instruction[0].toInt(), instruction[1].toInt())
}	
	
	
//println("nächster Turn: $ElvesRound")
if (ElvesRound.size == 1) {LastTurn = true}
}	
	
// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    Elve nr. ${ElvesRound.keys}  ")
	println()


}