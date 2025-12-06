package com.example.expe.usecase.code.executor

import com.chaquo.python.Python

class PythonExecutor {

    fun run(code: String, stdin: String): Result {
        val py = Python.getInstance()
        val module = py.getModule("runner")

        val resultJson = module.callAttr("run_code", code, stdin).toString()
        val jsonObject = org.json.JSONObject(resultJson)
        val stdout = jsonObject.getString("stdout")
        val stderr = jsonObject.getString("stderr")

        return Result(stdout, stderr)
    }

    data class Result(
        val stdout: String,
        val stderr: String
    )
}
