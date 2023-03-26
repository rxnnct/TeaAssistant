package ru.rxnnct.teaassistant.presentation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.rxnnct.teaassistant.R
import ru.rxnnct.teaassistant.databinding.TeaCardListItemBinding
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard

class TeaCardsRecyclerViewAdapter : ListAdapter<TeaCard, TeaCardsRecyclerViewAdapter.Holder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tea_card_list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = TeaCardListItemBinding.bind(view)

        fun bind(item: TeaCard) = with(binding) {
            tvTeaName.text = item.name
            tvTeaType.text = item.type
            tvTeaOrigin.text = tvTeaOrigin.text.toString() + item.origin
        }
    }

    class Comparator : DiffUtil.ItemCallback<TeaCard>(){
        override fun areItemsTheSame(oldItem: TeaCard, newItem: TeaCard): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TeaCard, newItem: TeaCard): Boolean {
            return oldItem == newItem
        }
    }
}