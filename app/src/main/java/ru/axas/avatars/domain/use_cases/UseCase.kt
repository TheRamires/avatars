package ru.axas.avatars.domain.use_cases

import kotlinx.coroutines.*
import ru.axas.avatars.domain.type.Either
import ru.axas.avatars.domain.type.Failure
import kotlin.coroutines.CoroutineContext

abstract class UseCase<out Type, in Params> {
    var backgroundContext: CoroutineContext = Dispatchers.IO
    var foregroundContext: CoroutineContext = Dispatchers.Main

    private var parentJob: Job = Job()

    abstract suspend fun run(params: Params) : Either<Failure,Type>

    operator fun invoke(params: Params, onResult: (Either<Failure,Type>)-> Unit={}){
        unsubscribe()
        //parentJob = Job()

        CoroutineScope(foregroundContext+parentJob).launch {
            val result= withContext(backgroundContext){
                run(params)
            }
            onResult(result)
        }
    }

    fun unsubscribe(){
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }
}
abstract class UseCase2<out Type, in Params, in Params2> {
    var backgroundContext: CoroutineContext = Dispatchers.IO
    var foregroundContext: CoroutineContext = Dispatchers.Main

    private var parentJob: Job = Job()

    abstract suspend fun run(params: Params, params2: Params2) : Either<Failure,Type>

    operator fun invoke(params: Params, params2: Params2, onResult: (Either<Failure,Type>)-> Unit={}){
        unsubscribe()
        //parentJob = Job()

        CoroutineScope(foregroundContext+parentJob).launch {
            val result= withContext(backgroundContext){
                run(params,params2)
            }
            onResult(result)
        }
    }

    fun unsubscribe(){
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }
}