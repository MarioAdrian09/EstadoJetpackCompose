package com.example.estadojetpackcompose

import WellnessViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
  modifier: Modifier = Modifier,
  wellnessViewModel: WellnessViewModel = viewModel()
) {
  Column(modifier = modifier) {
    StatefulCounter()

    WellnessTasksList(
      list = wellnessViewModel.tasks,
      onCheckedTask = { task, checked ->
        wellnessViewModel.changeTaskChecked(task, checked)
      },
      onCloseTask = { task ->
        wellnessViewModel.remove(task)
      }
    )
  }
}
