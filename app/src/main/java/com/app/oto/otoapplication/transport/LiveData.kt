package com.app.oto.otoapplication.transport

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

object transportCarViewModel :ViewModel(){
    var liveDataOrders = MutableLiveData<TransportCarBean>()
}