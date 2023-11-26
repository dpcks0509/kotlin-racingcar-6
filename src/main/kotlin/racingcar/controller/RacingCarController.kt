package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.model.Winner
import racingcar.util.Constants
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val racingCars = makeRacingCars(inputView.readRacingCarNames())
        val numberOfAttempts = inputView.readNumberOfAttempts()

        getAttemptsResult(racingCars, numberOfAttempts)

        getWinner(racingCars)
    }

    private fun makeRacingCars(racingCarNames: List<String>): List<RacingCar> {
        val racingCars = mutableListOf<RacingCar>()
        racingCarNames.forEach { racingCarName ->
            racingCars.add(RacingCar(racingCarName))
        }
        return racingCars
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(Constants.MINIMUM_RANDOM_NUMBER, Constants.MAXIMUM_RANDOM_NUMBER)
    }

    private fun getAttemptsResult(racingCars: List<RacingCar>, numberOfAttempts: Int) {
        outputView.printAttemptsResultHeader()
        for (i in 0 until numberOfAttempts) {
            racingCars.forEach { racingCar ->
                racingCar.judgeMoveOrStop(generateRandomNumber())
            }
            outputView.printAttemptsResult(racingCars)
        }
    }

    private fun getWinner(racingCars: List<RacingCar>) {
        val winner = Winner()
        winner.judgeWinner(racingCars)

        outputView.printWinner(winner)
    }
}