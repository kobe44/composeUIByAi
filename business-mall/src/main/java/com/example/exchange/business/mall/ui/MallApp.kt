package com.example.exchange.business.mall.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.exchange.business.mall.MallUiState
import com.example.exchange.business.mall.MallViewModel
import com.example.exchange.business.mall.R
import com.example.exchange.business.mall.data.CartLine
import com.example.exchange.business.mall.data.Product

private object MallRoutes {
    const val Login = "login"
    const val Products = "products"
    const val Cart = "cart"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MallApp(vm: MallViewModel = viewModel()) {
    val uiState by vm.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.error) {
        val msg = uiState.error ?: return@LaunchedEffect
        snackbarHostState.showSnackbar(msg)
        vm.consumeError()
    }

    val start = if (uiState.isLoggedIn) MallRoutes.Products else MallRoutes.Login
    val backStack by navController.currentBackStackEntryAsState()
    val route = backStack?.destination?.route ?: start

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            MallTopBar(
                route = route,
                cartCount = uiState.cartLines.sumOf { it.quantity },
                onCart = { navController.navigate(MallRoutes.Cart) },
                onLogout = {
                    vm.logout()
                    navController.navigate(MallRoutes.Login) {
                        popUpTo(MallRoutes.Products) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() },
            )
        },
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = start,
            modifier = Modifier.padding(padding),
        ) {
            composable(MallRoutes.Login) {
                LoginRoute(
                    loading = uiState.loading,
                    onLogin = { u, p -> vm.login(u, p) },
                )
            }
            composable(MallRoutes.Products) {
                ProductListRoute(
                    uiState = uiState,
                    onAdd = { vm.addToCart(it) },
                )
            }
            composable(MallRoutes.Cart) {
                CartRoute(
                    lines = uiState.cartLines,
                    total = vm.cartTotal(),
                    onQty = { id, q -> vm.setQuantity(id, q) },
                    onRemove = { vm.removeLine(it) },
                )
            }
        }
    }

    LaunchedEffect(uiState.isLoggedIn, route) {
        if (uiState.isLoggedIn && route == MallRoutes.Login) {
            navController.navigate(MallRoutes.Products) {
                popUpTo(MallRoutes.Login) { inclusive = true }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MallTopBar(
    route: String,
    cartCount: Int,
    onCart: () -> Unit,
    onLogout: () -> Unit,
    onBack: () -> Unit,
) {
    when (route) {
        MallRoutes.Login -> {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.mall_login_title)) },
            )
        }
        MallRoutes.Products -> {
            TopAppBar(
                title = { Text(stringResource(R.string.mall_products)) },
                actions = {
                    TextButton(onClick = onCart) {
                        Text(
                            stringResource(R.string.mall_cart) +
                                if (cartCount > 0) " ($cartCount)" else "",
                        )
                    }
                    TextButton(onClick = onLogout) {
                        Text(stringResource(R.string.mall_logout))
                    }
                },
            )
        }
        MallRoutes.Cart -> {
            TopAppBar(
                title = { Text(stringResource(R.string.mall_cart)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("←")
                    }
                },
            )
        }
    }
}

@Composable
private fun LoginRoute(
    loading: Boolean,
    onLogin: (String, String) -> Unit,
) {
    var user by remember { mutableStateOf("mor_2314") }
    var pass by remember { mutableStateOf("83r5^_") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.mall_login_api_hint),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.mall_demo_account),
            style = MaterialTheme.typography.bodySmall,
        )
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.mall_username)) },
            singleLine = true,
        )
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.mall_password)) },
            singleLine = true,
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { onLogin(user.trim(), pass) },
            enabled = !loading,
            modifier = Modifier.fillMaxWidth(),
        ) {
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(22.dp),
                    strokeWidth = 2.dp,
                )
            } else {
                Text(stringResource(R.string.mall_login))
            }
        }
    }
}

@Composable
private fun ProductListRoute(
    uiState: MallUiState,
    onAdd: (Product) -> Unit,
) {
    when {
        uiState.loading && uiState.products.isEmpty() -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator()
                Spacer(Modifier.height(12.dp))
                Text(stringResource(R.string.mall_loading))
            }
        }
        uiState.products.isEmpty() -> {
            Text(
                stringResource(R.string.mall_empty_products),
                modifier = Modifier.padding(24.dp),
            )
        }
        else -> {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                item {
                    Text(
                        text = stringResource(R.string.mall_cart_local_hint),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                items(uiState.products, key = { it.id }) { p ->
                    ProductCard(product = p, onAdd = { onAdd(p) })
                }
            }
        }
    }
}

@Composable
private fun ProductCard(product: Product, onAdd: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Fit,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp),
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "¥${"%.2f".format(product.price)} · ${product.category}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Button(onClick = onAdd) {
                Text(stringResource(R.string.mall_add))
            }
        }
    }
}

@Composable
private fun CartRoute(
    lines: List<CartLine>,
    total: Double,
    onQty: (Int, Int) -> Unit,
    onRemove: (Int) -> Unit,
) {
    if (lines.isEmpty()) {
        Text(
            stringResource(R.string.mall_empty_cart),
            modifier = Modifier.padding(24.dp),
        )
        return
    }
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(lines, key = { it.productId }) { line ->
                CartLineRow(
                    line = line,
                    onMinus = { onQty(line.productId, line.quantity - 1) },
                    onPlus = { onQty(line.productId, line.quantity + 1) },
                    onRemove = { onRemove(line.productId) },
                )
            }
        }
        Text(
            text = stringResource(R.string.mall_total, total),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
}

@Composable
private fun CartLineRow(
    line: CartLine,
    onMinus: () -> Unit,
    onPlus: () -> Unit,
    onRemove: () -> Unit,
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = line.image,
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Fit,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
            ) {
                Text(
                    line.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    "¥${"%.2f".format(line.price)} × ${line.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextButton(onClick = onMinus) { Text("−") }
                Text("${line.quantity}")
                TextButton(onClick = onPlus) { Text("+") }
            }
            TextButton(onClick = onRemove) {
                Text("删")
            }
        }
    }
}
