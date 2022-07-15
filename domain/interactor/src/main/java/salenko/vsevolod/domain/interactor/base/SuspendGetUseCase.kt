package salenko.vsevolod.domain.interactor.base

abstract class SuspendGetUseCase<Data> {
    suspend operator fun invoke(): Data = get()

    protected abstract suspend fun get(): Data
}