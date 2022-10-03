package com.example.budgetskoj

object DataManager {
    var utgiftLista = mutableListOf<Utgift>()


    init {
        createMockData()
    }

    fun createMockData (){
        utgiftLista.add(Utgift("Hyra",4300))
        utgiftLista.add(Utgift("El(E.on",900))
        utgiftLista.add(Utgift("El skatt",370))
        utgiftLista.add(Utgift("Mat",3000))
        utgiftLista.add(Utgift("Pepsi",600))
    }
}