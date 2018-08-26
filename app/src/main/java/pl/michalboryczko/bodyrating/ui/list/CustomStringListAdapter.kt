package pl.michalboryczko.bodyrating.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pl.michalboryczko.bodyrating.R
import pl.michalboryczko.bodyrating.model.StringListElement

/**
 * Created on 21.08.2018.
 */
class CustomStringListAdapter(
	private val list: List<StringListElement>
): RecyclerView.Adapter<CustomStringListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
		val v = LayoutInflater.from(parent.context).inflate(R.layout.string_item, parent, false)
		return ViewHolder(v)
	}

	override fun getItemCount(): Int = list.count()

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val item = list[position]

		holder.itemHeader.visibility = if(item.isHeader) View.VISIBLE else View.GONE
		holder.itemHeader.text = item.headerName
		holder.itemBody.text = item.bodyName

	}

	inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
		@BindView(R.id.itemHeader) lateinit var itemHeader: TextView
		@BindView(R.id.itemBody) lateinit var itemBody: TextView
		@BindView(R.id.arrow) lateinit var arrow: ImageView
		init { ButterKnife.bind(this, itemView)}

	}
}