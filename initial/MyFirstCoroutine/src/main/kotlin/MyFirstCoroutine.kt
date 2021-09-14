import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Shared State example.
var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        bigRun()
    }
    logMessage("Counter = $counter")
}


suspend fun bigRun() {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { counter++ }
                }
            }
        }
    }
    logMessage("Completed ${n * k} actions in $time ms")
}


fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}


// Please scroll down to try the other examples...


/*
// Volatile example
@Volatile
var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        bigRun()
    }
    logMessage("Counter = $counter")
}


suspend fun bigRun() {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { counter++ }
                }
            }
        }
    }
    logMessage("Completed ${n * k} actions in $time ms")
}



fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}

*/

/*
// AtomicInt example
var counter = AtomicInteger()

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        bigRun()
    }
    logMessage("Counter = $counter")
}


suspend fun bigRun() {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) {
                        counter.incrementAndGet()
                    }
                }
            }
        }
    }
    logMessage("Completed ${n * k} actions in $time ms")
}


fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}

*/

/*
// newSingleThreadContext example.1
val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        bigRun()
    }
    logMessage("Counter = $counter")
}


suspend fun bigRun() {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) {
                        withContext(counterContext) {
                            counter++
                        }
                    }
                }
            }
        }
    }
    logMessage("Completed ${n * k} actions in $time ms")
}


fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}

*/

/*
// newSingleThreadContext example.2
val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

fun main() = runBlocking {
    withContext(counterContext) {
        bigRun()
    }
    logMessage("Counter = $counter")
}


suspend fun bigRun() {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) {
                        counter++
                    }
                }
            }
        }
    }
    logMessage("Completed ${n * k} actions in $time ms")
}


fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}

*/

/*
// Mutex Example
val mutex = Mutex()
var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        bigRun()
    }
    logMessage("Counter = $counter")
}


suspend fun bigRun() {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) {
                        mutex.withLock {
                            counter++
                        }
                    }
                }
            }
        }
    }
    logMessage("Completed ${n * k} actions in $time ms")
}


fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}

*/
