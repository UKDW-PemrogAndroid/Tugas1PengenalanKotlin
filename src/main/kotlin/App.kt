fun main(args: Array<String>) {
    val angelBRI: DigitalPayment = BRImo("Angel", 5000000, "250071190490")
    val felixBNI: DigitalPayment = BNImo("Felix", 2500000, "250071190494")
    val joyceBRI: DigitalPayment = BRImo("Joyce", 1500000, "250071190495")
    val oliveDana: DigitalPayment = Dana("Olive", 0, "081234567891")
    val adrianOvo: DigitalPayment = Ovo("Adrian", 150000, "081578961543")
    val nolaDana: DigitalPayment = Dana("Nola", 550000, "081734566789")

    println("----------Skenario 1: Input Tidak Valid----------")
    joyceBRI.transfer(nolaDana,-150000)
    nolaDana.transfer(oliveDana,-100000)
    println("----------Skenario 2: Saldo Tidak Mencukupi----------")
    joyceBRI.transfer(oliveDana,2000000)
    nolaDana.transfer(oliveDana,1555000)
    println("----------Skenario 3: Transfer Sesama Bank----------")
    angelBRI.transfer(joyceBRI,200000)
    println("----------Skenario 4: Transfer Beda Bank----------")
    angelBRI.transfer(felixBNI,300000)
    println("----------Skenario 5: Bank Transfer ke e-Wallet----------")
    angelBRI.transfer(oliveDana,1000000)
    println("----------Skenario 6: OVO Transfer ke Bank----------")
    adrianOvo.transfer(felixBNI,100000)
    println("----------Skenario 7: DANA transfer ke Bank----------")
    nolaDana.transfer(angelBRI,100000)
    println("----------Skenario 8: Dana transfer ke Dana----------")
    oliveDana.transfer(nolaDana,150000)
    println("----------Skenario 9: Dana transfer ke OVO----------")
    oliveDana.transfer(adrianOvo,10000)
    println("----------Skenario 10: Saldo Akhir----------")
    printSaldo(angelBRI)
    printSaldo(felixBNI)
    printSaldo(joyceBRI)
    printSaldo(oliveDana)
    printSaldo(adrianOvo)
    printSaldo(nolaDana)
}

fun printSaldo(dp: DigitalPayment) {
    println("=====Rincian Saldo=====")
    println("Nama\t\t: " + dp.nama)
    if (dp is BNImo || dp is BRImo) {
        System.out.println("No. Rekening: " + (dp as MobileBanking).noRekening)
    } else if (dp is Dana || dp is Ovo) {
        println("No. HP\t\t: " + (dp as MobileWallet).noHp)
    }
    println("===> Saldo\t: Rp " + dp.saldo)
}