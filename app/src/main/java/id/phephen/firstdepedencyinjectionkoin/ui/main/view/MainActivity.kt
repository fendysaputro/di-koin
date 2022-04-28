package id.phephen.firstdepedencyinjectionkoin.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.phephen.firstdepedencyinjectionkoin.R
import id.phephen.firstdepedencyinjectionkoin.data.model.User
import id.phephen.firstdepedencyinjectionkoin.ui.main.adapter.MainAdapter
import id.phephen.firstdepedencyinjectionkoin.ui.main.viewmodel.MainViewModel
import id.phephen.firstdepedencyinjectionkoin.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var rvData: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val mainViewModel : MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
        setupObserver()
    }

    private fun setUI() {
        rvData = findViewById(R.id.rv_data)
        progressBar = findViewById(R.id.progress_bar)

        rvData.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        rvData.addItemDecoration(
            DividerItemDecoration(
                rvData.context,
                (rvData.layoutManager as LinearLayoutManager).orientation
            )
        )
        rvData.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    rvData.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    rvData.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}