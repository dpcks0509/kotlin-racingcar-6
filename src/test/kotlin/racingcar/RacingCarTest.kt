package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.RacingCar
import racingcar.model.Winner
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

    @Test
    fun `자동차 전진`() {
        val racingCar = RacingCar("pobi")
        val expectNumberOfStep = 1

        racingCar.judgeMoveOrStop(4)
        val actualNumberOfStep = racingCar.getNumberOfStep()

        assertThat(actualNumberOfStep).isEqualTo(expectNumberOfStep)
    }

    @Test
    fun `자동차 정지`() {
        val racingCar = RacingCar("pobi")
        val expectNumberOfStep = 0

        racingCar.judgeMoveOrStop(3)
        val actualNumberOfStep = racingCar.getNumberOfStep()

        assertThat(actualNumberOfStep).isEqualTo(expectNumberOfStep)
    }

    @Test
    fun `최종 우승자 1명`() {
        val pobi = RacingCar("pobi")
        val woni = RacingCar("woni")
        val racingCars = listOf(pobi, woni)
        val winner = Winner()
        val expectWinner = "최종 우승자 : pobi"

        pobi.judgeMoveOrStop(4)
        woni.judgeMoveOrStop(3)
        winner.judgeWinner(racingCars)
        val actualWinner = winner.toString()

        assertThat(actualWinner).isEqualTo(expectWinner)
    }

    @Test
    fun `최종 우승자 여러명`() {
        val pobi = RacingCar("pobi")
        val woni = RacingCar("woni")
        val racingCars = listOf(pobi, woni)
        val winner = Winner()
        val expectWinner = "최종 우승자 : pobi, woni"

        pobi.judgeMoveOrStop(4)
        woni.judgeMoveOrStop(4)
        winner.judgeWinner(racingCars)
        val actualWinner = winner.toString()

        assertThat(actualWinner).isEqualTo(expectWinner)
    }
}