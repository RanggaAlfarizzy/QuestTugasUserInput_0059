package com.example.praktikum5

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
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

                    Spacer(Modifier.height(dimensionResource(R.dimen.skill_spacing)))

                    Text(
                        text = stringResource(R.string.pilih_skill),
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(R.color.form_text),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(android, { android = it })
                            Text(
                                stringResource(R.string.skill_android),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(uiux, { uiux = it })
                            Text(
                                stringResource(R.string.skill_uiux),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(web, { web = it })
                            Text(
                                stringResource(R.string.skill_web),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }

                    Spacer(Modifier.height(dimensionResource(R.dimen.button_spacing)))

                    val skillText = skills.joinToString().ifEmpty {
                        stringResource(R.string.skill_kosong)
                    }

                    val pesan = stringResource(R.string.toast_title) + "\n" +
                            stringResource(R.string.data_nama, depan, belakang) + "\n" +
                            stringResource(R.string.data_email, email) + "\n" +
                            stringResource(R.string.data_tanggal, tanggal) + "\n" +
                            stringResource(R.string.data_pengalaman, pengalaman) + "\n" +
                            stringResource(R.string.data_skill, skillText)

                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = pesan,
                                    duration = SnackbarDuration.Long
                                )
                            }
                        },
                        enabled = depan.isNotBlank() &&
                                belakang.isNotBlank() &&
                                email.isNotBlank() &&
                                tanggal.isNotBlank() &&
                                pengalaman.isNotBlank() &&
                                (android || uiux || web),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(R.dimen.button_height)),
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.button_corner)
                        )
                    ) {
                        Text(stringResource(R.string.proceed))
                    }
                }
            }
        }