package com.example.myapplication.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.GuardianTheme

/**
 * Diálogo de confirmação para ações destrutivas ou críticas do Guardian.
 *
 * Segue as diretrizes do Material 3 e do guia de estilo, apresentando um layout com
 * título, mensagem descritiva e dois botões empilhados (ação principal em destaque vermelho
 * e botão secundário de cancelamento com borda contornada).
 *
 * @param title Título principal do diálogo (ex: "Remover dispositivo?").
 * @param message Mensagem detalhando o contexto ou consequência da ação.
 * @param confirmLabel Texto do botão de confirmação destrutiva (ex: "Confirmar").
 * @param dismissLabel Texto do botão de cancelamento/fechamento (ex: "Cancelar").
 * @param onConfirm Callback executado ao confirmar a ação.
 * @param onDismiss Callback executado ao cancelar ou fechar o diálogo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuardianConfirmDialog(
    title: String,
    message: String,
    confirmLabel: String,
    dismissLabel: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier.semantics { paneTitle = title },
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = onConfirm,
                    modifier = Modifier.fillMaxWidth(),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError,
                    ),
                ) {
                    Text(
                        text = confirmLabel,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                OutlinedButton(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                ) {
                    Text(
                        text = dismissLabel,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Guardian Preview")
@Composable
fun GuardianConfirmDialogPreview() {
    GuardianTheme {
        GuardianConfirmDialog(
            title = "Remover dispositivo?",
            message = "Você tem certeza que deseja remover este dispositivo da sua central?",
            confirmLabel = "Confirmar",
            dismissLabel = "Cancelar",
            onConfirm = {},
            onDismiss = {}
        )
    }
}
