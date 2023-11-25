package racingcar.util

import racingcar.util.Constants.MINIMUM_NUMBER_OF_ATTEMPTS
import racingcar.util.Constants.MAXIMUM_RACING_CAR_NAME_LENGTH

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
        require(racingCarName.length <= MAXIMUM_RACING_CAR_NAME_LENGTH) { Exception.INVALID_RACING_CAR_NAME_RANGE.getMessage() }
    }

    private fun validateRacingCarNameNotEmpty(racingCarName: String) {
        require(racingCarName.isNotEmpty()) { Exception.INVALID_RACING_CAR_NAME_NOT_EMPTY.getMessage() }
    }

    private fun validateRacingCarNamesNoDuplicate(racingCarNames: List<String>) {
        require(racingCarNames.size == racingCarNames.toSet().size) { Exception.INVALID_RACING_CAR_NAME_NO_DUPLICATE.getMessage() }
    }

    fun validateNumberOfAttempts(numberOfAttempts: String): Int {
        validateNumberOfAttemptsFormat(numberOfAttempts)
        validateNumberOfAttemptsRange(numberOfAttempts)
        return numberOfAttempts.toInt()
    }

    private fun validateNumberOfAttemptsFormat(numberOfAttempts: String) {
        requireNotNull(numberOfAttempts.toIntOrNull()) { Exception.INVALID_NUMBER_OF_ATTEMPTS_FORMAT.getMessage() }
    }

    private fun validateNumberOfAttemptsRange(numberOfAttempts: String) {
        require(numberOfAttempts.toInt() >= MINIMUM_NUMBER_OF_ATTEMPTS) { Exception.INVALID_NUMBER_OF_ATTEMPTS_RANGE.getMessage() }
    }
}