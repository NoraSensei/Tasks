package com.norasensei.tasks.presentattion.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

import androidx.lifecycle.ViewModelProvider
import com.norasensei.tasks.di.Dependencies
import com.norasensei.tasks.presentattion.viewModel.MainViewModel
import com.norasensei.tasks.presentattion.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.norasensei.tasks.R
import com.norasensei.tasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	lateinit var binding: ActivityMainBinding
	lateinit var vpAdapter: ViewPagerAdapter
	lateinit var mainViewModel: MainViewModel

	var tabIndex : Int = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

		Dependencies.taskRepository

		mainViewModel.taskLists.observe(this){
			vpAdapter = ViewPagerAdapter(this, it)
			binding.viewPager.adapter = vpAdapter
			TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
				tab.text = it[pos].name
			}.attach()
		}

		binding.addTaskButton.setOnClickListener {
			startActivity(
				mainViewModel.taskLists.value?.get(tabIndex)?.let {
						it1 ->
					TaskActivity.getIntent(this, it1.id)
				}
			)
		}

		mainViewModel.getAllTaskList()

		binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
			override fun onTabSelected(tab: TabLayout.Tab?) {
				tabIndex = tab!!.position
				if (tabIndex == 0) {
					binding.addTaskButton.visibility = View.GONE
				}
				else {
					binding.addTaskButton.visibility = View.VISIBLE
				}
			}

			override fun onTabUnselected(tab: TabLayout.Tab?) {
				return
			}

			override fun onTabReselected(tab: TabLayout.Tab?) {
				return
			}
		})
	}

	override fun onResume() {
		super.onResume()
		mainViewModel.getAllTaskList()
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.main_menu, menu)
		return super.onCreateOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == R.id.edit_list_option) {
			startActivity(
				mainViewModel.taskLists.value?.get(tabIndex)?.let {
						it1 ->
					AddTaskListActivity.getIntent(this, it1)
				}
			)
		}
		else if (item.itemId == R.id.delete_list_option) {
			val taskListId = mainViewModel.taskLists.value?.get(tabIndex)?.id
			mainViewModel.taskLists.value?.toMutableList()?.removeAt(tabIndex)
			taskListId?.let { it1 -> mainViewModel.removeTaskList(it1) }
		}
		else if (item.itemId == R.id.add_list_option) {
			startActivity(
				AddTaskListActivity.getIntent(this)
			)
		}

		return super.onOptionsItemSelected(item)
	}
}