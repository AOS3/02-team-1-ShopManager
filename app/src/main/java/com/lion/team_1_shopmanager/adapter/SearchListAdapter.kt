package com.lion.team_1_shopmanager.adapter

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.lion.team_1_shopmanager.MainActivity
import com.lion.team_1_shopmanager.databinding.HomeClothesItemBinding
import com.lion.team_1_shopmanager.model.ShopModel
import com.lion.team_1_shopmanager.util.Value.calculatePrice

class SearchListAdapter(val mainActivity: MainActivity) :
    RecyclerView.Adapter<SearchListAdapter.SearchListViewHolder>() {
    var selectedImageUri: Uri? = null

    var clothList = mutableListOf<ShopModel>()

    fun refreshList(newClothList: MutableList<ShopModel>) {
        clothList = newClothList
        notifyDataSetChanged()
    }



    // ViewHolder
    inner class SearchListViewHolder(val itemBinding: HomeClothesItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val homeClothesItemBinding =
            HomeClothesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val searchListViewHolder = SearchListViewHolder(homeClothesItemBinding)
        homeClothesItemBinding.root.setOnClickListener {
            val dataBundle = Bundle()
            dataBundle.putInt("shopIdx", clothList[searchListViewHolder.adapterPosition].shopIdx)
            mainActivity.replaceFragment(
                MainActivity.FragmentName.SHOW_FRAGMENT,
                true,
                true,
                dataBundle
            )
        }
        return searchListViewHolder
    }

    override fun getItemCount(): Int {
        return clothList.size
    }

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        holder.itemBinding.apply {
            clothesNameTextView.text = clothList[position].clothName
            clothesBrandTextView.text = clothList[position].clothDefaultCategory
            salesPercentTextView.text = "${clothList[position].clothDiscountRate}%"
            priceTextView.text = "${calculatePrice(clothList[position].clothPrice,clothList[position].clothDiscountRate)}원"

            // 내부 저장소 URI 설정
            selectedImageUri = clothList[position].clothImage.toUri()
            ImagePreView.setImageURI(Uri.parse(selectedImageUri.toString()))
        }
    }
}