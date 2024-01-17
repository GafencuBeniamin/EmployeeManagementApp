package com.example.scd_proiect_mobile_android.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.scd_proiect_mobile_android.R
import com.example.scd_proiect_mobile_android.data.entities.Department
import com.example.scd_proiect_mobile_android.databinding.ItemDepartmentBinding

class DepartmentsAdapter(private val listener: DepartmentItemListener) : RecyclerView.Adapter<DepartmentViewHolder>() {

    interface DepartmentItemListener{
        fun onClickedDepartment(department: Department)
    }
    val items = ArrayList<Department>()
    private var selectedItemPosition: Int = RecyclerView.NO_POSITION


    fun setItems(items : ArrayList<Department>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setSelectedItem(position: Int) {
        val previousSelected = selectedItemPosition
        selectedItemPosition = position
        notifyItemChanged(previousSelected)
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val binding :ItemDepartmentBinding = ItemDepartmentBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return DepartmentViewHolder(binding,listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        holder.bind(items[position])

        val isSelected = position == selectedItemPosition
        if (isSelected) {
            // Set the background color for the selected item
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.grey
                )
            )
        } else {
            // Reset the background color for non-selected items
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    android.R.color.transparent
                )
            )
        }
    }

}
class DepartmentViewHolder(private val itemBinding: ItemDepartmentBinding, private val listener: DepartmentsAdapter.DepartmentItemListener): RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener{

        private lateinit var department : Department

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint
        fun bind(item : Department){
            this.department=item
            itemBinding.departmentId.text=item.id.toString()
            itemBinding.departmentParentId.text=item.parentId.toString()
            itemBinding.departmentDescription.text=item.description
        }

        override fun onClick(v: View?) {
            listener.onClickedDepartment(department)
        }
        }