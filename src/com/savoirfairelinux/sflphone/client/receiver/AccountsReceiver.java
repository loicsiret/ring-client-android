package com.savoirfairelinux.sflphone.client.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.savoirfairelinux.sflphone.interfaces.AccountsInterface;
import com.savoirfairelinux.sflphone.service.ConfigurationManagerCallback;

public class AccountsReceiver extends BroadcastReceiver {

    static final String TAG = AccountsReceiver.class.getSimpleName();

    AccountsInterface callback;

    public AccountsReceiver(AccountsInterface client) {
        callback = client;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().contentEquals(ConfigurationManagerCallback.ACCOUNT_STATE_CHANGED)) {
            Log.i(TAG, "Received" + intent.getAction());
            callback.accountStateChanged(intent);
        } else if (intent.getAction().contentEquals(ConfigurationManagerCallback.ACCOUNTS_CHANGED)) {
            Log.i(TAG, "Received" + intent.getAction());
            callback.accountsChanged();

        }

    }
}