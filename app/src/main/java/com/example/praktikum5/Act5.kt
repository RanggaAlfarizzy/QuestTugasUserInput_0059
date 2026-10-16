package com.example.praktikum5

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import java.util.Calendar

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

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.agnestachyon),
            contentDescription = stringResource(R.string.gambar_header),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.header_height))
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = dimensionResource(R.dimen.card_top_position),
                    bottom = dimensionResource(R.dimen.bottom_content_spacing)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.card_margin)),
                shape = RoundedCornerShape(
                    dimensionResource(R.dimen.card_corner)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(R.dimen.card_elevation)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.form_card)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.content_padding)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.form_title),
                        color = colorResource(R.color.form_purple),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(Modifier.height(dimensionResource(R.dimen.small_spacing)))

                    Text(
                        text = stringResource(R.string.form_subtitle),
                        color = colorResource(R.color.form_subtitle),
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(Modifier.height(dimensionResource(R.dimen.field_spacing)))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.field_spacing)
                        )
                    ) {
                        OutlinedTextField(
                            value = depan,
                            onValueChange = { depan = it },
                            placeholder = {
                                Text(stringResource(R.string.nama_depan))
                            },
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.field_corner)
                            )
                        )

                        OutlinedTextField(
                            value = belakang,
                            onValueChange = { belakang = it },
                            placeholder = {
                                Text(stringResource(R.string.nama_belakang))
                            },
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.field_corner)
                            )
                        )
                    }

                    Spacer(Modifier.height(dimensionResource(R.dimen.field_spacing)))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text(stringResource(R.string.email))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.field_corner)
                        )
                    )

                    Spacer(Modifier.height(dimensionResource(R.dimen.field_spacing)))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.field_spacing)
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = tanggal,
                                onValueChange = {},
                                readOnly = true,
                                placeholder = {
                                    Text(stringResource(R.string.tanggal_lahir))
                                },
                                trailingIcon = {
                                    Text(stringResource(R.string.ikon_kalender))
                                },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true,
                                shape = RoundedCornerShape(
                                    dimensionResource(R.dimen.field_corner)
                                )
                            )

                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable {
                                        val calendar = Calendar.getInstance()

                                        DatePickerDialog(
                                            context,
                                            { _, year, month, day ->
                                                tanggal = "%02d/%02d/%04d".format(
                                                    day, month + 1, year
                                                )
                                            },
                                            calendar.get(Calendar.YEAR),
                                            calendar.get(Calendar.MONTH),
                                            calendar.get(Calendar.DAY_OF_MONTH)
                                        ).show()
                                    }
                            )
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = pengalaman,
                                onValueChange = {},
                                readOnly = true,
                                placeholder = {
                                    Text(stringResource(R.string.experience))
                                },
                                trailingIcon = {
                                    Text(stringResource(R.string.ikon_dropdown))
                                },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true,
                                shape = RoundedCornerShape(
                                    dimensionResource(R.dimen.field_corner)
                                )
                            )

                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable { menu = true }
                            )

                            DropdownMenu(
                                expanded = menu,
                                onDismissRequest = { menu = false }
                            ) {
                                experiences.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(item) },
                                        onClick = {
                                            pengalaman = item
                                            menu = false
                                        }
                                    )
                                }
                            }
                        }
                    }
}