import json
from io import StringIO
import sys

def run_code(code, stdin_text):
    sys.stdin = StringIO(stdin_text)

    stdout_capture = StringIO()
    stderr_capture = StringIO()

    old_stdout = sys.stdout
    old_stderr = sys.stderr
    sys.stdout = stdout_capture
    sys.stderr = stderr_capture

    try:
        exec(code, {})
    except Exception as e:
        print(e, file=sys.stderr)
    finally:
        sys.stdout = old_stdout
        sys.stderr = old_stderr

    result = {
        "stdout": stdout_capture.getvalue(),
        "stderr": stderr_capture.getvalue()
    }
    return json.dumps(result)
