package com.shu_syu_sh.generic_view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object GenericViewModelFactories {

    private val repositories: MutableMap<Class<out ViewModelProvider.Factory>, ViewModelProvider.Factory> = mutableMapOf()

    fun register(viewModelFactory: ViewModelProvider.Factory) {
        repositories[viewModelFactory::class.java] = viewModelFactory
    }

    fun registerAll(viewModelFactories: Collection<ViewModelProvider.Factory>) {
        for (viewModelFactory in viewModelFactories) {
            register(viewModelFactory)
        }
    }

    fun unregister(clazz: Class<out ViewModelProvider.Factory>): ViewModelProvider.Factory? = repositories.remove(clazz)

    fun clear() = repositories.clear()

    operator fun plusAssign(viewModelFactory: ViewModelProvider.Factory) {
        register(viewModelFactory)
    }

    operator fun plusAssign(viewModelFactories: Collection<ViewModelProvider.Factory>) {
        registerAll(viewModelFactories)
    }

    fun <VM : ViewModel, A> viewModelFactory(constructor: (A) -> VM):
                (A) -> ViewModelProvider.Factory = { arg1 ->
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return constructor(arg1) as T
                }
            }
        }

    fun <VM : ViewModel, A, B> viewModelFactory(constructor: (A, B) -> VM):
                (A, B) -> ViewModelProvider.Factory = { arg1, arg2 ->
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return constructor(arg1, arg2) as T
            }
        }
    }

    fun <VM : ViewModel, A, B, C> viewModelFactory(constructor: (A, B, C) -> VM):
                (A, B, C) -> ViewModelProvider.Factory = { arg1, arg2, arg3 ->
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return constructor(arg1, arg2, arg3) as T
            }
        }
    }

    fun <VM : ViewModel, A, B, C, D> viewModelFactory(constructor: (A, B, C, D) -> VM):
                (A, B, C, D) -> ViewModelProvider.Factory = { arg1, arg2, arg3, arg4 ->
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return constructor(arg1, arg2, arg3, arg4) as T
            }
        }
    }

    fun <VM : ViewModel, A, B, C, D, E> viewModelFactory(constructor: (A, B, C, D, E) -> VM):
                (A, B, C, D, E) -> ViewModelProvider.Factory = { arg1, arg2, arg3, arg4, arg5 ->
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return constructor(arg1, arg2, arg3, arg4, arg5) as T
            }
        }
    }

    fun <VM : ViewModel, A, B, C, D, E, F> viewModelFactory(constructor: (A, B, C, D, E, F) -> VM):
                (A, B, C, D, E, F) -> ViewModelProvider.Factory = { arg1, arg2, arg3, arg4, arg5, arg6 ->
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return constructor(arg1, arg2, arg3, arg4, arg5, arg6) as T
            }
        }
    }

}
