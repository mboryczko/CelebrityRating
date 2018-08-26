package pl.michalboryczko.bodyrating.commons


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.ButterKnife
import butterknife.OnClick

import android.view.LayoutInflater
import pl.michalboryczko.bodyrating.R


/**
 * Created by ${michal_boryczko} on 17.05.2018.
 */
class StarsAdapter(
        val context: Context,
        val starsNumber: Int = 10): RecyclerView.Adapter<StarsAdapter.ViewHolder>() {

    var itemList: MutableList<Boolean> = mutableListOf()
    var mark = 0

    init {
        for(i in 0 until starsNumber)
            itemList.add(false)
    }


    fun getSelectedStar(): Int{
        var counter = 0
        for(i in 0 until starsNumber){
            if(itemList[i])
                counter++
        }
        return counter
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        if(item)
            holder.starImageView.setImageResource(R.drawable.ic_rate_star_filled)
        else
            holder.starImageView.setImageResource(R.drawable.ic_rate_star)
    }

    override fun getItemCount(): Int {
        return starsNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view = parent.inflate(R.layout.star_item)

        val rootView = LayoutInflater.from(context).inflate(R.layout.star_item, parent, false)


        //return ViewHolder(view)
        return ViewHolder(rootView)
    }



    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val starImageView = itemView.findViewById<ImageView>(R.id.starImageView)


        init {
            ButterKnife.bind(this, itemView)
        }

        @OnClick(R.id.starImageView)
        fun onItemClick() {
            mark = adapterPosition + 1
            for(i in 0 until starsNumber)
                itemList[i] = i <= adapterPosition


            notifyDataSetChanged()
        }

    }

}