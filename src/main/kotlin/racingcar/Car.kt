package racingcar

data class Car(val name: String, var numberOfMove: Int = 0) {
    fun moveForward() {
        this.numberOfMove += 1
    }
}