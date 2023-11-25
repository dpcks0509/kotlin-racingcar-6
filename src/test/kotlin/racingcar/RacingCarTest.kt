package racingcar

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.util.Validator.validateNumberOfAttempts
import racingcar.util.Validator.validateRacingCarNames

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni", "pobi,woni,jun"])
    fun `올바른 자동차 이름 입력`(racingCarNames: String) {
        assertDoesNotThrow { validateRacingCarNames(racingCarNames) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi, woni", "pobi,woni "])
    fun `자동차 이름 입력 예외처리 (자동차 이름에 공백이 없어야 한다)`(racingCarNames: String) {
        assertThrows<IllegalArgumentException> { validateRacingCarNames(racingCarNames) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobibic,woni", "pobi,woniso"])
    fun `자동차 이름 입력 예외처리 (자동차 이름은 5자 이하만 가능하다)`(racingCarNames: String) {
        assertThrows<IllegalArgumentException> { validateRacingCarNames(racingCarNames) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,,woni", ",pobi,woni"])
    fun `자동차 이름 입력 예외처리 (자동차 이름이 입력되지 않았다)`(racingCarNames: String) {
        assertThrows<IllegalArgumentException> { validateRacingCarNames(racingCarNames) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni,pobi", "pobi,pobi"])
    fun `자동차 이름 입력 예외처리 (자동차 이름은 중복이 불가능하다)`(racingCarNames: String) {
        assertThrows<IllegalArgumentException> { validateRacingCarNames(racingCarNames) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "3", "5"])
    fun `올바른 시도할 횟수 입력 입력`(numberOfAttempts: String) {
        assertDoesNotThrow { validateNumberOfAttempts(numberOfAttempts) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one", " 1", "1 "])
    fun `시도할 횟수 입력 예외처리 (시도할 횟수는 문자나 공백이 없어야한다)`(numberOfAttempts: String) {
        assertThrows<IllegalArgumentException> { validateNumberOfAttempts(numberOfAttempts) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0"])
    fun `시도할 횟수 입력 예외처리 (시도할 횟수는 1이상의 숫자여야 한다)`(numberOfAttempts: String) {
        assertThrows<IllegalArgumentException> { validateNumberOfAttempts(numberOfAttempts) }
    }
}