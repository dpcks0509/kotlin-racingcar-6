package racingcar.model

class Winner {
    private val names = mutableListOf<String>()

    private fun getMaximumNumberOfStep(racingCars: List<RacingCar>): Int {
        return racingCars.maxOf { racingCar ->
            racingCar.getNumberOfStep()
        }
    }

    fun judgeWinner(racingCars: List<RacingCar>) {
        val maximumNumberOfStep = getMaximumNumberOfStep(racingCars)
        val winners = racingCars.filter { racingCar ->
            racingCar.getNumberOfStep() == maximumNumberOfStep
        }

        names.addAll(winners.map { winner -> winner.getName() })
    }

    override fun toString(): String {
        return "최종 우승자 : ${names.joinToString(", ")}"
    }
}