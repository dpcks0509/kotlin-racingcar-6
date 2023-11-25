package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printAttemptsResultHeader() {
        println()
        println("실행 결과")
    }

    fun printAttemptsResult(racingCars: List<RacingCar>) {
        racingCars.forEach { racingCar ->
            println(racingCar)
        }
        println()
    }
}