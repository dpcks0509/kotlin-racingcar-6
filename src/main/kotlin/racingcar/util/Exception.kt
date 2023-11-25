package racingcar.util

enum class Exception(private val message: String) {
    INVALID_RACING_CAR_NAME_FORMAT("자동차 이름에 공백이 없어야 한다."),
    INVALID_RACING_CAR_NAME_RANGE("자동차 이름은 5자 이하만 가능하다."),
    INVALID_RACING_CAR_NAME_NOT_EMPTY("자동차 이름이 입력되지 않았다."),
    INVALID_RACING_CAR_NAME_NO_DUPLICATE("자동차 이름은 중복이 불가능하다.");

    fun getMessage() = "[ERROR] $message"
}