package com.jh.sh.jhsdk.service.base;

import android.content.Context;
import android.widget.Toast;

import com.jh.sh.jhsdk.service.JhException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProgressObserver<T> implements Observer<T>, ProgressCancelListener {

    private Context mContext;
    private ObserverOnNextListener<T> mObservableOnNextListener;
    private ObserverOnNextAndErrorListener<T> mObserverOnNextAndErrorListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Disposable disposable;

    public ProgressObserver(Context context, ObserverOnNextListener<T> observableOnNextListener) {
        this.mContext = context;
        this.mObservableOnNextListener = observableOnNextListener;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }

    public ProgressObserver(Context context, ObserverOnNextAndErrorListener<T> observerOnNextAndErrorListener) {
        this.mContext = context;
        this.mObserverOnNextAndErrorListener = observerOnNextAndErrorListener;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if (mObservableOnNextListener != null) {
            mObservableOnNextListener.onNext(t);
        }
        if (mObserverOnNextAndErrorListener != null) {
            mObserverOnNextAndErrorListener.onNext(t);
        }
    }

    @Override
    public void onError(Throwable t) {
        dismissProgressDialog();
        if (mObserverOnNextAndErrorListener != null) {
            if (t instanceof JhException) {
                mObserverOnNextAndErrorListener.onError((JhException) t);
            } else {
                mObserverOnNextAndErrorListener.onError(new JhException(JhException.NETWORK_EXCEPTION, t));
            }
        } else {
//            Toast.makeText(mContext, "error:" + t.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(mContext, "error:" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }

    @Override
    public void onCancelProgress() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }
}
