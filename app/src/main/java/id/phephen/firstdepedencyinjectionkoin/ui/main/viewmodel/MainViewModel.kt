package id.phephen.firstdepedencyinjectionkoin.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.phephen.firstdepedencyinjectionkoin.data.model.User
import id.phephen.firstdepedencyinjectionkoin.data.repository.MainRepository
import id.phephen.firstdepedencyinjectionkoin.utils.NetworkHelper
import id.phephen.firstdepedencyinjectionkoin.utils.Resource
import kotlinx.coroutines.launch

/**
 * Created by Phephen on 25/01/2022.
 */
class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
    ) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}