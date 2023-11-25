package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.Constants.MAXIMUM_RANDOM_NUMBER
import racingcar.util.Constants.MINIMUM_MOVE_NUMBER
import racingcar.util.Constants.MINIMUM_RANDOM_NUMBER

class RacingCar(private val name: String) {
    private var numberOfStep = 0

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER)
    }

    fun judgeMoveOrStop() {
        if (generateRandomNumber() >= MINIMUM_MOVE_NUMBER) {
            numberOfStep += 1
        }
    }

    override fun toString(): String {
        return "$name : ${STEP.repeat(numberOfStep)}"
    }

    companion object {
        private const val STEP = "-"
    }
}