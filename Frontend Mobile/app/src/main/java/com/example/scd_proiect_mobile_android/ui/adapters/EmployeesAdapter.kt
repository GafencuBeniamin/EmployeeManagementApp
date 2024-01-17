package com.example.scd_proiect_mobile_android.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.scd_proiect_mobile_android.R
import com.example.scd_proiect_mobile_android.data.entities.Employee
import com.example.scd_proiect_mobile_android.databinding.ItemEmployeeBinding

class EmployeesAdapter(private val listener: EmployeeItemListener) : RecyclerView.Adapter<EmployeeViewHolder>() {

    interface EmployeeItemListener{
        fun onClickedEmployee(employee: Employee)
    }
    val items = ArrayList<Employee>()
    private var selectedItemPosition: Int = RecyclerView.NO_POSITION

    fun setItems(items : ArrayList<Employee>){
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
    fun clearSelection() {
        selectedItemPosition = RecyclerView.NO_POSITION
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding :ItemEmployeeBinding = ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return EmployeeViewHolder(binding,listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int)
        { holder.bind(items[position])

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
class EmployeeViewHolder(private val itemBinding: ItemEmployeeBinding, private val listener: EmployeesAdapter.EmployeeItemListener): RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener{

        private lateinit var employee : Employee

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint
        fun bind(item : Employee){
            this.employee=item
            itemBinding.employeeId.text=employee.id.toString()
            itemBinding.departmentId.text=employee.departmentId.toString()
            itemBinding.managerId.text=employee.managerId.toString()
            itemBinding.email.text=employee.email
            itemBinding.name.text=employee.name
        }

        override fun onClick(v: View?) {
            listener.onClickedEmployee(employee)
        }
        }