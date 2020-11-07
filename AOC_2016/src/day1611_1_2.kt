// 11.10.2020

import java.io.File
import kotlin.math.*


fun main(args: Array<String>) {

// Testpattern aus Beispiel
//	var SingleTurn: String = "1=01010000000000=10000000000000=00100000000000=00000000000000"  
//	var GameEndString: String = "11110000000000"
	
// Input aus Part1	
//	var SingleTurn: String = "1=11101000000000=00010100000000=00000011110000=00000000000000"  
//	var GameEndString: String = "11111111110000"
	
	// Input aus Part2"
	var SingleTurn: String = "1=11101000001111=00010100000000=00000011110000=00000000000000"  
	var GameEndString: String = "11111111111111"
	
	var AllTurns =
		mutableMapOf<String, Int>()                                  // Enthält alle Spielzüge und die notwendigen minimalen Spielzüge dorthin
	var CurrentTurn: Int = 0
	var GameEnd = false
	var GameEndCurrentTurn: Int = 0

	// initialisiere die Map mit den Spielzügen
	AllTurns.put(SingleTurn, CurrentTurn)

	println("Spielstart mit folgendem Ausgangszustand:")
	println(AllTurns)
	println()

	// erzeuge die Patterns für die nächsten Spielzüge
	var listA = Patterns()

	println("Patterns für mögliche Moves")
	//println(listA)
	println(listA.size)
	println()


// mache den nächsten Zug, ausgehend von allen aktuellen, bis der Zielzustand erreicht ist	(Abbruchbedingung)
//	for (i in 0..9) {
	while (!GameEnd) {
		// filtere AllTurns nach aktuellen Spielzügen
		var filteredAllTurns = AllTurns.filterValues { it == CurrentTurn }
		CurrentTurn = CurrentTurn + 1
		
		println("CurrentTurn $CurrentTurn")
		println()

		// Berechne für alle Spielzüge den nächsten möglichen
		filteredAllTurns.forEach {
			// Zerlege Spielzug
			var instruction = it.key.split("=")
			var Lift = instruction[0].toInt()
			var floor1 = instruction[1]
			var floor2 = instruction[2]
			var floor3 = instruction[3]
			var floor4 = instruction[4]
//			println("Lift = ${Lift.toInt()}")
			// Wenn Lift < 4 berechne Spielzüge nach oben

			if (Lift == 1) {  // nach oben
				// für alle erlaubten 2er tupples
				listA.forEach {
					floor1 = instruction[1]
					floor2 = instruction[2]
					floor3 = instruction[3]
					floor4 = instruction[4]
					if (it.toInt(2) and instruction[Lift].toInt(2) == it.toInt(2)) {  // prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
						// berechne neuen aktuellen floor (ziehe Muster ab) !Muster and STring
						floor1 = (it.toInt(2).inv() and floor1.toInt(2)).toString(2).padStart(14, '0')
						// berechne neuen höheren floor (addiere Muster) Muster or String
						floor2 = (it.toInt(2) or floor2.toInt(2)).toString(2).padStart(14, '0')
						// falls beide gültig sind, speichere Spielzug ab
						if (ValidFloor(floor1) && ValidFloor(floor2)) {
							if (!AllTurns.containsKey((Lift + 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4)) {
								AllTurns.put(
									(Lift + 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4,
									CurrentTurn
								)
							}
						}
						// falls Zielzustand setze Abbruchbedingung
					}  // END prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
				} // End listA.forEach
			} // End if (Lift == 1) {

			if (Lift == 2) {   // 2 nach oben
				// für alle erlaubten 2er tupples
				listA.forEach {
					floor1 = instruction[1]
					floor2 = instruction[2]
					floor3 = instruction[3]
					floor4 = instruction[4]
					if (it.toInt(2) and instruction[Lift].toInt(2) == it.toInt(2)) {  // prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
						// berechne neuen aktuellen floor (ziehe Muster ab) !Muster and STring
						floor2 = (it.toInt(2).inv() and floor2.toInt(2)).toString(2).padStart(14, '0')
						// berechne neuen höheren floor (addiere Muster) Muster or String
						floor3 = (it.toInt(2) or floor3.toInt(2)).toString(2).padStart(14, '0')
						// falls beide gültig sind, speichere Spielzug ab
						if (ValidFloor(floor2) && ValidFloor(floor3)) {
							if (!AllTurns.containsKey((Lift + 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4)) {
								AllTurns.put(
									(Lift + 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4,
									CurrentTurn
								)
							}
						}
						// falls Zielzustand setze Abbruchbedingung
					}  // END prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
				} // End listA.forEach
			} // End if (Lift == 1) {


			if (Lift == 2) {   // 2 nach unten
				// für alle erlaubten 2er tupples
				listA.forEach {
					floor1 = instruction[1]
					floor2 = instruction[2]
					floor3 = instruction[3]
					floor4 = instruction[4]
					if (it.toInt(2) and instruction[Lift].toInt(2) == it.toInt(2)) {  // prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
						// berechne neuen aktuellen floor (ziehe Muster ab) !Muster and STring
						floor2 = (it.toInt(2).inv() and floor2.toInt(2)).toString(2).padStart(14, '0')
						// berechne neuen höheren floor (addiere Muster) Muster or String
						floor1 = (it.toInt(2) or floor1.toInt(2)).toString(2).padStart(14, '0')
						// falls beide gültig sind, speichere Spielzug ab
						if (ValidFloor(floor2) && ValidFloor(floor1)) {
							if (!AllTurns.containsKey((Lift - 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4)) {
								AllTurns.put(
									(Lift - 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4,
									CurrentTurn
								)
							}
						}
						// falls Zielzustand setze Abbruchbedingung
					}  // END prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
				} // End listA.forEach
			} // End if (Lift == 1) {

			if (Lift == 3) { // nach oben
				// für alle erlaubten 2er tupples
				listA.forEach {
					floor1 = instruction[1]
					floor2 = instruction[2]
					floor3 = instruction[3]
					floor4 = instruction[4]
					if (it.toInt(2) and instruction[Lift].toInt(2) == it.toInt(2)) {  // prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
						// berechne neuen aktuellen floor (ziehe Muster ab) !Muster and STring
						floor3 = (it.toInt(2).inv() and floor3.toInt(2)).toString(2).padStart(14, '0')
						// berechne neuen höheren floor (addiere Muster) Muster or String
						floor4 = (it.toInt(2) or floor4.toInt(2)).toString(2).padStart(14, '0')
						if (floor4 ==  GameEndString) {//          "11111111111111"  "11111111110000"   "11110000000000"
							GameEnd = true
							GameEndCurrentTurn = CurrentTurn
						}
						// falls beide gültig sind, speichere Spielzug ab
						if (!AllTurns.containsKey((Lift + 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4)) {
							if (ValidFloor(floor3) && ValidFloor(floor4)) {
								AllTurns.put(
									(Lift + 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4,
									CurrentTurn
								)
							}
						}
						// falls Zielzustand setze Abbruchbedingung
					}  // END prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
				} // End listA.forEach
			} // End if (Lift == 1) {

			if (Lift == 3) {  // nach unten
				// für alle erlaubten 2er tupples
				listA.forEach {
					floor1 = instruction[1]
					floor2 = instruction[2]
					floor3 = instruction[3]
					floor4 = instruction[4]
					if (it.toInt(2) and instruction[Lift].toInt(2) == it.toInt(2)) {  // prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
						// berechne neuen aktuellen floor (ziehe Muster ab) !Muster and STring
						floor3 = (it.toInt(2).inv() and floor3.toInt(2)).toString(2).padStart(14, '0')
						// berechne neuen höheren floor (addiere Muster) Muster or String
						floor2 = (it.toInt(2) or floor2.toInt(2)).toString(2).padStart(14, '0')
						// falls beide gültig sind, speichere Spielzug ab
						if (!AllTurns.containsKey((Lift - 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4)) {
							if (ValidFloor(floor3) && ValidFloor(floor2)) {
								AllTurns.put(
									(Lift - 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4,
									CurrentTurn
								)
							}
						}
						// falls Zielzustand setze Abbruchbedingung
					}  // END prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
				} // End listA.forEach
			} // End if (Lift == 1) {

			if (Lift == 4) {  // nach unten
				// für alle erlaubten 2er tupples
				listA.forEach {
					floor1 = instruction[1]
					floor2 = instruction[2]
					floor3 = instruction[3]
					floor4 = instruction[4]
					if (it.toInt(2) and instruction[Lift].toInt(2) == it.toInt(2)) {  // prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
						// berechne neuen aktuellen floor (ziehe Muster ab) !Muster and STring
						floor4 = (it.toInt(2).inv() and floor4.toInt(2)).toString(2).padStart(14, '0')
						// berechne neuen höheren floor (addiere Muster) Muster or String
						floor3 = (it.toInt(2) or floor3.toInt(2)).toString(2).padStart(14, '0')
						// falls beide gültig sind, speichere Spielzug ab
						if (!AllTurns.containsKey((Lift - 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4)) {
							if (ValidFloor(floor3) && ValidFloor(floor4)) {
								AllTurns.put(
									(Lift - 1).toString() + "=" + floor1 + "=" + floor2 + "=" + floor3 + "=" + floor4,
									CurrentTurn
								)
							}
						}
						// falls Zielzustand setze Abbruchbedingung
					}  // END prüfe ob Muster im aktuellen Floor enthalten ist  (if(Muster and String == Muster)
				} // End listA.forEach
			} // End if (Lift == 1) {
		} // Ende Berechne für alle Spielzüge den nächsten möglichen
	}    // End mache den nächsten Zug, ausgehend von allen aktuellen, bis der Zielzustand erreicht ist

/*	AllTurns.forEach {
		var printinstruction = it.key.split("=")
		var printLift = printinstruction[0].toInt()
		var printfloor1 = printinstruction[1]
		var printfloor2 = printinstruction[2]
		var printfloor3 = printinstruction[3]
		var printfloor4 = printinstruction[4]

		println("Spielzug: ${it.value}")
		println("   $printfloor4")
		println("   $printfloor3")
		println("   $printfloor2")
		println("   $printfloor1")
		println("    Lift : $printLift")
		println()
	} */

	// Ausgabe der Lösung für Part 1

	//  Lösung 1: 38 und 39 sind falsch
	// Lösung 2: 31 ist falsch
	println()
	println("******************")
	println("Solution for part1")
	println("   The minimum number of steps is $GameEndCurrentTurn")
	println()

}


// Funktion ermittelt, ob ein Zustand auf dem Floor zulässig ist oder nicht
fun ValidFloor(State: String): Boolean {
	var Valid: Boolean = true
	if (State[0].equals('0') && State[1].equals('1') && (State[2].equals('1') || State[4].equals('1') || State[6].equals(
			'1'
		) || State[8].equals('1') || State[10].equals(
			'1'
		) || State[12].equals('1'))
	) {
		Valid = false
	}
	if (State[2].equals('0') && State[3].equals('1') && (State[0].equals('1') || State[4].equals('1') || State[6].equals(
			'1'
		) || State[8].equals('1') || State[10].equals(
			'1'
		) || State[12].equals('1'))
	) {
		Valid = false
	}
	if (State[4].equals('0') && State[5].equals('1') && (State[0].equals('1') || State[2].equals('1') || State[6].equals(
			'1'
		) || State[8].equals('1') || State[10].equals(
			'1'
		) || State[12].equals('1'))
	) {
		Valid = false
	}
	if (State[6].equals('0') && State[7].equals('1') && (State[0].equals('1') || State[2].equals('1') || State[4].equals(
			'1'
		) || State[8].equals('1') || State[10].equals(
			'1'
		) || State[12].equals('1'))
	) {
		Valid = false
	}
	if (State[8].equals('0') && State[9].equals('1') && (State[0].equals('1') || State[2].equals('1') || State[4].equals(
			'1'
		) || State[6].equals('1') || State[10].equals(
			'1'
		) || State[12].equals('1'))
	) {
		Valid = false
	}
	if (State[10].equals('0') && State[11].equals('1') && (State[0].equals('1') || State[2].equals('1') || State[4].equals(
			'1'
		) || State[6].equals('1') || State[8].equals(
			'1'
		) || State[12].equals('1'))
	) {
		Valid = false
	}
	if (State[12].equals('0') && State[13].equals('1') && (State[0].equals('1') || State[2].equals('1') || State[4].equals(
			'1'
		) || State[6].equals('1') || State[8].equals(
			'1'
		) || State[10].equals('1'))
	) {
		Valid = false
	}
	return Valid
}

// Funktion ermittelt alle möglichen Kombinationen, die mittels Lift erlaubt sind
fun Patterns(): List<String> {
	var pattern = mutableListOf<String>()
	for (TG in 0..1) {
		for (TM in 0..1) {
			for (PlG in 0..1) {
				for (PlM in 0..1) {
					for (SG in 0..1) {
						for (SM in 0..1) {
							for (PrG in 0..1) {
								for (PrM in 0..1) {
									for (RG in 0..1) {
										for (RM in 0..1) {
											for (EG in 0..1) {
												for (EM in 0..1) {
													for (DG in 0..1) {
														for (DM in 0..1) {
															if (((TG + TM + PlG + PlM + SG + SM + PrG + PrM + RG + RM+ EG + EM + DG +DM) == 1) || ((TG + TM + PlG + PlM + SG + SM + PrG + PrM + RG + RM+ EG + EM + DG +DM) == 2)) {
																pattern.add(TG.toString() + TM.toString() + PlG.toString() + PlM.toString() + SG.toString() + SM.toString() + PrG.toString() + PrM.toString() + RG.toString() + RM.toString()+ EG.toString() + EM.toString() + DG.toString() + DM.toString())
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	return pattern
}