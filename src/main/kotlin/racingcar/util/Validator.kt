package racingcar.util

object Validator {
    fun validateRacingCarNames(racingCarNames: String): List<String> {
        val validRacingCarNames = racingCarNames.split(",")
        validRacingCarNames.forEach { racingCarName ->
            validateRacingCarNameFormat(racingCarName)
            validateRacingCarNameRange(racingCarName)
            validateRacingCarNameNotEmpty(racingCarName)
        }
        validateRacingCarNamesNoDuplicate(validRacingCarNames)
        return validRacingCarNames
    }

    private fun validateRacingCarNameFormat(racingCarName: String) {
        require(!racingCarName.contains(" ")) { Exception.INVALID_RACING_CAR_NAME_FORMAT.getMessage() }
    }

    private fun validateRacingCarNameRange(racingCarName: String) {
        require(racingCarName.length <= 5) { Exception.INVALID_RACING_CAR_NAME_RANGE.getMessage() }
    }

    private fun validateRacingCarNameNotEmpty(racingCarName: String) {
        require(racingCarName.isNotEmpty()) { Exception.INVALID_RACING_CAR_NAME_NOT_EMPTY.getMessage() }
    }

    private fun validateRacingCarNamesNoDuplicate(racingCarNames: List<String>) {
        require(racingCarNames.size == racingCarNames.toSet().size) { Exception.INVALID_RACING_CAR_NAME_NO_DUPLICATE.getMessage() }
    }
}