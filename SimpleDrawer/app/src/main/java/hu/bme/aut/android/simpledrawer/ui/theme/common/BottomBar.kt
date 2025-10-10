package hu.bme.aut.android.simpledrawer.ui.theme.common

import android.util.Log.v
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.simpledrawer.R
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.simpledrawer.ui.theme.screen.DrawingMode
import hu.bme.aut.android.simpledrawer.ui.theme.screen.DrawingScreen
import hu.bme.aut.android.simpledrawer.ui.theme.screen.DrawingViewModel

@Composable
fun BottomBar(
    viewModel: DrawingViewModel
) {
    var showStyle by remember { mutableStateOf(false) }
    val drawingMode by viewModel.drawingMode.collectAsState()

    BottomAppBar(
        actions = { //atadunk composable parametereket, amik megjelennek
            Row(    //majd az AppBaron
                modifier = Modifier //OKX6ND
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { showStyle = !showStyle },
                    modifier = Modifier.size(64.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_style),
                        contentDescription = stringResource(id = R.string.style)
                    )
                    //Styles
                    DropdownMenu(
                        expanded = showStyle,
                        onDismissRequest = { showStyle = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(
                                stringResource(id = R.string.point),
                                color = if(drawingMode == DrawingMode.POINT) Color.Magenta else Color.Black
                            )},
                            onClick = {
                                viewModel.setDrawingMode(DrawingMode.POINT)
                                showStyle = false
                            }
                        )   //OKX6ND
                        DropdownMenuItem(
                            text = { Text(
                                stringResource(R.string.line),
                                color = if(drawingMode == DrawingMode.LINE) Color.Magenta else Color.Black
                            )},
                            onClick = {
                                viewModel.setDrawingMode(DrawingMode.LINE)
                                showStyle = false
                            }
                        )
                    }
                }
            }
        },
        containerColor = Color(0xFF6200EE),
    )
}