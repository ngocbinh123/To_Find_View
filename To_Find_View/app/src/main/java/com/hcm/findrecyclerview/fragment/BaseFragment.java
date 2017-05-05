package com.hcm.findrecyclerview.fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.hcm.findrecyclerview.R;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class BaseFragment extends Fragment {
    protected int mResLayoutId = 0;
    protected String TAG = getClass().getSimpleName();
//    protected HashMap<String, Object> mDataTransferMapTmp;
//    public void goToFragment(android.support.v4.app.Fragment fragment){
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
//                .replace(R.id.fragment,fragment)
//                .addToBackStack(null).commit();
//    }
    public int getResLayoutId() {
        return mResLayoutId;
    }

    public void setLayout(int resLayoutId) {
        mResLayoutId = resLayoutId;
    }

    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    public void goToActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }


    /**
     * setup data transfer with key and value, this data is auto cleaned when destroy. this data is used to tranfer data between fragments
     * @param key key of data
     * @param data real data to transfer to this fragment.
     */
//    public void setDataTransfer(String key, Object data) {
//        if (mDataTransferMapTmp == null) {
//            mDataTransferMapTmp = new HashMap<>();
//        }
//        mDataTransferMapTmp.put(key, data);
//        if (getActivity() == null) {
//            //we wait for activity created
//            return;
//        }
//        String newKey = createArgumentKey(key);
//        FDataTransferManager.get(getContext()).putData(newKey, data);
//    }
//
//    public Object getDataTransfer(String key) {
//        if (mDataTransferMapTmp != null && mDataTransferMapTmp.containsKey(key)) {
//            return mDataTransferMapTmp.get(key);
//        }
//        String newKey = createArgumentKey(key);
//        return FDataTransferManager.get(getContext()).getData(newKey);
//    }



    /**
     * build unique id
     * @return
     */
    public String getFragmentKey() {
        return getClass().getName() + "_" + getId() + "_" + getTag();
    }

    /**
     * create unique key for this fragment
     * @return
     */
    public String createArgumentKey(String key) {
        return getFragmentKey() + "_" + key;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
