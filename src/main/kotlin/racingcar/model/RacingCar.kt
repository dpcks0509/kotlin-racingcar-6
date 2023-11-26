package racingcar.model

import racingcar.util.Constants.MINIMUM_MOVE_NUMBER

class RacingCar(private val name: String) {
    private var numberOfStep = 0

    fun judgeMoveOrStop(randomNumber: Int) {
        if (randomNumber >= MINIMUM_MOVE_NUMBER) {
            numberOfStep += 1
        }
    }

    fun getName() = name

    fun getNumberOfStep() = numberOfStep

    override fun toString(): String {
        return "$name : ${STEP.repeat(numberOfStep)}"
    }

    companion object {
        private const val STEP = "-"
    }
}