package racingcar.controller

import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val racingCars = makeRacingCars(inputView.readRacingCarNames())
        val numberOfAttempts = inputView.readNumberOfAttempts()
        for (i in 0 until numberOfAttempts) {
            racingCars.forEach { racingCar ->
                racingCar.judgeMoveOrStop()
            }
        }
    }

    private fun makeRacingCars(racingCarNames: List<String>): List<RacingCar> {
        val racingCars = mutableListOf<RacingCar>()
        racingCarNames.forEach { racingCarName ->
            racingCars.add(RacingCar(racingCarName))
        }
        return racingCars
    }
}