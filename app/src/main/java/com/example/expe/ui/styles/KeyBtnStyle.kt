import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import com.example.expe.ui.config.ColorOf
import com.example.expe.ui.config.Dimens

fun Modifier.keyBtnStyle(): Modifier = this
    .width(Dimens.KeyBtnWidth)
    .height(Dimens.KeyBtnHeight)
    .background(
        color = ColorOf.KeyBtn,
        shape = RoundedCornerShape(Dimens.KeyBtnCornerRadius),
    )