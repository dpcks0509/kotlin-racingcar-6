package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator.validateNumberOfAttempts
import racingcar.util.Validator.validateRacingCarNames

class InputView {
    fun readRacingCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val racingCarNames = Console.readLine()
        return validateRacingCarNames(racingCarNames)
    }

    fun readNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val numberOfAttempts = Console.readLine()
        return validateNumberOfAttempts(numberOfAttempts)
    }
}