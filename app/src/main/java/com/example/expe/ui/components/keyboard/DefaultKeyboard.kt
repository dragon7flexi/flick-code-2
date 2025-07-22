import androidx.compose.runtime.Composable
import com.example.expe.ui.components.keyboard.buttons.CursorToLineEndBtn
import com.example.expe.ui.components.keyboard.buttons.CursorToLineStartBtn
import com.example.expe.ui.components.keyboard.buttons.UnIndentBtn
import com.example.expe.ui.components.keyboard.layout.KeyboardRow
import com.example.expe.usecase.EditorController

@Composable
fun DefaultKeyboard(editorController: EditorController) {
    KeyboardRow { // Row-1
        UnIndentBtn { editorController.unIndent() }
        CursorToLineStartBtn { editorController.cursorToLineStart() }
        CopyAllBtn { editorController.copyAll() }
        CursorToLineEndBtn { editorController.cursorToLineEnd() }
        KeyBtn()
    }
    KeyboardRow { // Row-2
        CursorUpBtn { editorController.cursorUp() }
        FlickBtn('_', '-', '+', '/', '1') { char -> editorController.type(char) }
        FlickBtn('c', 'b', 'a', '(', '2') { char -> editorController.type(char) }
        FlickBtn('f', 'e', 'd', ')', '3') { char -> editorController.type(char) }
        BackspaceBtn { editorController.backspace() }
    }
    KeyboardRow { // Row-3
        CursorLeftBtn { editorController.cursorLeft() }
        FlickBtn('i', 'h', 'g', '[', '4') { char -> editorController.type(char) }
        FlickBtn('l', 'k', 'j', ']', '5') { char -> editorController.type(char) }
        FlickBtn('o', 'n', 'm', '{', '6') { char -> editorController.type(char) }
        CursorRightBtn { editorController.cursorRight() }
    }
    KeyboardRow { // Row-4
        CursorDownBtn { editorController.cursorDown() }
        FlickBtn('r', 'q', 'p', 's', '7') { char -> editorController.type(char) }
        FlickBtn('v', 'u', 't', '}', '8') { char -> editorController.type(char) }
        FlickBtn('y', 'x', 'w', 'z', '9') { char -> editorController.type(char) }
        SpaceBtn { editorController.space() }
    }
    KeyboardRow { // Row-5
        KeyBtn()
        FlickBtn(':', '=', ',', ';', '0') { char -> editorController.type(char) }
        ShiftBtn { editorController.toggleShift() }
        FlickBtn('\"', '<', '.', '>', '*') { char -> editorController.type(char) }
        EnterBtn { editorController.enter() }
    }
}