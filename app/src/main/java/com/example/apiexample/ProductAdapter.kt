package com.example.apiexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiexample.model.Product

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>
): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false))
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.tvProductName.text = product.prName
        holder.tvProductPrice.text = product.prPrice
        Glide.with(context).load(product.prImage).into(holder.ivProductImage)
    }
}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
    val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
    val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
}