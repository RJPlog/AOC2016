// 03.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-
// 10.10.2020 rearange for year 2016'5th day


import java.io.File
import kotlin.math.*
import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
	val md = MessageDigest.getInstance("MD5")
	return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun main(args: Array<String>) {

// part 1

	var input2: String
	var door_id: String = "ugkcyxxp"
//	var door_id: String = "abc"
	var md5 = door_id.md5()
	var md5_short: String
	var count: Int = 0
	var passwd: String = ""
	var passwdcut: String

// part 2
	var passwd2: String = "--------"
	var index: Int
	var finish: Boolean = false

    while(!finish) { 
//	for (i in 0..10) {
		do {
			input2 = door_id + count.toString()
			count = count.toInt() + 1
			md5 = input2.md5()
			md5_short = md5.substring(0, 5)

		} while (!md5_short.equals("00000"))

		// part 1
		passwd = passwd + md5[5]
//		println(" Passwd: $passwd with MD5 $md5, md5[5] ist ${md5[5].toInt()}")

		// part 2

		if (md5[5].equals('0') || md5[5].equals('1') || md5[5].equals('2') || md5[5].equals('3') || md5[5].equals('4') || md5[5].equals('5') ||md5[5].equals('6') ||md5[5].equals('7') ) {
			index = md5[5].toInt()-48
		if (passwd2[index].equals('-')) {
				passwd2 = passwd2.replaceRange(index,index+1,  md5[6].toString())
				println(" Passwd: $passwd2")
			} 
		}
		if (!passwd2.contains("-")) {finish = true}
	}

	println()
	println("******************")
	println("Solution for part1")
	passwdcut = passwd[0].toString() + passwd[1] + passwd[2] +passwd[3] +passwd[4] + passwd[5] + passwd[6] +passwd[7]
	println("   The passwd is $passwdcut")

	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("   The passwd for 2nd door is $passwd2")
	println()
	
}