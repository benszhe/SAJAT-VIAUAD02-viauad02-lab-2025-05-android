package hu.bme.aut.android.simpledrawer.ui.theme.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.simpledrawer.R

@Composable
fun BottomBar() {
    BottomAppBar(
        actions = { //atadunk composable parametereket, amik megjelennek
            Row(    //majd az AppBaron
                modifier = Modifier //OKX6ND
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(64.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_style),
                        contentDescription = stringResource(id = R.string.style)
                    )
                    //Styles
                }
            }
        },
        containerColor = Color(0xFF6200EE),
    )
}