import androidx.compose.runtime.Composable
import com.example.expe.ui.components.keyboard.layout.KeyboardRow
import com.example.expe.usecase.EditorController

@Composable
fun ShiftedKeyboard(editorController: EditorController) {
    KeyboardRow { // Row-1
        KeyBtn()
        KeyBtn()
        CopyAllBtn { editorController.copyAll() }
        PasteBtn { editorController.paste() }
        CutAllBtn { editorController.cutAll() }
    }
    KeyboardRow { // Row-2
        CursorUpBtn { editorController.cursorUp() }
        FlickBtn('_', '-', '+', '/', '1') { char -> editorController.type(char) }
        FlickBtn('C', 'B', 'A', '(', '2') { char -> editorController.type(char) }
        FlickBtn('F', 'E', 'D', ')', '3') { char -> editorController.type(char) }
        BackspaceBtn { editorController.backspace() }
    }
    KeyboardRow { // Row-3
        CursorLeftBtn { editorController.cursorLeft() }
        FlickBtn('I', 'H', 'G', '[', '4') { char -> editorController.type(char) }
        FlickBtn('L', 'K', 'J', ']', '5') { char -> editorController.type(char) }
        FlickBtn('O', 'N', 'M', '{', '6') { char -> editorController.type(char) }
        CursorRightBtn { editorController.cursorRight() }
    }
    KeyboardRow { // Row-4
        CursorDownBtn { editorController.cursorDown() }
        FlickBtn('R', 'Q', 'P', 'S', '7') { char -> editorController.type(char) }
        FlickBtn('V', 'U', 'T', '}', '8') { char -> editorController.type(char) }
        FlickBtn('Y', 'X', 'W', 'z', '9') { char -> editorController.type(char) }
        SpaceBtn { editorController.space() }
    }
    KeyboardRow { // Row-5
        KeyBtn() // FlickBtn
        FlickBtn(':', '=', ',', ';', '0') { char -> editorController.type(char) }
        ShiftBtn { editorController.toggleShift() }
        FlickBtn('\"', '<', '.', '>', '*') { char -> editorController.type(char) }
        EnterBtn { editorController.enter() }
    }
}