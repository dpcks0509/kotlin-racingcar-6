package racingcar

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.util.Validator.validateRacingCarNames

class RacingCarTest {
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
}