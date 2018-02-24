package com.max.wavemobilechallenge.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.max.wavemobilechallenge.ui.viewModel.ProductViewModel;

/**
 * Single product view
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */
public class ProductView extends LinearLayout {

    private Context mContext;
    private TextView nameTextView;
    private TextView priceTextView;


    public ProductView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        LinearLayout mLayout = new LinearLayout(mContext);

        nameTextView = new TextView(mContext);
        nameTextView.setLayoutParams(params);
        nameTextView.setGravity(Gravity.LEFT);
        nameTextView.setTextColor(Color.BLACK);
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        nameTextView.setTypeface(null, Typeface.BOLD);

        priceTextView = new TextView(mContext);
        priceTextView.setLayoutParams(params);
        priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        priceTextView.setGravity(Gravity.RIGHT);

        mLayout.addView(nameTextView);
        mLayout.addView(priceTextView);
        addView(mLayout);

        LinearLayout.LayoutParams mParams = (LayoutParams) mLayout.getLayoutParams();
        mParams.setMargins(50, 50 ,50 ,50);
        mParams.width = LayoutParams.MATCH_PARENT;
        mLayout.setLayoutParams(mParams);

    }

    public void update(ProductViewModel productViewModel){
        nameTextView.setText(productViewModel.mName);
        priceTextView.setText(productViewModel.mPrice);
    }
}
