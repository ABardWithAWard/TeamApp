package com.example.TeamApp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.TeamApp.R
import com.example.ui.theme.googleAuthStyle

@Composable
fun GoogleLoginButton( modifier: Modifier) {
    val textValue = remember { mutableStateOf("") }
    val viewModel: LoginViewModel = viewModel()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp
    val width = configuration.screenWidthDp.dp
    Button(
        onClick = { viewModel.signInWithGoogle(context) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.googleicon), contentDescription = "googleRegister", contentScale = ContentScale.Fit,
                modifier = Modifier.size(28.dp))
            Box(
                modifier = Modifier
                    .weight(1f) // Take up remaining space on the left
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Zaloguj się przez Google",
                    style = googleAuthStyle
                )
            }
        }
    }
}