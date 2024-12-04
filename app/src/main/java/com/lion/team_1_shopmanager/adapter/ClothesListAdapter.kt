package com.lion.team_1_shopmanager.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lion.team_1_shopmanager.R
import com.lion.team_1_shopmanager.databinding.HomeClothesItemBinding
import com.lion.team_1_shopmanager.model.ShopModel
import com.lion.team_1_shopmanager.util.Value

class ClothesListAdapter(
    private val listener: OnClickConvertListener
): RecyclerView.Adapter<ClothesListAdapter.ClothesViewHolder>() {

    private val items = mutableListOf<ShopModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesViewHolder {
        return ClothesViewHolder(
            HomeClothesItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        ){ position -> listener.onClickItem(items[position].shopIdx) }
    }

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setShopItem(newClothes:List<ShopModel>){
        items.clear()
        items.addAll(newClothes)
        notifyDataSetChanged()
    }

    class ClothesViewHolder(
        private val itemBinding: HomeClothesItemBinding,
        private val onItemClick: (position: Int) -> Unit,
        )
        :RecyclerView.ViewHolder(itemBinding.root){

            init {
                itemBinding.root.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }
        fun bindView(clothes:ShopModel){
            itemBinding.apply {
                if (clothes.clothImage != "")
                    ImagePreView.setImageURI(Uri.parse(clothes.clothImage))
                else
                    ImagePreView.setImageResource(R.drawable.ic_launcher_background)
                clothesBrandTextView.text = clothes.clothDefaultCategory
                clothesNameTextView.text = clothes.clothName
                salesPercentTextView.text = "${clothes.clothDiscountRate}%"
                priceTextView.text = "${Value.calculatePrice(clothes.clothPrice,clothes.clothDiscountRate)}원"
            }

        }
    }
}