package com.max.wavemobilechallenge.ui.viewModel;

import com.max.wavemobilechallenge.service.model.Product;
import java.text.NumberFormat;

/**
 * viewModel for ProductView
 * Project name: WaveMobileChallenge
 * Created by Max on 2018-02-23.
 */

public class ProductViewModel {

    public String mName;
    public String mPrice;

    public ProductViewModel(Product product){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        mName = product.getName();
        mPrice = format.format(product.getPrice());
    }
}
