package racingcar.model

class Winner {
    private val names = mutableListOf<String>()

    private fun getMaximumNumberOfStep(racingCars: List<RacingCar>): Int {
        return racingCars.maxOf { racingCar ->
            racingCar.getNumberOfStep()
        }
    }

    fun judgeWinners(racingCars: List<RacingCar>) {
        val maximumNumberOfStep = getMaximumNumberOfStep(racingCars)
        val winners = racingCars.filter { racingCar ->
            racingCar.getNumberOfStep() == maximumNumberOfStep
        }

        winners.forEach { winner ->
            names.add(winner.getName())
        }
    }

    override fun toString(): String {
        return names.joinToString(",")
    }
}