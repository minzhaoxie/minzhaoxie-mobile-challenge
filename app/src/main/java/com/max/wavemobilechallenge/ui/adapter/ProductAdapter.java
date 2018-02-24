package com.max.wavemobilechallenge.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.max.wavemobilechallenge.service.model.Product;
import com.max.wavemobilechallenge.ui.view.ProductView;
import com.max.wavemobilechallenge.ui.viewModel.ProductViewModel;

/**
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */

public class ProductAdapter extends BaseAdapter {

    private Product[] mProducts = null;
    private Context mContext = null;

    public ProductAdapter( Context context){
        this.mContext = context;
    }

    public void setData(Product[] products){
        this.mProducts = products;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(mProducts == null)
            return 0;
        else
            return mProducts.length;
    }

    @Override
    public Object getItem(int position) {
        return mProducts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product product = mProducts[position];
        ProductViewModel productViewModel = new ProductViewModel(product);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = new ProductView(mContext);
            viewHolder.productView = (ProductView) convertView;
            viewHolder.productView.update(productViewModel);
            convertView.setTag(viewHolder);// by using setTag, bond convertView with viewHolder
        }  else {
            viewHolder = (ViewHolder) convertView.getTag(); // find viewHolder with tag
        }

        return convertView;
    }

    class ViewHolder {
        ProductView productView;
    }
}
