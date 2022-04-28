package id.phephen.firstdepedencyinjectionkoin.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.phephen.firstdepedencyinjectionkoin.R
import id.phephen.firstdepedencyinjectionkoin.data.model.User

/**
 * Created by Phephen on 25/01/2022.
 */
class MainAdapter (private val users: ArrayList<User>): RecyclerView.Adapter<MainAdapter.DataViewHolder>(){

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textUser = itemView.findViewById<TextView>(R.id.textViewUserName)
        private val textEmail = itemView.findViewById<TextView>(R.id.textViewUserEmail)
        private val imageView = itemView.findViewById<ImageView>(R.id.imageViewAvatar)

        fun bind(user: User) {
            textUser.text = user.name
            textEmail.text = user.email
            Glide.with(imageView.context)
                .load(user.avatar)
                .into(imageView)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent, false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}