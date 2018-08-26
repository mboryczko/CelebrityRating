package pl.michalboryczko.bodyrating.ui.rate.impl

import android.content.Context
import android.widget.LinearLayout
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
import pl.michalboryczko.bodyrating.R
import pl.michalboryczko.bodyrating.model.GalleryItem

class ViewPagerAdapter(
        val items: MutableList<String>,
        val onGalleryItemClickListener: OnGalleryItemClick? = null) : PagerAdapter() {

    interface OnGalleryItemClick {
        fun onGalleryItemClick(position: Int)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun getCount(): Int {
        return items.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.photo_item, container, false)
        val image = view.findViewById(R.id.item_image) as ImageView

        Glide.with(container.context)
                .load(items[position])
                .into(image)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}