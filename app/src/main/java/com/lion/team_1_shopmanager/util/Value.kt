package com.lion.team_1_shopmanager.util

/**
 * class Value{
 *
 *     companion object{
 *
 *     }
 * }
 */
object Value {
    val DETAIL_CATEGORY_MAP = ClothCategory.entries.fold(mutableMapOf<String, Int>()){ map, clothCategory->
        clothCategory.apply { map[category] = details }
        map
    }

    // 할인율 계산
    fun calculatePrice(originalPrice: Int, discountRate: Int): Int {
        return originalPrice - ((originalPrice/100) * discountRate)
    }
}

