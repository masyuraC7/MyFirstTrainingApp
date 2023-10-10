package com.mc7.firstapptry.ui.homemenu.adapter

import androidx.core.util.Pair
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mc7.firstapptry.data.local.entity.Hero
import com.mc7.firstapptry.databinding.ItemRowHeroBinding
import com.mc7.firstapptry.ui.DetailHeroActivity

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    //callback options
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]

        Glide.with(holder.itemView.context).load(photo)
            .circleCrop()
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
//            callback option
//            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])

            val intentToDetail = Intent(holder.itemView.context, DetailHeroActivity::class.java)
            intentToDetail.putExtra("Hero", listHero[position])
            // no animate
//            holder.itemView.context.startActivity(intentToDetail)

            //with animate
            val optionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    holder.itemView.context as Activity,
                    Pair(holder.binding.imgItemPhoto, "profile"),
                    Pair(holder.binding.tvItemName, "name"),
                    Pair(holder.binding.tvItemDescription, "description"),
                )

            holder.itemView.context.startActivity(
                intentToDetail, optionsCompat.toBundle()
            )

            // transtition explode
//            holder.itemView.context.startActivity(
//                intentToDetail,
//                ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    holder.itemView.context as Activity
//                ).toBundle()
//            )
        }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

    //callback options
//    interface OnItemClickCallback {
//        fun onItemClicked(data: Hero)
//    }
}
