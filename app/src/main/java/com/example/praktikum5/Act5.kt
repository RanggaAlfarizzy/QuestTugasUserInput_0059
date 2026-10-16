package com.example.praktikum5

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

@Composable
fun Act5(modifier: Modifier = Modifier) {
    var depan by remember { mutableStateOf("") }
    var belakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }

    var android by remember { mutableStateOf(false) }
    var uiux by remember { mutableStateOf(false) }
    var web by remember { mutableStateOf(false) }
    var menu by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val skills = listOfNotNull(
        if (android) stringResource(R.string.skill_android) else null,
        if (uiux) stringResource(R.string.skill_uiux) else null,
        if (web) stringResource(R.string.skill_web) else null
    )

    val experiences = listOf(
        stringResource(R.string.pengalaman_pemula),
        stringResource(R.string.pengalaman_menengah),
        stringResource(R.string.pengalaman_ahli)
    )
}