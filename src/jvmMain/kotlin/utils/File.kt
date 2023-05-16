package utils

import models.Data
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

object File {

    fun getFileAsset(dataFile: Data): ArrayList<Int> {
        val fileName = dataFile.fileName
        val filePath = Paths.get(getDownloadSystemDir(), fileName)

        return if (Files.exists(filePath)) {
            transformFileAssetToArrayList(filePath.toFile())
        } else {
            createFileAsset(dataFile)
        }
    }

    private fun createFileAsset(dataFile: Data): ArrayList<Int> {
        val fileName = "${getDownloadSystemDir()}/${dataFile.fileName}"
        val file = File(fileName)

        saveFileToDisk(file, dataFile.value)

        return transformFileAssetToArrayList(file)
    }

    private fun transformFileAssetToArrayList(file: File): ArrayList<Int> {
        val arrayList = arrayListOf<Int>()

        file.forEachLine { line ->

            val intValue = line.toIntOrNull()

            if (intValue != null) {
                arrayList.add(intValue)
            } else {
                println("Invalid integer value found at line: $line")
            }
        }

        return arrayList
    }

    private fun saveFileToDisk(file: File, content: Int) {
        try {
            val fileWriter = FileWriter(file)

            fileWriter.appendText(content)
            fileWriter.close()

        } catch (e: Exception) {
            println("An error occurred while saving the file: ${e.message}")
        }
    }

    private fun FileWriter.appendText(content: Int) {
        (0..content).forEach { _ ->
            appendLine(Random().nextInt(content).toString())
        }
    }

    private fun getDownloadSystemDir(): String {
        val os = System.getProperty("os.name").lowercase(Locale.getDefault())
        val userHome = System.getProperty("user.home")

        return when {
            os.contains(other = "win") -> {
                Paths.get(userHome, "Downloads").toString()
            }
            os.contains(other = "mac") -> {
                Paths.get(userHome, "Downloads").toString()
            }
            else -> {
                Paths.get(userHome, "Downloads").toString()
            }
        }
    }
}