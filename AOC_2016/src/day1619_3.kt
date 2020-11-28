import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {

	var ElvesRound = mutableMapOf<Int, Int>()
	var LastTurn: Boolean = false
	var Hilf1: Int
	var Hilf2: Int = 0
	val NumOfElves: Int =  3004953
	var RemNumElves: Int
	var ElvesTurnIndex: Int = 0
	var KeyNext: Int = 1



	for (i in 1..NumOfElves) {
		ElvesRound.put(i, 1)
	}

	while (!LastTurn) {
//for(k in 0..3 ) { 
		RemNumElves = ElvesRound.size

		var KeysList: List<Int> = ElvesRound.keys.toList()
		if (ElvesTurnIndex % 1000 == 0) {
		println("Spielzug ${ElvesTurnIndex}") //,  ${ElvesRound.size} an Bord, KeyNext: $KeyNext")
		}
		Hilf2 = KeysList.indexOf(KeyNext)//	Hilf2 = (ElvesTurnIndex) % (RemNumElves)   // 
		Hilf1 = (RemNumElves / 2 + (Hilf2)) % RemNumElves


		KeyNext = KeysList[(Hilf2 + 1) % RemNumElves]
		if (KeyNext == KeysList[Hilf1]) {
			KeyNext = KeysList[(Hilf2 + 2) % RemNumElves]
		}
		// Funtioniert nicht mehr, wenn KeyNext auch gestrichen wird!


//		println("    Hilf2 (Index Spieler holt Geschenk) $Hilf2, Hilf1 (von) $Hilf1")
//		println("   Es spielen $RemNumElves Elven, an der Reihe ist ${KeysList[Hilf2]}, er holt sich die Geschenke von ${KeysList[Hilf1]}")
//		ElvesRound.put(KeysList[Hilf2],ElvesRound.getValue(KeysList[Hilf2]) + ElvesRound.getValue(KeysList[Hilf1]))
		ElvesRound.keys.remove(KeysList[Hilf1])


//		println("   Die Elvenrunde sieht jetzt so aus: $ElvesRound")

		ElvesTurnIndex = ElvesTurnIndex + 1
//if (ElvesTurnIndex > RemNumElves -1 ) {ElvesTurnIndex = 0}

		if (RemNumElves == 2) {
			LastTurn = true
		}
//		println("   LastTurn $LastTurn")
	}


// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("    Elve nr. ${ElvesRound.keys}  ")
	println()


}